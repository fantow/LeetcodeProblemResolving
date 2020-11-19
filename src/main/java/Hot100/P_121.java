package Hot100;

import java.util.Stack;

public class P_121 {
    public static void main(String[] args) {
//        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {1,2,3,4,5,6,7};
        int[] prices = {3,2,6,5,0,3};
        int i = maxProfit(prices);

        System.out.println(i);
    }

    // 可以使用单调栈
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if(length < 2){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0;i < length;i++) {
            if (stack.isEmpty()) {
                stack.add(prices[i]);
                min = prices[i];
                continue;
            } else {
                if (stack.peek() < prices[i]) {
                    stack.add(prices[i]);
                    maxProfit = Math.max(prices[i] - min,maxProfit);
                } else {
                    while (!stack.isEmpty() && stack.peek() >= prices[i]) {
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        min = prices[i];
                    }
                    stack.add(prices[i]);
                }
            }
        }

        return maxProfit;
    }
}
