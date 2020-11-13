package Hot100;

import java.util.HashMap;
import java.util.Map;

public class P_3 {
    public static void main(String[] args) {

//        String s = "abcabcbb";
//        String s = "bbbbb";
        String s = "pwwkew";
//        String s = "abba";

        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(length <= 1){
            return length;
        }

        Map<Character,Integer> map = new HashMap<>();

        // 用数组来存当前下标为i的数字，可以构成的最长子串
        int[] result = new int[length + 1];
        int max = Integer.MIN_VALUE;

        for(int i = 1;i <= length;i++){
            if(!map.containsKey(s.charAt(i - 1))){
                result[i] = result[i - 1] + 1;
            }else{
                int preIndex = map.get(s.charAt(i - 1));

                result[i] = Math.min(i - preIndex,result[i - 1] + 1);
            }
            map.put(s.charAt(i - 1),i);

            if(max < result[i]){
                max = result[i];
            }
        }

        return max;
    }
}
