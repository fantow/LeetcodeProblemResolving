package CodeTop;

import java.util.*;

public class P_20 {
    public static void main(String[] args) {
//        String s = "()[]{}";
//        String s = "(]{}";
        String s = "){";

        boolean flag = isValid(s);
        System.out.println(flag);
    }

    public static boolean isValid(String s) {
        int length = s.length();
        if(length % 2 != 0){
            return false;
        }

        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Set<Character> set = new HashSet<>();
        set.add('(');
        set.add('[');
        set.add('{');

        Stack<Character> stack = new Stack<>();

        for(int i = 0;i < length;i++){
            if(set.contains(s.charAt(i))){
                stack.add(s.charAt(i));
            }else {
                if(stack.isEmpty() || stack.peek() != map.get(s.charAt(i))){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()){
            return false;
        }

        return true;
    }
}
