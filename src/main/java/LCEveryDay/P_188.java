package LCEveryDay;

public class P_188 {
    public static void main(String[] args) {
        int[] prices = {2,4,1};
        int k = 2;

//        int[] prices = {3,2,6,5,0,3};
//        int k = 2;

        int result = maxProfit(k, prices);
        System.out.println(result);
    }

    // 有买卖次数限制，并且不能持有股票时再次买入
    public static int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if(length == 0 || k == 0){
            return 0;
        }

        // 应该要使用三维数组dpArr[i][0/1][k]
        // 其中dpArr[i][0][k] 表示第i天，不持有股票，并且当前是第k笔交易，当前的现金数
        int[][][] dpArr = new int[length][2][k + 1];

        // 第一天，不持股，当前是第0笔交易
        dpArr[0][0][0] = 0;

        // 第一天，持股，当前是第1笔交易
        dpArr[0][1][1] = -prices[0];
//        dpArr[0][1][0] = -prices[0];

        for(int i = 2;i <= k;i++){
            dpArr[0][1][i] = -Integer.MIN_VALUE;
        }


        for(int i = 1;i < length;i++){
            for(int j = 0;j <= k;j++){
                // 第i天不持有股票
                dpArr[i][0][j] = Math.max(dpArr[i - 1][0][j],j > 0 ? dpArr[i - 1][1][j] + prices[i] : dpArr[i - 1][0][j]);

                // 第i天持有股票
                if(j > 0) {
                    dpArr[i][1][j] = Math.max(dpArr[i - 1][0][j - 1] - prices[i], dpArr[i - 1][1][j]);
                }
            }
        }

        int max = 0;
        for(int i = 0;i <= k;i++){
            if(dpArr[length - 1][0][i] > max){
                max = dpArr[length - 1][0][i];
            }
        }

        return max;
    }
}
