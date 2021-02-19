package LCEveryDay;

import java.util.Deque;
import java.util.LinkedList;

public class P_995 {
    public static void main(String[] args) {
//        int[] A = {0,1,0};

//        int[] A = {1,1,0};

        int[] A = {0,0,0,1,0,1,1,0};

//        int K = 2;
        int K = 3;
        int result = minKBitFlips(A, K);

        System.out.println(result);
    }

    public static int minKBitFlips(int[] A, int K) {
        int length = A.length;

        Deque<Integer> deque = new LinkedList<>();
        int result = 0;

        for(int i = 0;i < length;i++){
            if(!deque.isEmpty() && deque.peekFirst() == i){
                deque.pollFirst();
            }

            int cnt = A[i] + deque.size();

            // 如果当前A[i]+翻转次数 还是为0，那么还需要再翻转
            if(cnt % 2 == 0){
                if(i + K > length){
                    return -1;
                }

                deque.offerLast(i + K);
                result++;
            }
        }

        return result;
    }
}
