package LCEveryDay;

import java.util.HashMap;
import java.util.Map;

public class P_567 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

//        String s1 = "ab";
//        String s2 = "eidboaoo";

//        String s1 = "a";
//        String s2 = "ab";

        boolean flag = checkInclusion(s1, s2);
        System.out.println(flag);
    }

    // 窗口大小定长的滑动窗口问题
    public static boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();

        if(length1 > length2){
            return false;
        }

        // 减少对Map的遍历
        int count = 0;
        int tempCount = 0;

        // char --> 出现次数
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s1.toCharArray()){
            count++;
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }

        int left = 0;
        int right = 0;

        Map<Character,Integer> tempMap = new HashMap<>();

        while(right < length2){
//            System.out.println("left: " + left + " right: " + right);
            // 添加right元素进来
            tempMap.put(s2.charAt(right),tempMap.getOrDefault(s2.charAt(right),0) + 1);
            tempCount++;

            // 如果right >= length1，说明需要出队元素了
            if (right - left + 1 > length1){
                tempMap.put(s2.charAt(left),tempMap.get(s2.charAt(left)) - 1);
                tempCount--;
                if(tempMap.get(s2.charAt(left)) == 0){
                    tempMap.remove(s2.charAt(left));
                }
                left++;
            }

            // 比较两个Map是否相等
            if(count == tempCount && map.equals(tempMap)){
                return true;
            }

            right++;
        }

        return false;
    }
}
