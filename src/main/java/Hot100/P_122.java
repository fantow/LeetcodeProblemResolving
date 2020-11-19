package Hot100;

import netscape.security.UserTarget;

import java.util.List;
import java.util.Stack;

public class P_122 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {1,2,3,4,5};
//        int[] prices = {7,6,4,3,1};
        int i = maxProfit1(prices);

        System.out.println(i);
    }


    public static int maxProfit1(int[] prices) {
        int length = prices.length;
        if(length <= 1){
            return 0;
        }

        int[][] dpArr = new int[length][2];

        // 0表示持股,1表示不持股
        dpArr[0][0] = -prices[0];
        dpArr[0][1] = 0;

        for(int i = 1;i < length;i++){
            // 本次买入
            // 其实判断的是：是今天买合适，还是之前买合适
            dpArr[i][0] = Math.max(dpArr[i - 1][1] - prices[i],dpArr[i - 1][0]);

            // 本次卖出
            // 判断的是：今天卖合适，还是之前卖合适
            dpArr[i][1] = Math.max(dpArr[i - 1][0] + prices[i],dpArr[i - 1][1]);
        }


        for(int i = 0;i < length;i++){
            for(int j = 0;j < 2;j++){
                System.out.print(dpArr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        return dpArr[length - 1][1];
    }

    // 使用单调栈
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if(length <= 1){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        boolean isBought = false;

        for(int i = 0;i < length;i++){
            if(stack.isEmpty() && isBought == false){
                stack.add(prices[i]);
                min = prices[i];
                isBought = true;
                continue;
            }

            // 只有出栈时，才发生卖出，卖出后栈一定为空
            if(stack.peek() > prices[i] && isBought == true) {
                int sellPoint = 0;
                while (!stack.isEmpty()) {
                    sellPoint = Math.max(sellPoint, stack.pop());
                }
                maxProfit += (sellPoint - min);
                isBought = false;

                stack.add(prices[i]);
                min = prices[i];
                isBought = true;
            }else{
                // 不到卖点
                stack.add(prices[i]);
            }
        }

        if(!stack.isEmpty()){
            maxProfit += (stack.peek() - min);
        }

        return maxProfit;
    }
}
