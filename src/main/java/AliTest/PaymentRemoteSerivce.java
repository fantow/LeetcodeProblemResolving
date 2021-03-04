package AliTest;

import java.util.*;
import java.util.concurrent.*;

public class PaymentRemoteSerivce {

    private static Integer PROCESSORSNUM = Runtime.getRuntime().availableProcessors();

    private static Integer MAXBLOINGQUEUECAPACITY = 10;

    private static Integer MAXCACHECAPACITY = 1024;

    // Error状态码，这里可以单独写成一个Enum类
    // userId错误
    private static String USERIDERROR = "0001";

    // 调用API超时的错误代码
    private static String TIMEOUT = "0002";



    // 这里也可以单独写成一个配置类
    // 调用API的最大timeout
    private static long APICALLEDTIMEOUT = 1000L;


    // 四种需要查询的支付方式
//    余额、红包、优惠券，代金券
    private static List<String> payments = new ArrayList<>(4);

    static{
        payments.add("余额");
        payments.add("红包");
        payments.add("优惠券");
        payments.add("代金券");
    }

    // 阻塞队列大小，可以按照机器或者业务需求修改
    private static BlockingQueue blockingQueue = new LinkedBlockingQueue(MAXBLOINGQUEUECAPACITY);

    // 暴露的服务的接口
    private static OtherAPI api = new OtherAPI();


    // 假设可能存在来不及执行的任务，采用BlockingQueue先存储
    // 并且为线程池的线程指定名字
    private ExecutorService executor = new ThreadPoolExecutor(PROCESSORSNUM, PROCESSORSNUM, 0,
            TimeUnit.MILLISECONDS, blockingQueue, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"PaymentRemoteService - searchThread");
        }
    });

    // 采用LRU的缓存，防止Map过大，撑爆内存
    private Map<String,List<ConsultResult>> cacheMap = new LinkedHashMap<String,List<ConsultResult>>
                            (MAXCACHECAPACITY,0.75f,true);


    // 需要考虑到：超时时间，尽快返回，少用更多的资源
    // 需要暴露的接口
    public Result getUserPaymentList(String userId) throws ExecutionException, InterruptedException {
        // 先进行userId判断
        // 如果userId错误，封装结果后直接返回
        if(!ValidateClass.isValidateUser(userId)){
            Result result = new Result();
            result.isSuccess = false;
            result.errorCode = USERIDERROR;

            return result;
        }

        // 尝试是否可以从缓存中获取
        if(cacheMap.containsKey(userId)){
            Result result = new Result();
            result.isSuccess = true;
            result.list = cacheMap.get(userId);

            return result;
        }


        Map<String,Future<ConsultResult>> futureMap = new HashMap<>();
//        Map<String,ConsultResult> resultMap = new HashMap<>();

        // 最后结果的封装
        List<ConsultResult> resultList = new ArrayList<>(4);

        // 采用多线程方式去查询结果
        // 因为每种查询都需要单独调用ConsultResult isEnabled(String paymentType)
        // 假设该方法提供者可以支持足够大的QPS
        for(String payment : payments){
            Future<ConsultResult> future = executor.submit(new Callable<ConsultResult>() {
                @Override
                public ConsultResult call() throws Exception {
                    // 不知道api是否有自己的timeout机制，这里假设没有，我自己实现
                    long startTime = System.currentTimeMillis();

                    ConsultResult consultResult = api.isEnable(payment);

                    // 检测超时，因为只要api返回就会结束阻塞，从而跳出
                    if(System.currentTimeMillis() - startTime < APICALLEDTIMEOUT){
                        return consultResult;
                    }

                    // 超时时间内没返回，直接自己返回一个失败ConsultResult
                    ConsultResult timeoutConsultResult = new ConsultResult(payment,false,TIMEOUT);

                    return consultResult;
                }
            });

            futureMap.put(payment,future);
        }

        // 至此任务都发给线程池处理，这里循环等待所有future返回
        for(Map.Entry<String,Future<ConsultResult>> entry : futureMap.entrySet()){
            Future<ConsultResult> future = entry.getValue();

            // 因为对任务做了处理，所以一定会在超时时间内返回，这里就直接抛给调用者异常了。
            ConsultResult result = future.get();
            resultList.add(result);
//            resultMap.put(entry.getKey(),result);
        }

        // 将查询结果缓存
        cacheMap.put(userId,resultList);

        // 封装最后的输出结果，这里可以写成JSON输出
        Result result = new Result();

        result.isSuccess = true;
        result.list = resultList;

        return result;
    }
}

// 封装了PaymentRemoteService的结果
class Result{
    public boolean isSuccess;

    // 如果isSuccess，errorCode为-1，>0代表各种错误
    public String errorCode;

    // 这里封装这四种支付方式的结果
    public List<ConsultResult> list;
}


// 这里假设其他类中提供了各种Valid方法
class ValidateClass{
    public static boolean isValidateUser(String userId){
        // 具体逻辑看业务
        return true;
    }
}

class OtherAPI{
    public static ConsultResult isEnable(String paymentType){

        // 具体的查询逻辑
        return null;
    }
}

