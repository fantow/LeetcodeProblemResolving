package CodeTop;

import java.util.Stack;

public class P_42 {
    public static void main(String[] args) {
//        int[] height = {4,2,0,3,2,5};
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        int res = trap(height);
        System.out.println(res);
    }

    // 需要维护一个单减栈
    public static int trap(int[] height) {
        int length = height.length;

        Stack<Integer> stack = new Stack<>();

        // 存储雨水容量
        int res = 0;

        for(int i = 0;i < length;i++){
            // 维护一个单减栈
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]){
                int baseHeight = height[stack.pop()];
                if(stack.isEmpty()){
                    break;
                }

                int leftHeight = height[stack.peek()];
                int rightHeight = height[i];

                int temp = (i - stack.peek() - 1) * (Math.min(leftHeight,rightHeight) - baseHeight);
                res += temp;
            }

            stack.add(i);
        }

        return res;
    }
}
