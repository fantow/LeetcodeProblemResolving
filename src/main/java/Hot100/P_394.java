package Hot100;

import java.util.Stack;

public class P_394 {
    public static void main(String[] args) {
//        String s = "3[a]2[bc]";
//        String s = "3[a2[c]]";
//        String s = "2[abc]3[cd]ef";
//        String s = "abc3[cd]xyz";
        String s = "100[leetcode]";
        String string = decodeString(s);

        System.out.println(string);
    }

    public static String decodeString(String s) {
        int length = s.length();
        if(length == 0){
            return s;
        }

        // 使用两个栈，一个用于存数，一个用于匹配括号
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        int tempNum = 0;
        int digit = 0;

        // 用来记录当前栈中"["的个数
        int leftCount = 0;

        StringBuilder sb = new StringBuilder();

        for(int i = 0;i < length;i++){
            char ch = s.charAt(i);

            if(ch >= '0' && ch <= '9'){
                tempNum = tempNum * 10 + (ch - '0');
                digit++;
                continue;
            }else{
                // 之前的数字需要被处理
                if(tempNum != 0){
                    numStack.add(tempNum);
                    tempNum = 0;
                    digit = 0;
                }

                // 判断是否是括号或者字母
                if(ch == '['){
                    strStack.add("[");
                    leftCount++;
                }else if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                    if(leftCount > 0){
                        strStack.add(String.valueOf(ch));
                    }else{
                        sb.append(ch);
                    }
                }else if(ch == ']'){
                    StringBuilder subSb = new StringBuilder();
                    while(!strStack.isEmpty() && strStack.peek() != "["){
                        subSb.append(strStack.pop());
                    }

//                    System.out.println(leftCount + " -> " + strStack.size());

                    // pop掉"["
                    if(!strStack.isEmpty()) {
                        strStack.pop();
                        leftCount--;
                    }

                    int num = numStack.pop();

                    StringBuilder sb1 = new StringBuilder();

                    for(int j = 0;j < num;j++){
                        sb1.append(subSb);
                    }
                    // 还有嵌套[]，应该写入栈中
                    if(leftCount > 0){
                        strStack.add(sb1.toString());
                    }else{
                        sb.append(sb1.reverse());
                    }
                }
            }
        }

        return sb.toString();
    }


}
