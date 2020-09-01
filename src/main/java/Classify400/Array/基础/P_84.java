package Classify400.Array.基础;

import java.util.Stack;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_84 {
    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3};
        int result = largestRectangleArea(height);

        System.out.println(result);
    }

    public static int largestRectangleArea(int[] heights) {
        int length = heights.length;
        if(length == 0){
            return 0;
        }
        int[] newArr = new int[length + 2];
        System.arraycopy(heights,0,newArr,1,length);
        // 初始化边界
        newArr[0] = 0;
        newArr[length + 1] = 0;

        int result = 0;

        // 单调增栈，存放的是height的下标
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < length + 2;i++){
            // 入栈后柱号为i的左边第一个比它小的就是栈的下一个
            while(!stack.isEmpty() && newArr[stack.peek()] > newArr[i]){
                int leftHeight = stack.pop();
                // 算的是 第i - 1根柱子到它第一个比它小的柱子的面积
                result = Math.max(result,(i - stack.peek() - 1) * newArr[leftHeight]);
            }
            stack.add(i);
        }

        return result;
    }
}
