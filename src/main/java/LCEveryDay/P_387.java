package LCEveryDay;

import java.util.HashMap;
import java.util.Map;

public class P_387 {
    public static void main(String[] args) {
//        String s = "leetcode";
        String s = "loveleetcode";
        int result = firstUniqChar(s);

        System.out.println(result);
    }

    public static int firstUniqChar(String s) {
        int length = s.length();
        if(length <= 1){
            return length - 1;
        }

        Map<Character,Integer> countMap = new HashMap<>();

        for(Character ch : s.toCharArray()){
            countMap.put(ch,countMap.getOrDefault(ch,0) + 1);
        }

        for(int i = 0;i < length;i++){
            Character ch = s.charAt(i);

            if(countMap.get(ch) == 1){
                return i;
            }
        }

        return -1;
    }
}
