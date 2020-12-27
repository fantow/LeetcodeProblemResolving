package LCEveryDay;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_205 {
    public static void main(String[] args) {
//        String s = "egg";
//        String t = "add";

//        String s = "foo";
//        String t = "bar";

//        String s = "paper";
//        String t = "title";

        String s = "ab";
        String t = "aa";


        boolean flag = isIsomorphic(s, t);
        System.out.println(flag);
    }

    public static boolean isIsomorphic(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();

        Map<Character,Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        if(length1 == length2){
            if(length1 == 0){
                return true;
            }else{
                for(int i = 0;i < length1;i++){
                    char ch = s.charAt(i);
                    if(map.containsKey(ch)){
                        if(t.charAt(i) != map.get(ch)){
                            return false;
                        }
                    }else{
                        char tChar = t.charAt(i);
                        if(set.contains(tChar)){
                            return false;
                        }
                        set.add(tChar);
                        map.put(ch,t.charAt(i));
                    }
                }
            }
        }else{
            return false;
        }

        return true;
    }
}
