package CodeTop;

public class P_121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        int result = maxProfit(prices);
        System.out.println(result);
    }

    // 只能买一次
//    public static int maxProfit(int[] prices) {
//        int length = prices.length;
//
//        int result = 0;
//
//        // 采用dp,0表示不持有，1表示持有
//        int[][] dpArr = new int[length][2];
//
//        dpArr[0][1] = -prices[0];
//
//        for(int i = 1;i < length;i++){
//            // 第i天不持有股票
//            dpArr[i][0] = Math.max(dpArr[i - 1][0],dpArr[i - 1][1] + prices[i]);
//
//            // 第i天持有股票
//            dpArr[i][1] = Math.max(dpArr[i - 1][1],- prices[i]);
//        }
//
////        for(int i = 0;i < length;i++){
////            System.out.print(dpArr[i][0] + " ");
////        }
////
////        System.out.println();
////
////        for(int i = 0;i < length;i++){
////            System.out.print(dpArr[i][1] + " ");
////        }
////        System.out.println();
//
//        return dpArr[length - 1][0];
//    }


    public static int maxProfit(int[] prices) {
        int length = prices.length;

        if(length <= 1){
            return 0;
        }

        int min = prices[0];
        int result = 0;

        for(int i = 1;i < length;i++){
            if(result < (prices[i] - min)){
                result = prices[i] - min;
            }

            if(min > prices[i]){
                min = prices[i];
            }
        }

        return result;
    }

}
