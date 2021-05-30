package CodeTop;

import java.util.Stack;

public class P_394 {
    public static void main(String[] args) {
//        String s = "3[a]2[bc]";
//        String s = "3[a2[c]]";
//        String s = "2[abc]3[cd]ef";
//        String s = "abc3[cd]xyz";
//        String s = "100[leetcode]";
        String s = "3[a10[bc]]";

        String res = decodeString(s);

        System.out.println(res);
    }

    public static String decodeString(String s) {
        int length = s.length();
        if(length <= 1){
            return s;
        }

        Stack<String> stack = new Stack();
        Stack<Integer> numStack = new Stack<>();
        int num = 0;

        // 也是一个括号匹配问题
        for(int i = 0;i < length;i++){
            char ch = s.charAt(i);

            if(ch >= '0' && ch <= '9'){
                // 可能存在10这样的倍数
                if(num != 0){
                    num = num * 10;
                }
                num += ch - '0';
            }else{
                if(ch == '['){
                    if(num != 0){
                        numStack.add(num);
                        num = 0;
                    }
                    stack.add("[");
                }else if(ch >= 'a' && ch <= 'z'){
                    stack.add(String.valueOf(ch));
                }else{
                    // 如果是右括号
                    StringBuilder stringBuilder = new StringBuilder();
                    while(!stack.peek().equals("[")){
                        stringBuilder.append(stack.pop());
                    }
                    // 把"["，pop出来
                    stack.pop();

                    int n = numStack.pop();
                    String str = new String(stringBuilder);
                    for(int k = 1;k < n;k++){
                        stringBuilder.append(str);
                    }
                    stack.add(new String(stringBuilder));
                }
            }
        }

        StringBuilder result = new StringBuilder();

        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        result = result.reverse();

        return result.toString();
    }
}
