package LCEveryDay;

public class P_376 {
    public static void main(String[] args) {
//        int[] nums = {1,7,4,9,2,5};
//        int[] nums = {1,17,5,10,13,15,10,5,16,8};
//        int[] nums = {1,2,3,4,5,6,7,8,9};
//        int[] nums = {0,0};
        int[] nums = {3,3,3,2,5};
        int result = wiggleMaxLength(nums);

        System.out.println(result);
    }

    // 使用dp来做
    public static int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if(length <= 1){
            return length;
        }

        // 使用二维DP
        // dp[i][0] 表示从0~i这部分，当前差序列是正数的最长摆动序列
        // dp[i][1] 表示从0~i这部分，当前差序列是负数的最长摆动序列
        int[][] dpArr = new int[length][2];

        // 对数组进行初始化
        dpArr[0][0] = 1;
        dpArr[0][1] = 1;

//        if(nums[1] - nums[0] > 0){
//            dpArr[1][1] = dpArr[0][0] + 1;
//        }else if(nums[1] - nums[0] < 0){
//            dpArr[1][0] = dpArr[0][1] + 1;
//        }else{
//            return 1;
//        }

        for(int i = 1;i < length;i++){
            if(nums[i] - nums[i- 1] > 0){
                dpArr[i][0] = dpArr[i - 1][1] + 1;
                dpArr[i][1] = dpArr[i - 1][1];
            }else if(nums[i] - nums[i - 1] < 0){
                dpArr[i][1] = dpArr[i - 1][0] + 1;
                dpArr[i][0] = dpArr[i - 1][0];
            }else{
//                return Math.max(dpArr[i - 1][0],dpArr[i - 1][1]);
                dpArr[i][0] = dpArr[i - 1][0];
                dpArr[i][1] = dpArr[i - 1][1];
            }
        }

//        for(int i = 0;i < length;i++){
//            System.out.print("i: " + i + " --> " + dpArr[i][0] + " " + dpArr[i][1]);
//            System.out.println();
//        }


        int max = Integer.MIN_VALUE;
        for(int[] num : dpArr){
            int tempMax = Math.max(num[0],num[1]);
            max = Math.max(tempMax,max);
        }

        return max;
    }
}
