package LCEveryDay;

public class P_714 {
    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;

        int result = maxProfit(prices, fee);

        System.out.println(result);
    }

    // 肯定还是DP，只是增加了手续费，这里假设手续费在买入时扣除
    public static int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        if(length <= 1){
            return 0;
        }

        // dp[i][0] 表示第i天不持有股票的现金数
        // dp[i][1] 表示第i天持有股票的现金数
        int[][] dpArr = new int[length][2];

        // 初始化
        dpArr[0][0] = 0;
        dpArr[0][1] = - prices[0] - fee;

        for(int i = 1;i < length;i++){
            // 第i天不持有
            // 不持有有两种可能，第i-1天也不持有或第i-1天持有，但第i天卖出
            dpArr[i][0] = Math.max(dpArr[i - 1][0],dpArr[i-1][1] + prices[i]);

            // 第i天持有
            // 持有有两种可能，第i-1天也持有和第i-1天不持有，但第i天买入
            dpArr[i][1] = Math.max(dpArr[i - 1][1],dpArr[i - 1][0] - prices[i] - fee);
        }

        for(int[] arr : dpArr){
            for(int num : arr){
                System.out.print(num + " ");
            }
            System.out.println();
        }

        return Math.max(dpArr[length - 1][0],dpArr[length - 1][1]);
    }
}
