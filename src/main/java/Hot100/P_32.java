package Hot100;

import java.util.Stack;

public class P_32 {
    public static void main(String[] args) {
//        String s = "(()";
//        String s = ")()())";
//        String s = "";
//        String s = "()";
//        String s = "())";
        String s = "))(()))";

        int result = longestValidParentheses(s);
        System.out.println(result);
    }

    public static int longestValidParentheses(String s) {
        int length = s.length();
        if(length <= 1){
            return 0;
        }

        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < length;i++){
            if(chars[i] == '('){
                stack.add(i);
            }else{
                if(!stack.isEmpty()){
                    char ch = chars[stack.peek()];
                    if(ch == '('){
                        stack.pop();
                    }else{
                        stack.add(i);
                    }
                }else{
                    stack.add(i);
                }
            }
        }

        int maxLen = 0;

        // 说明该String是合法的()
        if(stack.isEmpty()){
            return length;
        }

        int end = length - 1;
        int start = 0;
        while(!stack.isEmpty() && end >= 0) {
            start = stack.pop();
            maxLen = Math.max(maxLen,end - start);
            end = start - 1;
        }

        if(end >= 0){
            maxLen = Math.max(maxLen,end - 0 + 1);
        }

        return maxLen;
    }
}
