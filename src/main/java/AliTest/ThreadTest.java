package AliTest;

import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {

        // 0 ~ MAX_VALUE
//        ExecutorService service = Executors.newCachedThreadPool();
//        Executors.newFixedThreadPool(10);
//        Executors.newSingleThreadExecutor();
//
//        service.submit(new MyRunner(10));
//
//        System.out.println("---- end ----");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("先阻塞...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("打印结果并且线程返回");

            }
        });

        Timer timer = new Timer();

        ReentrantLock lock = new ReentrantLock(true);


        Executors.newScheduledThreadPool(10);



        t1.start();


        Thread.sleep(100000);
        System.out.println("---- end ----");
    }
}


//class MyRunner implements Runnable{
//
//    public int target = 0;
//
//    public MyRunner(int target){
//        this.target = target;
//    }
//
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName() + " --> " + target);
//    }
//}
