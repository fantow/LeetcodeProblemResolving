package Hot100;

import java.util.Stack;

public class P_739 {
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperatures = dailyTemperatures(T);

        for(int temperature : temperatures){
            System.out.print(temperature + " ");
        }
    }

    public static int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] resultArr = new int[length];
        if(length == 0){
            return null;
        }

        if(length == 1){
            resultArr[0] = 0;
            return resultArr;
        }

        // 使用单调栈，存数组下标索引
        Stack<Integer> stack = new Stack<>();

        stack.add(0);

        // 栈中维护递减序列
        for(int i = 1;i < length;i++){
            while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                resultArr[stack.peek()] = i - stack.peek();
                stack.pop();
            }

            stack.add(i);
        }


        return resultArr;
    }
}
