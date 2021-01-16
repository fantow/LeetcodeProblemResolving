package Company.ByteDance;

import java.util.HashMap;
import java.util.Map;

public class P_3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
//        String s = "";
//        String s = "abba";
        int length = lengthOfLongestSubstring(s);

        System.out.println(length);
    }


    // 这个是普通做法
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(length <= 1){
            return length;
        }

        Map<Character,Integer> map = new HashMap<>();

        int maxLength = 0;
        int temp = 0;
        int start = 0;
        for(int i = 0;i < length;i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                temp++;
                map.put(ch,i);
            }else{
                // 发生了冲突
                int idx = map.get(ch);
                for(int st = start;st <= idx;st++){
                    map.remove(s.charAt(st));
                }
                map.put(ch,i);
                start = idx + 1;
                temp = i - (idx + 1) + 1;
            }
            maxLength = Math.max(maxLength,temp);
        }

        return maxLength;
    }
}
