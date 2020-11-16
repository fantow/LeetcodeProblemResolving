package Hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P_20 {
    public static void main(String[] args) {
//        String s = "()";
//        String s = "()[]{}";
//        String s = "([)]";
//        String s = "{[]}";
//        String s = "(){}}{";
        String s = "))";


        boolean flag = isValid(s);

        System.out.println(flag);
    }
    public static boolean isValid(String s) {
        int length = s.length();
        if(length == 0){
            return true;
        }

        if(length % 2 == 1){
            return false;
        }

        char[] chars = s.toCharArray();

        // 为括号建立对应关系
        Map<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');


        // 使用栈来做
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i < length;i++){
            if(i == 0){
                stack.add(chars[i]);
                continue;
            }

            if(map.containsKey(chars[i])){
                stack.add(chars[i]);
            }else{
                if(!stack.isEmpty() && map.containsKey(stack.peek())  && chars[i] == map.get(stack.peek())){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        if(stack.size() != 0){
            return false;
        }

        return true;
    }
}
