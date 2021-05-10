package Test;

import java.util.LinkedList;
import java.util.Queue;

public class P_279 {
    public static void main(String[] args) {
//        int n = 12;
//        int n = 11;
        int n = 13;
        int result = numSquares(n);

        System.out.println(result);
    }

    // 采用BFS
    public static int numSquares(int n) {
        // 做缓存用
        int[] cacheArr = new int[(int)Math.sqrt(n)];

        for(int i = 0;i < (int)Math.sqrt(n);i++){
            cacheArr[i] = (i + 1) * (i + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        // 计算层数作为结果
        int depth = 1;

        int front = 0;
        int rear = 1;
        int last = 1;

        while(!queue.isEmpty()){
            Integer elem = queue.poll();
            front++;

            if(isSqrt(elem)){
                return depth;
            }

            // 如果不是完全平方
            for(int i = 0;i < (int)Math.sqrt(elem);i++){
                queue.offer(elem - cacheArr[i]);
//                if(isSqrt(elem - cacheArr[i])){
//                    return depth + 1;
//                }
                rear++;
            }

            if(front == last){
                depth++;
                last = rear;
            }
        }

        return depth;
    }

    // 判断是否是完全平方数
    public static boolean isSqrt(int num){
        int sqrt = (int)Math.sqrt(num);

        if(num != sqrt * sqrt){
            return false;
        }

        return true;
    }
}
