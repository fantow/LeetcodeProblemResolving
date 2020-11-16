package Hot100;

import java.util.*;

public class P_316 {
    public static void main(String[] args) {
        String s = "cdadabcc";
//        String s = "abcd";
//        String s = "ecbacba";
//        String s = "leetcode";
//        String s = "cbaacabcaaccaacababa";

        String str = smallestSubsequence1(s);
        System.out.println(str);
    }


    public static String smallestSubsequence1(String s){
        int length = s.length();

        if(length <= 1){
            return s;
        }

        // 用来记录字符出现的次数
        Map<Character,Integer> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();

        for(int i = 0;i < length;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }

//        for(Map.Entry<Character,Integer> entry : map.entrySet()){
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

        for(int i = 0;i < length;i++) {
            if(set.contains(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i)) - 1);
                continue;
            }

            while(!stack.isEmpty() && s.charAt(i) < stack.peek() && map.get(stack.peek()) > 0){
                set.remove(stack.peek());
                stack.pop();
            }

            stack.add(s.charAt(i));
            set.add(s.charAt(i));
            map.put(s.charAt(i),map.get(s.charAt(i)) - 1);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }




    // 这样写是错的，因为从后向前遍历时，"cbaacabcaaccaacababa" 这个用例中的b会因为其比a小且在之前出现过，而无法更新自己的
    // 位置
    public static String smallestSubsequence(String s) {

        int length = s.length();
        if(length <= 1){
            return s;
        }

        // char --> int
        HashMap<Character,Integer> map = new HashMap<>();
        char[] chars = new char[length];

        for(int i = 0;i < length;i++){
            chars[i] = '#';
        }

        char tempChar = '#';

        for(int i = length - 1;i >= 0;i--){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                chars[i] = s.charAt(i);
                tempChar = chars[i];
            }else{
                // 如果存在重复，需要判断和上一位的字典序关系
                if(s.charAt(i) - tempChar > 0){
                    System.out.println(s.charAt(i) + " -> " + tempChar);
                    continue;
                }else{
                    chars[map.get(s.charAt(i))] = '#';
                    map.put(s.charAt(i),i);
                    chars[i] = s.charAt(i);
                    tempChar = chars[i];
                }
            }
        }

//        for(char ch : chars){
//            System.out.print(ch + " ");
//        }

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            System.out.println("key:" + entry.getKey() + " -> " + "value:" + entry.getValue());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < length;i++){
            if(chars[i] != '#'){
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }
}
