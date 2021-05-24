package CodeTop;

import java.util.LinkedList;
import java.util.Queue;

public class P_209 {
    public static void main(String[] args) {
//        int[] nums = {2,3,1,2,4,3};
//        int target = 7;

//        int[] nums = {1,4,4};
//        int target = 1;

//        int[] nums = {1,1,1,1,1,1,1,1};
//        int target = 11;

        int[] nums = {1,2,3,4,5};
        int target = 11;

        int res = minSubArrayLen(target, nums);
        System.out.println(res);
    }

    // 看了题解，应该是用滑动窗口去做
    public static int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;

        int left = 0;
        int right = 0;
        int sum = nums[0];
        int minLength = Integer.MAX_VALUE;

        while(left <= right && right < length){
            if(sum >= target){
                minLength = Math.min(minLength,(right - left + 1));
                sum -= nums[left++];
            }else{
                right++;
                if(right < length){
                    sum += nums[right];
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
