package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_63 {
    public static void main(String[] args) {
        // ---- test1 ----
//        int[] prices = {7,1,5,3,6,4};

//        ---- test2 ----
        int[] prices = {7,6,5,4,3,1};

        int result = maxProfit(prices);

        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if(length == 0 || length == 1){
            return 0;
        }

        int min = prices[0];
        int max = Integer.MIN_VALUE;

        for(int i = 0;i < length;i++){
            if((prices[i] - min) > max){
                max = prices[i] - min;
            }
            if(min > prices[i]){
                min = prices[i];
            }

        }

        return max;
    }
}
