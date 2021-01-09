package LCEveryDay;

public class P_123 {
    public static void main(String[] args) {
//        int[] prices = {3,3,5,0,0,3,1,4};
//        int[] prices = {1,2,3,4,5};
//        int[] prices = {7,6,4,3,1};
        int[] prices = {0};

        int result = maxProfit(prices);

        System.out.println(result);
    }

    // 首先这个类型的题都是DP问题，
    // 本题有两个限制条件：不能持有股票时再买入；最多完成两笔交易
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if(length < 2){
            return 0;
        }

        // dpArr[i][j][k] --> 第i天，是否持有股票，这是第k笔交易
        // 其中0表示不持有，1表示持有
        int[][][] dpArr = new int[length][2][3];

        // 初始化
        dpArr[0][0][0] = 0;
        dpArr[0][0][1] = 0;

        dpArr[0][1][0] = 0;
        dpArr[0][1][1] = -prices[0];

        // 这两个初始化很重要，不写会错，但是这两种情况一定不会发生
        dpArr[0][0][2] = 0;
        dpArr[0][1][2] = -prices[0];


        for(int i = 1;i < length;i++){
            for(int k = 0;k <= 2;k++){
                // 第i天不持有股票，可能第i-1天也不持有，或者第i天卖出了
                dpArr[i][0][k] = Math.max(dpArr[i - 1][0][k],k > 0 ? dpArr[i - 1][1][k] + prices[i] : 0);

                // 第i天持有股票，可能第i-1天也持有股票，或者第i天买入
                dpArr[i][1][k] = Math.max(dpArr[i - 1][1][k],k > 0 ? dpArr[i - 1][0][k - 1] - prices[i] : 0);
            }
        }

        int result = 0;

        for(int i = 0;i <= 2;i++){
            result = Math.max(result,dpArr[length - 1][0][i]);
        }

        return result;
    }
}
