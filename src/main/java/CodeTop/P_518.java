package CodeTop;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_518 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};

        int res = change(amount, coins);

        System.out.println(res);
    }

    public static int change(int amount, int[] coins) {
        int length = coins.length;

        // 类似于完全背包问题
        // dpArr[i][j]表示使用前i个物品，装满容量为j的方案数
        // dpArr[i][j] = dpArr[i - 1][j] + dpArr[i][j - coins[i]]
        int[][] dpArr = new int[length + 1][amount + 1];

        // 什么都不装，也要当做一种方案
        for(int i = 0;i < length + 1;i++){
            dpArr[i][0] = 1;
        }

        for(int i = 1;i <= length;i++){
            for(int j = 0;j <= amount;j++){
                dpArr[i][j] = dpArr[i - 1][j] + (j - coins[i - 1] >= 0 ? dpArr[i][j - coins[i - 1]] : 0);
            }
        }

        return dpArr[length][amount];
    }
}
