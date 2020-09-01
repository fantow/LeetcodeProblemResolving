package Classify400.Array.基础;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_121 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] prices = {7,1,5,3,6,4};

//        ---- test2 ----
        int[] prices = {7,6,4,3,1};

        int result = maxProfit(prices);

        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if(length == 0){
            return 0;
        }

        int buyPoint = 0;
        int maxValue = 0;

        for(int i = 0;i < length;i++){
            if(prices[i] - prices[buyPoint] > maxValue){
                maxValue = prices[i] - prices[buyPoint];
            }

            if(prices[buyPoint] > prices[i]){
                buyPoint = i;
            }
        }

        return maxValue;
    }
}
