package Algo91.Chap01_数组_栈_队列;

import java.util.Stack;

public class P_739 {
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(T);

        for(int i : result){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 使用单调栈，维护一个递减的序列
    public static int[] dailyTemperatures(int[] T) {
        int length = T.length;

        int[] result = new int[length];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < length;i++){
            int temp = T[i];

            while(!stack.isEmpty() && T[stack.peek()] < temp){
                int idx = stack.pop();
                result[idx] = i - idx;
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int idx = stack.pop();
            result[idx] = 0;
        }

        return result;
    }
}
