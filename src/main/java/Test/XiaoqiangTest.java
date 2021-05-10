package Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// 小强练习武术的问题
// 参数1：秒数   n
// 参数2：木头人数 m
// 参数3：木头人血量    a
// 参数4：攻击范围 b
public class XiaoqiangTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 秒数
        int n = scanner.nextInt();

        // 木头人数
        int m = scanner.nextInt();

        // 血量
        int a = scanner.nextInt();

        // 攻击范围
        int b = scanner.nextInt();

        // 构建一个小根堆
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.val - o2.val;
            }
        });

        for(int i = 0;i < m;i++){
            Pair pair = new Pair();
            pair.num = i;
            pair.val = a;

            queue.offer(pair);
        }

        // 进行n秒的攻击
        for(int i = 0;i < n;i++){
            // 从堆中拿出元素，并且-1，如果为0了，则弹出
            for(int j = 0;j < b;j++) {
                if(!queue.isEmpty()){
                    Pair pair = queue.poll();
                    if(pair.val - 1 > 0){
                        pair.val = pair.val - 1;
                        queue.offer(pair);
                    }
                }else {
                    break;
                }
            }
        }

        System.out.println("消灭了：" + (m - queue.size()));
    }


    static class Pair{
        int num;
        int val;

    }

}
