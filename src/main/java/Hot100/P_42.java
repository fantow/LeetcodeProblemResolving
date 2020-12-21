package Hot100;

import java.util.Stack;

public class P_42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] height = {4,2,0,3,2,5};
        int result = trap(height);

        System.out.println(result);
    }

    public static int trap(int[] height) {
        int length = height.length;
        if(length == 0){
            return 0;
        }

        // 看来两边不算高度
        // 使用单调栈，需要维护一个递减单调栈
        Stack<Integer> stack = new Stack<>();

        stack.add(0);

        int sumArea = 0;

        for(int i = 1;i < length;i++){
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int baseHeigh = height[stack.pop()];
                if(stack.isEmpty()){
                    break;
                }
                int leftHeigh = height[stack.peek()];
                int rightHeigh = height[i];

                int tempArea = (Math.min(leftHeigh,rightHeigh) - baseHeigh) * (i - stack.peek() - 1);
                sumArea += tempArea;
            }
            stack.add(i);
        }

        return sumArea;
    }
}
