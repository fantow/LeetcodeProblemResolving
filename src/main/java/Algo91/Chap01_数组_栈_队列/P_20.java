package Algo91.Chap01_数组_栈_队列;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P_20 {
    public static void main(String[] args) {
//        String s = "()[]{}";
//        String s = "([)]";
//        String s = "{[]}";
        String s = "}{";
        boolean flag = isValid(s);

        System.out.println(flag);
    }

    public static boolean isValid(String s) {
        int length = s.length();
        if(length % 2 != 0){
            return false;
        }

        Map<Character,Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        for(int i = 0;i < length;i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(map.get(ch) == stack.peek()){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        if(!stack.isEmpty()){
            return false;
        }

        return true;
    }
}
