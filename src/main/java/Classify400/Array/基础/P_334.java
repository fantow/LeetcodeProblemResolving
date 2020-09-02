package Classify400.Array.基础;

import java.util.Stack;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_334 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] nums = {1,2,3,4,5};

//        ---- test2 ----
//        int[] nums = {5,4,3,2,1};

//        ---- test3 ----
        int[] nums = {3,4,2,6};


        boolean flag = increasingTriplet2(nums);
        System.out.println(flag);
    }

    // 需要判断一个数组中是否存在长度为3的递增子序列
    // 子序列不需要连续
    // 要求时间复杂度O(n)，空间复杂度O(1),设单调栈的大小为3，从而可以保证空间复杂度为O(1)
    // 用单调栈会出现问题，注掉了
//    public static boolean increasingTriplet1(int[] nums) {
//        int length = nums.length;
//        if(length == 0){
//            return false;
//        }
//
//        Stack<Integer> stack = new Stack<>();
//        for(int i = length - 1;i >= 0;i--){
//            if(nums[i] < stack.peek()){
//                stack.add(nums[i]);
//            }
//            if(stack.size() >= 3){
//                return true;
//            }
//        }
//
//        return false;
//    }


    // 遍历过程中找两个最小值，发现比两个最小值大的，返回true
    public static boolean increasingTriplet2(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return false;
        }

        int tempMin1 = Integer.MAX_VALUE;
        int tempMin2 = Integer.MAX_VALUE;

        for(int i = 0;i < length;i++){
            if(tempMin1 >= nums[i]){
                tempMin1 = nums[i];
            }else if(tempMin2 >= nums[i]){
                tempMin2 = nums[i];
            }else{
                return true;

            }
        }
        return false;
    }
}
