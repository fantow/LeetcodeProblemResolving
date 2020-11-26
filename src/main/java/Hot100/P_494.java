package Hot100;

public class P_494 {
    public static void main(String[] args) {

        int[] nums = {1,1,1,1,1};
        int S = 3;

        int result = findTargetSumWays(nums, S);
        System.out.println(result);
    }

    // 使用动态规划
    public static int findTargetSumWays(int[] nums, int S) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        // dp[i][j]表示从nums 0 ~ i，构成总和为j的方案数
        int[][] dpArr = new int[length][1000 * 2 + 1];

        dpArr[0][nums[0] + 1000]++;
        dpArr[0][-nums[0] + 1000]++;

        for(int i = 1;i < length;i++){
            for(int j = -1000;j <= 1000;j++){
              if(dpArr[i - 1][j + 1000] > 0){
                  dpArr[i][j + nums[i] + 1000] += dpArr[i - 1][j + 1000];
                  dpArr[i][j - nums[i] + 1000] += dpArr[i - 1][j + 1000];
              }
            }
        }

        return S > 1000 ? 0 : dpArr[length - 1][S + 1000];
    }
}
