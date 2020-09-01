package Classify400.Array.基础;

import java.util.Stack;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_42 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

//        ---- test2 ----
        int[] height = {5,2,1,2,1,5};

        int result = trap(height);

        System.out.println(result);
    }

    // 使用单调栈，栈中存放的是height数组的下标
    // 如果看图的话，就是按行去计算接到的雨水量
    public static int trap(int[] height) {
        int length = height.length;
        if(length == 0){
            return 0;
        }
        int result = 0;
        // 单调栈，栈顶存放当前最大
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < length;i++){
            // 因为如果后面的高度小于前面的高度，就不会对存雨水有用
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int curIdx = stack.pop();
                while(!stack.isEmpty() && height[stack.peek()] == height[curIdx]){
                    stack.pop();
                }

                if(!stack.isEmpty()){
                    int stackTop = stack.peek();
                    result += (Math.min(height[stackTop],height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }

        return result;
    }
}
