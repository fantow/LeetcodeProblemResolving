package CodeTop;

public class P_122 {
    public static void main(String[] args) {

//        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {1,2,3,4,5};
        int[] prices = {7,6,4,3,1};
        int res = maxProfit(prices);

        System.out.println(res);
    }

    // 支持多次买卖
    public static int maxProfit(int[] prices) {
        int length = prices.length;

        if(length <= 1){
            return 0;
        }

        // dpArr[i][0] 第i天不持有股票；dpArr[i][1] 第i天持有股票
        int[][] dpArr = new int[length][2];

        dpArr[0][0] = 0;
        dpArr[0][1] = - prices[0];

        for(int i = 1;i < length;i++){
            // 第i天不持有股票
            dpArr[i][0] = Math.max(dpArr[i - 1][0],dpArr[i - 1][1] + prices[i]);

            // 第i天持有股票
            dpArr[i][1] = Math.max(dpArr[i - 1][1],dpArr[i - 1][0] - prices[i]);
        }

        return dpArr[length - 1][0];
    }
}
