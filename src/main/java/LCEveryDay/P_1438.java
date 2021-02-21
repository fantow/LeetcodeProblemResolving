package LCEveryDay;

import java.util.Deque;
import java.util.LinkedList;

public class P_1438 {
    public static void main(String[] args) {
//        int[] nums = {8,2,4,7};
//        int limit = 4;

//        int[] nums = {10,1,2,4,7,2};
//        int limit = 5;

//        int[] nums = {4,2,2,2,4,4,2,2};
//        int limit = 0;

        int[] nums = {1,5,6,7,8,10,6,5,6};
        int limit = 4;

        int result = longestSubarray(nums, limit);
        System.out.println(result);
    }


    // 需要维护一个不定长的窗口大小，并且需要保证窗口内的元素最大-最小值的绝对值不超过limit
    public static int longestSubarray(int[] nums, int limit) {
        int length = nums.length;

        int left = 0;
        int right = 0;

        int maxLen = 0;

        // 记录队列的窗口最大值，存储的是下标，维护一个单减队列
        Deque<Integer> maxQueue = new LinkedList<>();

        // 记录队列的窗口最小值，存储的是下标，维护一个单增队列
        Deque<Integer> minQueue = new LinkedList<>();

        while(right < length){
            // 元素入队，对maxQueue维护递减队列
            // 对minQueue维护递增队列
            // 记录下标
            while(!maxQueue.isEmpty() && nums[maxQueue.peekLast()] < nums[right]){
                maxQueue.pollLast();
            }
            maxQueue.offerLast(right);


            while(!minQueue.isEmpty() && nums[minQueue.peekLast()] > nums[right]){
                minQueue.pollLast();
            }
            minQueue.offerLast(right);


            // 判断当前窗口是否符合要求
            int max = nums[maxQueue.peekFirst()];
            int min = nums[minQueue.peekFirst()];
//            System.out.println(max + " -> " + min);

            // 符合要求
            if(Math.abs(max - min) <= limit){
//                System.out.println("right: " + right + " left: " + left + "min:" + min + " max:" + max);
                maxLen = Math.max(maxLen,(right - left + 1));
            }else{
                // 不符合要求就要弹出元素
                // 右移left
//                while(nums[left] != nums[maxQueue.peekFirst()] || nums[left] != nums[minQueue.peekFirst()]){
//                    left++;
////                    System.out.println(nums[left] + " -> " + nums[maxQueue.peekFirst()]);
//                }
                while(left <= right) {
                    if (nums[left] == nums[maxQueue.peekFirst()]) {
                        maxQueue.pollFirst();
                        left++;
                        break;
                    } else if (nums[left] == nums[minQueue.peekFirst()]) {
                        minQueue.pollFirst();
                        left++;
                        break;
                    }
                    left++;
                }
            }
            right++;
        }

        return maxLen;
    }
}
