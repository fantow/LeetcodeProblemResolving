package Algo91.Chap01_数组_栈_队列;

import java.util.Stack;

public class P_84 {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
//        int[] heights = {0,9};
//        int[] heights = {1,1};
//        int[] heights = {2,1,2};
        int result = largestRectangleArea(heights);

        System.out.println(result);
    }

    public static int largestRectangleArea(int[] heights) {
        int length = heights.length;

        int[] newHeights = new int[length + 2];
        newHeights[0] = 0;
        newHeights[length + 1] = 0;

        for(int i = 0;i < length;i++){
            newHeights[i + 1] = heights[i];
        }

        length = newHeights.length;

        Stack<Integer> stack = new Stack<>();
        int maxVal = 0;
        for(int i = 0;i < length;i++){

            // 如果新来的比当前栈顶小，则弹出
            while(!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]){
                int idx = stack.pop();
//                System.out.println("num:" + newHeights[idx]);
                while(!stack.isEmpty() && newHeights[idx] == newHeights[stack.peek()]){
                    idx = stack.pop();
                }

                int height = newHeights[idx];
                int width = 0;
                if(stack.isEmpty()){
                    width = 1;
                }else{
                    // 这个很重要
                    width = i - stack.peek() - 1;
                }

                maxVal = Math.max(maxVal,width * height);
            }
            stack.add(i);
        }

        return maxVal;
    }

    public static int largestRectangleArea1(int[] heights) {
        int length = heights.length;

        int maxVal = heights[0] * 1;

        for(int i = 1;i < length;i++){
            int curWidth = heights[i];
            for(int j = i;j >= 0;j--){
                curWidth = Math.min(curWidth,heights[j]);
                maxVal = Math.max(maxVal,(i - j + 1) * curWidth);
            }
        }

        return maxVal;
    }
}
