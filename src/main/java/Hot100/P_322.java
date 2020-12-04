package Hot100;

import java.util.Arrays;

public class P_322 {
    public static void main(String[] args) {
//        int[] coins = {1,2,5};
//        int amount = 11;

//        int[] coins = {2};
//        int amount = 3;

//        int[] coins = {1};
//        int amount = 1;

//        int[] coins = {1};
//        int amount = 2;

//        int[] coins = {2,5,10,1};
//        int amount = 27;

        int[] coins = {186,419,83,408};
        int amount = 6249;

        int result = coinChange(coins, amount);
        System.out.println(result);
    }


    public static int coinChange(int[] coins, int amount) {
        int length = coins.length;
        if(length == 0){
            return 0;
        }

        if(amount == 0){
            return 0;
        }

        int[] dpArr = new int[amount + 1];
        // 初始化
        dpArr[0] = 0;

        Arrays.sort(coins);


        for(int i = 0;i <= amount;i++){
            int minResult = Integer.MAX_VALUE;
            for(int coin : coins){
                if(i - coin == 0){
                    minResult = 1;
                }else if(i - coin > 0){
                    if(dpArr[i - coin] == 0){
                        continue;
                    }else{
                        minResult = Math.min(minResult,dpArr[i - coin] + 1);
                    }
                }
            }
            if(minResult == Integer.MAX_VALUE){
                dpArr[i] = 0;
            }else{
                dpArr[i] = minResult;
            }
//            for(int dp : dpArr){
//                System.out.print(dp + " ");
//            }
//            System.out.println();
        }

        return dpArr[amount] > 0 ? dpArr[amount] : -1;
    }
}
