package CodeTop;

import java.util.Arrays;

public class P_322 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

//        int[] coins = {2};
//        int amount = 3;

//        int[] coins = {1};
//        int amount = 0;

        int res = coinChange(coins, amount);
        System.out.println(res);
    }

    public static int coinChange(int[] coins, int amount) {
        int length = coins.length;

        // 将coins变为有序
//        Arrays.sort(coins);

        // 感觉用dp比较好
        // dpArr[i] = j --> 表示总金额为i时，使用到j个硬币
        int[] dpArr = new int[amount + 1];
        dpArr[0] = 0;

        // 将dpArr进行初始化
        for(int i = 0;i < length;i++){
            if(coins[i] <= amount){
                dpArr[coins[i]] = 1;
            }
        }

        for(int i = 1;i <= amount;i++){
            for(int j = 0;j < length;j++){
                if(i - coins[j] >= 0 && dpArr[i - coins[j]] != 0){
                    if(dpArr[i] == 0){
                        dpArr[i] = dpArr[i - coins[j]] + 1;
                    }else{
                        dpArr[i] = Math.min(dpArr[i],dpArr[i - coins[j]] + 1);
                    }
                }
            }
        }

//        for(int num : dpArr){
//            System.out.print(num + " ");
//        }

        return dpArr[amount] == 0 ? -1 : dpArr[amount];
    }
}
