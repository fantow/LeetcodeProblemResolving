package JZOffer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_50 {
    public static void main(String[] args) {
//        ---- test1 ----
//        String s = "abaccdeff";

//        ---- test2 ----
        String s = "leetcode";

        char ch = firstUniqChar(s);

        System.out.println(ch);
    }

    public static char firstUniqChar(String s) {
        int length = s.length();
        if(length == 0){
            return ' ';
        }
        if(length == 1){
            return s.charAt(0);
        }

        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i = 0;i < length;i++){
            char ch = s.charAt(i);
            if(map.get(ch) != null){
                map.put(ch,map.get(ch) + 1);
            }else{
                map.put(ch,1);
            }
        }

        char result = ' ';
        for(Map.Entry entry : map.entrySet()){
            if((Integer)entry.getValue() == 1){
                return (char)entry.getKey();
            }
        }

        return result;
    }
}
