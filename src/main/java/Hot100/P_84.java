package Hot100;

import java.util.Stack;

public class P_84 {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
//        int[] heights = {0,9};
        int result = largestRectangleArea(heights);

        System.out.println(result);
    }


    // 采用单调栈解法
    public static int largestRectangleArea(int[] heights) {
        int length = heights.length;
        if(length == 0){
            return 0;
        }
        if(length == 1){
            return heights[0] == 0 ? 0 : 1 * heights[0];
        }

        // 维护一个递增单调栈，并且存放的是下标
        Stack<Integer> stack = new Stack<>();

        int[] newHeights = new int[length + 2];

        for(int i = 0;i < length;i++){
            newHeights[i + 1] = heights[i];
        }

        // 在开头和结尾都加上哨兵
        newHeights[0] = 0;
        newHeights[length + 1] = 0;

        stack.add(0);
        int res = 0;
        for(int i = 1 ;i <= length + 1;i++){
            while(newHeights[i] < newHeights[stack.peek()]){
                int curHeight = newHeights[stack.pop()];
                int curWidth = i - stack.peek() - 1;
                res = Math.max(res,curWidth * curHeight);
            }
            stack.add(i);
        }

        return res;
    }


    // 暴力解法
    public static int largestRectangleArea1(int[] heights) {
        int length = heights.length;
        if(length == 0){
            return 0;
        }

        int maxArea = 0;

        maxArea = heights[0] == 0 ? 0 : 1 * heights[0];

        for(int i = 1;i < length;i++){
            if(heights[i] != 0){
                int curMinHeight = heights[i];
                maxArea = Math.max(heights[i] * 1,maxArea);
                for(int j = i - 1;j >= 0;j--){
                    if(heights[j] != 0){
                        curMinHeight = Math.min(curMinHeight,heights[j]);
                        maxArea = Math.max(maxArea,curMinHeight * (i - j + 1));
                    }else{
                        break;
                    }
                }
            }
        }

        return maxArea;
    }
}
