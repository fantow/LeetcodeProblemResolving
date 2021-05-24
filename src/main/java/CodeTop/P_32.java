package CodeTop;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P_32 {
    public static void main(String[] args) {
//        String s = "(()";
//        String s = ")()())";
//        String s = "())";
        String s = "";
        int res = longestValidParentheses(s);

        System.out.println(res);
    }

    // 需要注意"())"和"(()"这种最前面或最后面不匹配的情况
    public static int longestValidParentheses(String s) {
        int length = s.length();
        if(length == 0){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        // 规定在最开始添加-1表示开始，在最后添加length表示结束
        stack.add(-1);

        for(int i = 0;i < length;i++){
            char ch = s.charAt(i);

            // 如果是'('，直接入栈
            // 如果是')'，尝试pop匹配，如果失败则入栈
            if(ch == '('){
                stack.add(i);
            }else{
                if(!stack.isEmpty() && stack.peek() != -1){
                    if(s.charAt(stack.peek()) == '(') {
                        stack.pop();
                    }else{
                        stack.push(i);
                    }
                }else{
                    stack.push(i);
                }
            }
        }

        stack.push(length);

        // 表示最长长度
        int res = 0;

//        while(!stack.isEmpty()){
//            System.out.print(stack.pop() + " ");
//        }
//        System.out.println();


//        // 栈中一定保证至少有两个元素，一个-1，一个length
        int end = stack.pop();

        while(!stack.isEmpty()){
            int start = stack.pop();

            res = Math.max(res,end - start - 1);

            end = start;
        }

        return res;
    }
}
