package Algo91.Chap01_数组_栈_队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class P_239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int[] arr = maxSlidingWindow(nums, k);

        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if(length < k){
            return null;
        }

        int[] resultArr = new int[length - k + 1];

        Deque<Integer> queue = new LinkedList<>();

        int fastPtr = 0;
        int idx = 0;

        while(fastPtr < length){
            // 如果当前的最大值需要被出队，则出队
            if(fastPtr >= k && nums[fastPtr - k] == queue.peekFirst()){
                queue.pollFirst();
            }

            // 需要维护一个递减队列
            while(!queue.isEmpty() && nums[fastPtr] > queue.peekLast()){
                queue.pollLast();
            }

            queue.offerLast(nums[fastPtr]);

            if(fastPtr + 1 >= k){
                resultArr[idx ++] = queue.peekFirst();
            }

            fastPtr ++;
        }

        return resultArr;
    }
}
