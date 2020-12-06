package Hot100;

import java.util.Stack;

public class P_300 {
    public static void main(String[] args) {
//        int[] nums = {10,9,2,5,3,7,101,18};
//        int[] nums = {7,7,7,7,7,7,7};
//        int[] nums = {0,1,0,3,2,3};
        int[] nums = {1,3,6,7,8,4,10,5,6};
        int result = lengthOfLIS(nums);

        System.out.println();
        System.out.println(result);
    }

    // 使用普通dp
    public static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if(length == 0 || length == 1){
            return length;
        }

        int[] dpArr = new int[length];

        // dp[i]保存的是0~i部分的最长长度
        for(int i = 0;i < length;i++){
            if(i == 0){
                dpArr[i] = 1;
            }else{
                int maxCount = 1;
                for(int j = i - 1;j >= 0;j--){
                    if(nums[i] > nums[j]){
                        maxCount = Math.max(maxCount,dpArr[j] + 1);
                    }
                }
                dpArr[i] = maxCount;
            }
        }

        int result = 0;

        for(int dp : dpArr){
            result = Math.max(result,dp);

        }

        for(int dp : dpArr){
            System.out.print(dp + " ");
        }

        return result;
    }

    public static int lengthOfLIS1(int[] nums) {
        int length = nums.length;
        if(length == 0 || length == 1){
            return length;
        }

        Stack<Integer> stack = new Stack<>();
        int[] lastSmall = new int[length];
        lastSmall[0] = 0;

        // 先求出每个元素的最近一个比它小的下标，可以使用单调栈做
        for(int i = 0;i < length;i++){
            if(stack.isEmpty()){
                stack.add(i);
                continue;
            }

            int num = nums[i];

            if(nums[stack.peek()] >= num){
                while(!stack.isEmpty() && nums[stack.peek()] >= num){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    lastSmall[i] = i;
                }else{
                    lastSmall[i] = stack.peek();
                }
            }else{
                lastSmall[i] = stack.peek();
            }
            stack.add(i);
        }


        for(int i : lastSmall){
            System.out.print(i);
        }
        System.out.println();

        // 再使用一维DP解决
        // 其中dpArr[i]表示以i作为结尾的这个这个区间中最长上升子序列
        int[] dpArr = new int[length];

        for(int i = 0;i < length;i++){
            if(lastSmall[i] == i){
                dpArr[i] = 1;
            }else{
                dpArr[i] = dpArr[lastSmall[i]] + 1;
            }
        }


        int maxCount = 0;
        for(int len : dpArr){
            maxCount = Math.max(maxCount,len);
        }

        return maxCount;
    }
}
