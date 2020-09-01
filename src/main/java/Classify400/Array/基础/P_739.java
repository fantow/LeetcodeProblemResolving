package Classify400.Array.基础;

import java.util.Stack;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_739 {
    public static void main(String[] args) {
        int[] T = {73,74,75,71,69,72,76,73};
        int[] resultArr = dailyTemperatures(T);

        for(int num : resultArr){
            System.out.print(num + " ");
        }
    }

    // 找到
    public static int[] dailyTemperatures(int[] T) {
        int length = T.length;
        if(length == 0){
            return new int[]{};
        }

        int[] resultArr = new int[length];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < length;i++){
            while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                int temp = stack.pop();
                resultArr[temp] = i - temp;
            }
            stack.add(i);
        }

        return resultArr;
    }
}
