package LCEveryDay;

import java.util.Stack;

public class P_665 {
    public static void main(String[] args) {
//        int[] nums = {4,2,3};
//        int[] nums = {4,2,1};
//        int[] nums = {5,7,1,8};
        int[] nums = {3,4,2,3};
        boolean flag = checkPossibility(nums);

        System.out.println(flag);
    }

    // 需要分情况讨论：
    // 如果i == 1，出现非递增，修改nums[i - 1]
    // 如果 i > 1，出现非递增，并且nums[i] >= nums[i - 2]，修改nums[i - 1]
    // 如果 i > 1，出现非递增，并且nums[i] < nums[i - 2]，修改nums[i]
    public static boolean checkPossibility(int[] nums) {
        int length = nums.length;

        boolean isHappend = false;

        for(int i = 1;i < length;i++){
            // 出现非递增
            if(nums[i - 1] > nums[i]){
                if(!isHappend) {
                    if (i == 1) {
                        nums[i - 1] = nums[i];
                    } else {
                        if (nums[i] >= nums[i - 2]) {
                            nums[i - 1] = nums[i];
                        } else {
                            nums[i] = nums[i - 1];
                        }
                    }
                    isHappend = true;
                }else{
                    return false;
                }
            }
        }

        return true;
    }


    // 朴素做法试一试
    // 这样做有问题，如果需要修改的数字出现在最开始，就会错
    public static boolean checkPossibility2(int[] nums) {
        int length = nums.length;

        int preNum = nums[0];

        boolean hasChanged = false;

        for(int i = 1;i < length;i++){
            if(preNum > nums[i]){
                if(!hasChanged) {
                    nums[i] = preNum;
                    hasChanged = true;
                }else{
                    return false;
                }
            }

            preNum = nums[i];
        }

        return true;
    }

    // 【单调栈还没法做，因为弹出之后，后面的数字可能也没有前面的大】
    // 维护一个单调栈即可，只有一次递减机会
    public static boolean checkPossibility1(int[] nums) {
        int length = nums.length;

        // 表示是否还有机会
        boolean flag = false;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < length;i++){
            if(stack.isEmpty()){
                stack.add(nums[i]);
                continue;
            }

            boolean happend = false;

            // 维护单增单调栈
            while(!stack.isEmpty() && stack.peek() > nums[i]){
                if(flag){
                    return false;
                }else{
                    happend = true;
                    stack.pop();
                }
            }

            if(happend){
                flag = true;
            }

            stack.add(nums[i]);
        }

        return true;
    }
}
