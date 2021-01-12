package Algo91.Chap01_数组_栈_队列;

import java.util.Stack;

public class P_150 {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};

//        String[] tokens = {"4", "13", "5", "/", "+"};

//        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        int result = evalRPN(tokens);

        System.out.println(result);
    }

    // 已经保证式子的正确性
    public static int evalRPN(String[] tokens) {
        int length = tokens.length;
        if(length == 0){
            return 0;
        }

        Stack<Integer> numStack = new Stack<>();

//        有效的运算符包括 +, -, *, /
        for(int i = 0;i < length;i++){
            String str = tokens[i];

            if("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)){
                // 如果遇到的是符号，需要从numStack中弹出两个数字，计算后再压入栈中

                // 后用
                int num1 = numStack.pop();

                // 先用
                int num2 = numStack.pop();

                int reuslt = 0;
                if("+".equals(str)){
                    reuslt = num2 + num1;
                }else if("-".equals(str)){
                    reuslt = num2 - num1;
                }else if("*".equals(str)){
                    reuslt = num2 * num1;
                }else{
                    reuslt = num2 / num1;
                }
                numStack.push(reuslt);

            }else{
                numStack.add(Integer.parseInt(str));
            }
        }

        return numStack.pop();
    }
}
