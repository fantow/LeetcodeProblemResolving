package Hot100;

import java.util.Arrays;

public class P_416 {
    public static void main(String[] args) {
//        int[] nums = {1,5,11,5};
//        int[] nums = {1,2,3,5};
//        int[] nums = {1,4,9,8,4,3,2};
        int[] nums = {1,2,5};
        boolean flag = canPartition(nums);

        System.out.println(flag);
    }


    public static boolean canPartition(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return false;
        }

        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        int target = sum / 2;

        if(sum % 2 == 1){
            return false;
        }

        // 使用dp[i][j] = dp[i-1][j] || dp[i][j - nums[i]]
        boolean[][] dpArr = new boolean[length][target + 1];

        if(nums[0] <= target){
            dpArr[0][nums[0]] = true;
        }

        for(int i = 1;i < length;i++){
            for(int j = 0;j <= target;j++){
                dpArr[i][j] = dpArr[i - 1][j];

                // 如果仅凭第i位的num，就可以达到值为j，那么dp[i][j] = true
                if(nums[i] == j){
                    dpArr[i][j] = true;
                    continue;
                }

                if(nums[i] < j){
                    dpArr[i][j] = dpArr[i - 1][j] || dpArr[i - 1][j - nums[i]];
                }
            }
        }

        for(int i = 0;i < length;i++){
            for(int j = 0;j <= target;j++){
                System.out.print(dpArr[i][j] + " ");
            }
            System.out.println();
        }


        return dpArr[length - 1][target];
    }

    // 可以把问题转换为，从数组中取出取出任意个数，使这些数等于一个target，而这个target = nums中各元素相加之和
    public static boolean canPartition1(int[] nums) {
        int length = nums.length;

        if(length == 0){
            return false;
        }

        Arrays.sort(nums);

        int sum = 0;

        for(int i = 0;i < length;i++){
            sum += nums[i];
        }

        int target = sum / 2;

        // 如果和为奇数，那就一定没有解
        if(sum % 2 == 1){
            return false;
        }

        int left = 0;
        int currentSum = nums[left];
        int right = 1;

        while(left <= right && right < length){
            System.out.println("currentSum: " + currentSum + " left:" + left + " right:" + right);
            if(currentSum == target){
                return true;
            }else if(currentSum < target){
                currentSum += nums[right];
                right++;
            }else if(currentSum > target){
                currentSum -= nums[left];
                left++;
            }
        }

        return false;
    }
}
