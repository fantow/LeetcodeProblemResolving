package Classify400.Array.基础;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_123 {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int result = maxProfit1(prices);

        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if(length == 0){
            return 0;
        }

        int[][][] dpArr = new int[length][3][2];
        dpArr[0][0][0] = 0;
        // 不会出现
//        dpArr[0][0][1] = Integer.MIN_VALUE;
        dpArr[0][1][0] = 0;
        dpArr[0][1][1] = -prices[0];
        dpArr[0][2][0] = 0;
        dpArr[0][2][1] = -prices[0];

        // 买入时就算一次交易
        for(int i = 1;i < length;i++){
            dpArr[i][1][0] = Math.max(dpArr[i - 1][1][0],dpArr[i - 1][1][1] + prices[i]);
            dpArr[i][1][1] = Math.max(dpArr[i - 1][1][1],dpArr[i - 1][0][0] - prices[i]);
            dpArr[i][2][0] = Math.max(dpArr[i - 1][2][0],dpArr[i - 1][2][1] + prices[i]);
            dpArr[i][2][1] = Math.max(dpArr[i - 1][2][1],dpArr[i - 1][1][0] - prices[i]);
        }

        return dpArr[length - 1][2][0];
    }


    // 优化空间复杂度
    public static int maxProfit1(int[] prices) {
        int length = prices.length;
        if(length == 0){
            return 0;
        }

        int profitOne0 = 0;
        int profitOne1 = -prices[0];
        int profitTwo0 = 0;
        int profitTwo1 = -prices[0];

        for(int i = 1;i < length;i++){
            profitTwo0 = Math.max(profitTwo0,profitTwo1 + prices[i]);
            profitTwo1 = Math.max(profitTwo1,profitOne0 - prices[i]);
            profitOne0 = Math.max(profitOne0,profitOne1 + prices[i]);
            profitOne1 = Math.max(profitOne1, -prices[i]);
        }

        return profitTwo0;
    }

}
