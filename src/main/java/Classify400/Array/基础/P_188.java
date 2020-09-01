package Classify400.Array.基础;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_188 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] prices = {2,4,1};
//        int k = 2;

//        ---- test2 ----
        int[] prices = {3,3,5,0,0,3,1,4};
        int k = 2;

        int result = maxProfit(k, prices);

        System.out.println(result);
    }

    public static int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if(length == 0){
            return 0;
        }

        // length长度的prices，最多发生length/2次有效交易(前一天买，转天就卖)
        // 如果k 超过了这长度，就变成了无限制问题
        // 这个操作主要是优化空间复杂度，如果k太大，dpArr的大小就很大
        if (k >= length / 2) {
            return maxProfitSubFunc(prices);
        }

        int[][][] dpArr = new int[length][k + 1][2];

        dpArr[0][0][0] = 0;
        // 不会出现，没有买入，就持有股票的情况
        dpArr[0][0][1] = Integer.MIN_VALUE;

        for(int i = 1;i <= k;i++){
//            dpArr[0][i][0] = 0;
            dpArr[0][i][1] = -prices[0];
        }

        for(int i = 1;i < length;i++){
            for(int j = 0;j <= k;j++){
                dpArr[i][j][0] = Math.max(dpArr[i - 1][j][0],dpArr[i - 1][j][1] + prices[i]);
                if(j >= 1){
                    dpArr[i][j][1] = Math.max(dpArr[i - 1][j][1],dpArr[i - 1][j - 1][0] - prices[i]);
                }else{
                    dpArr[i][j][1] = dpArr[i - 1][j][1];
                }
            }
        }

        return dpArr[length - 1][k][0];
    }


    public static int maxProfitSubFunc(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[length - 1][0];
    }

}
