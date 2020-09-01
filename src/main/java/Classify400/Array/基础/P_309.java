package Classify400.Array.基础;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_309 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] prices = {1,2,3,0,2};

//        ---- test2 ----
        int[] prices = {2,1,4};

        int result = maxProfit(prices);

        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if(length == 0){
            return 0;
        }

        // 天数，是否持有股票
        int[][] dpArr = new int[length][2];

        // 初始化dpArr
        dpArr[0][0] = 0;
        dpArr[0][1] = -prices[0];
        for(int i = 1;i < length;i++){
            dpArr[i][0] = Math.max(dpArr[i - 1][0],dpArr[i - 1][1] + prices[i]);
            if(i >= 2){
                dpArr[i][1] = Math.max(dpArr[i - 1][1],dpArr[i - 2][0] - prices[i]);
            }else{
                dpArr[i][1] = Math.max(dpArr[i - 1][1],0 - prices[i]);
            }
        }

        return dpArr[length - 1][0];
    }
}
