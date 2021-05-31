package CodeTop;

import java.util.Stack;

public class P_739 {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        int[] res = dailyTemperatures(temperatures);

        for(int num : res){
            System.out.print(num + " ");
        }
    }

    // 想要观测到更高的气温，至少需要等待的天数
    public static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        if(length == 0){
            return null;
        }

        int[] resArr = new int[length];

        // 需要维护一个单减栈
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < length;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int idx = stack.pop();
                resArr[idx] = i - idx;
            }

            stack.push(i);
        }

        return resArr;
    }
}
