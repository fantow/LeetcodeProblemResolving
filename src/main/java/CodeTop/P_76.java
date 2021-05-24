package CodeTop;

import java.util.HashMap;
import java.util.Map;

public class P_76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String str = minWindow(s, t);
        System.out.println(str);
    }

    // 不用管t中字符出现的顺序，出现就行
    // 采用滑动窗口方法
    public static String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if(sLen < tLen){
            return "";
        }

        int left = 0;
        int right = -1;

        // 如果t中存在重复字符，应该怎么处理？
        // map中用来记录还需要什么字符，以及还需要几个
        Map<Character,Integer> map = new HashMap<>();

        // 对map进行初始化
        for(int i = 0;i < tLen;i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0) + 1);
        }

        String result = "";

        while(right < sLen){
            boolean flag = isRight(map);

            if(flag) {
                if(result.length() == 0 || result.length() > right - left + 1){
                    result = s.substring(left,right + 1);
                }

                char ch = s.charAt(left);
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch) + 1);
                }

                left++;
            }else {
                right++;

                if(right >= sLen){
                    break;
                }else{
                    if(map.containsKey(s.charAt(right))){
                        map.put(s.charAt(right),map.get(s.charAt(right)) - 1);
                    }
                }
            }
        }

        return result;
    }

    public static boolean isRight(Map<Character,Integer> map){
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() > 0){
                return false;
            }
        }
        return true;
    }
}
