package LCEveryDay;

import java.util.*;

public class P_316 {
    public static void main(String[] args) {
//        String s = "bcabc";
//        String s = "acdb";
        String s = "abacb";

        String result = removeDuplicateLetters(s);
        System.out.println(result);
    }

    public static String removeDuplicateLetters(String s) {
        int length = s.length();
        if(length <= 1){
            return s;
        }

        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0;i < length;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }

        Stack<Character> stack = new Stack<>();

        Set<Character> set = new HashSet<>();

        for(int i = 0;i < length;i++){
            if(stack.isEmpty()){
                stack.add(s.charAt(i));
                set.add(s.charAt(i));
                if(map.get(s.charAt(i)) > 1){
                    map.put(s.charAt(i),map.get(s.charAt(i)) - 1);
                }else{
                    map.remove(s.charAt(i));
                }
                continue;
            }else{
                while(!set.contains(s.charAt(i)) && !stack.isEmpty() && stack.peek() > s.charAt(i) && map.containsKey(stack.peek())){
                    set.remove(stack.peek());
                    stack.pop();
                }
                if(!set.contains(s.charAt(i))){
                    stack.add(s.charAt(i));
                    set.add(s.charAt(i));
                }
                if(map.get(s.charAt(i)) > 1){
                    map.put(s.charAt(i),map.get(s.charAt(i)) - 1);
                }else{
                    map.remove(s.charAt(i));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
