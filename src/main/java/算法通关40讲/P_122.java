package 算法通关40讲;

public class P_122 {
    public static void main(String[] args) {
//        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {1,2,3,4,5};
        int[] prices = {7,6,4,3,1};
        int result = maxProfit(prices);

        System.out.println(result);
    }

    // 采用贪心策略，只要后一天比前一天价格高就买入，否则就卖出
    public static int maxProfit(int[] prices) {
        int length = prices.length;

        if(length < 2){
            return 0;
        }

        int result = 0;
        boolean isBought = false;

        int prePrice = prices[0];

        for(int i = 1;i < length;i++){
            if(prePrice < prices[i]){
                if(!isBought){
                    result -= prePrice;
                    isBought = true;
                }
            }else{
                if(isBought){
                    result += prePrice;
                    isBought = false;
                }
            }
            prePrice = prices[i];
        }

        if(isBought){
            result += prices[length - 1];
        }

        return result;
    }

    // 限制了某一天只能持有/不持有
    public static int maxProfit1(int[] prices) {
        int length = prices.length;
        if(length < 2){
            return 0;
        }

        // 0代表不持有，1代表持有
        // 数组存放的是对应的当前现金
        int[][] dpArr = new int[length][2];

        dpArr[0][0] = 0;
        dpArr[0][1] = -prices[0];

        for(int i = 1;i < length;i++){
            // 第i天不持有股票 = 第i-1就不持有 或 第i天卖掉了
            dpArr[i][0] = Math.max(dpArr[i - 1][0],dpArr[i - 1][1] + prices[i]);

            // 第i天持有股票 = 第i-1就持有了 或 第i天新买入
            dpArr[i][1] = Math.max(dpArr[i - 1][1],dpArr[i - 1][0] - prices[i]);
        }


        return dpArr[length - 1][0];
    }
}
