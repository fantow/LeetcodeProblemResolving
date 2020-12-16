package LCEveryDay;

import java.util.HashMap;
import java.util.Map;

public class P_290 {
    public static void main(String[] args) {
//        String pattern = "abba";
//        String s = "dog cat cat dog";
//
//        String pattern = "abba";
//        String s = "dog cat cat fish";


//        String pattern = "aaaa";
//        String s = "dog cat cat dog";

        String pattern = "abba";
        String s = "dog dog dog dog";

//        String pattern = "e";
//        String s = "eukera";

        boolean flag = wordPattern(pattern, s);

        System.out.println(flag);
    }

    public static boolean wordPattern(String pattern, String s) {
        int pLength = pattern.length();

        if(s.length() == 0){
            return false;
        }

        String[] strings = s.split(" ");
        int sLength = strings.length;

        if(sLength != pLength){
            return false;
        }

//        Map<String,Character> map = new HashMap<>();
        Map<Character,String> map = new HashMap<>();

        for(int i = 0;i < pLength;i++){
            if(!map.containsKey(pattern.charAt(i)) && !map.containsValue(strings[i])){
                map.put(pattern.charAt(i),strings[i]);
            }
        }

//        for(Map.Entry<Character,String> entry : map.entrySet()){
//            System.out.println(entry.getKey() + " -> " + entry.getValue());
//        }

        for(int i = 0;i < sLength;i++){
            if(!map.containsKey(pattern.charAt(i)) || !map.get(pattern.charAt(i)).equals(strings[i])){
//                System.out.println(map.get(pattern.charAt(i)) + strings[i]);
                return false;
            }
        }

        return true;
    }
}
