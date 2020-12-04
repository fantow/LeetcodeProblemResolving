package Hot100;

public class P_309 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        int result = maxProfit(prices);

        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if(length == 0){
            return 0;
        }


        // 0表示持有，1表示不持有
        int[][] dpArr = new int[length][2];

        dpArr[0][0] = - prices[0];
        dpArr[0][1] = 0;


        for(int i = 1;i < length;i++){
            // 第i天持有股票,如果第i天持有股票，有两种可能：第i-1天就持有了，或者今天新买的，如果是
            // 今天新买的，因为有冷静期，所以应该是前天的不持有的状态-今天买入的价格
            if(i - 2 < 0){
                dpArr[i][0] = Math.max(dpArr[i - 1][0],0 - prices[i]);
            }else{
                dpArr[i][0] = Math.max(dpArr[i - 1][0],dpArr[i - 2][1] - prices[i]);
            }

            // 第i天不持有股票
            dpArr[i][1] = Math.max(dpArr[i - 1][0] + prices[i],dpArr[i - 1][1]);
        }

//        for(int[] arr : dpArr){
//            for(int a : arr){
//                System.out.print(a + " ");
//            }
//            System.out.println();
//        }


        return dpArr[length - 1][1];
    }
}
