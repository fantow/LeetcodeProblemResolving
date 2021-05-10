package CodeTop;

import java.util.HashMap;
import java.util.Map;

// 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
public class P_3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
//        String s = "";

        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }


    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();

        int resultLength = 0;

        if(length <= 1){
            return length;
        }

//        char[] chars = s.toCharArray();

        // 当前窗口中的字符 --> 出现的下标
        Map<Character,Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

//        map.put(chars[left],left);
//        map.put(s.charAt(left),left);
//        right++;
//        resultLength = 1;

        while(right < length){
            // 如果不存在，则直接right++，并将map中存入该字符
            if(!map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),right);
                resultLength = Math.max(resultLength,(right - left) + 1);

            }else {
                // 发生重复的位置
                int newIdx = map.get(s.charAt(right));
                // 如果发生重复
                while(left <= newIdx){
                    map.remove(s.charAt(left));
                    left++;
                }

                map.put(s.charAt(right),right);
            }

            right++;
        }

        return resultLength;
    }
}
