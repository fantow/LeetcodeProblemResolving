package Classify400.Array.基础;

import java.util.EventObject;
import java.util.concurrent.locks.Lock;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_122 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] prices = {7,1,5,3,6,4};

//        ---- test2 ----
//        int[] prices = {1,2,3,4,5};

//        ---- test3 ----
        int[] prices = {7,6,4,3,1};

        int result = maxProfit(prices);

        System.out.println(result);
    }

    // 用两个指针记录买点和卖点
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if(length == 0){
            return 0;
        }
        int buyPoint = 0;
        int sellPoint = 0;

        int profit = 0;

        // 找出每个升序序列
        for(int i = 0;i < length - 1;i++){
            if(prices[i] < prices[i + 1] && buyPoint <= sellPoint){
                profit += prices[i + 1] - prices[i];
            }else{
                buyPoint = i + 1;
            }
            sellPoint ++;

        }

        return profit;
    }
}
