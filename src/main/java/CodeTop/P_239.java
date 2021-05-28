package CodeTop;

import java.util.LinkedList;
import java.util.Queue;

public class P_239 {
    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int k = 3;

//        int[] nums = {1};
//        int k = 1;

//        int[] nums = {1,-1};
//        int k = 1;

//        int[] nums = {9,11};
//        int k = 2;

        int[] nums = {4,-2};
        int k = 2;

        int[] arr = maxSlidingWindow(nums, k);

        for(int num : arr){
            System.out.print(num + " ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;

        if(length < k){
            return null;
        }

        int[] arr = new int[length - k + 1];
        int idx = 0;

        // 需要维护一个单减队列
        LinkedList<Integer> queue = new LinkedList<>();

        int left = 0;
        int right = 0;

        while(right < length){
            // 如果right - left当前不足3个，就循环放入
            while(right < length && right - left < k){
                while(!queue.isEmpty() && queue.get(queue.size() - 1) < nums[right]){
                    queue.removeLast();
                }
                queue.offer(nums[right]);
                right++;
            }

            // 出来到这里时，一定是满足right - left = k的
            arr[idx++] = queue.getFirst();

            if(nums[left] == queue.getFirst()){
                queue.removeFirst();
            }

            left++;
        }

        return arr;
    }
}
