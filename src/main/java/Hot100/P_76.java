package Hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

//        String s = "a";
//        String t = "b";

//        String s = "bba";
//        String t = "ab";

//        String s = "aa";
//        String t = "aa";

        String subString = minWindow(s, t);
        System.out.println(subString);
    }

    // 先将s中与t重复的字母记录下来，并且保存其在s的下标，再使用滑动窗口
//    public static String minWindow(String s, String t) {
//        int length1 = s.length();
//        int length2 = t.length();
//
//        if(length1 < length2){
//            return "";
//        }
//
////        Set<Character> dupSet = new HashSet<>();
//        Map<Character,Integer> countMap = new HashMap<>();
//
//        // 因为s中包含t的字母可能重复，所以不能用Map存
//        char[] letterArr = new char[length1];
//        int[] indexArr = new int[length1];
//
//        // 用于记录letterArr中存了多少个元素
//        int index = 0;
//
//        // 需要题目保证t不重复
//        for(Character ch : t.toCharArray()){
////            dupSet.add(ch);
//            // 用于计数
//            if(countMap.containsKey(ch)){
//                countMap.put(ch,countMap.get(ch) + 1);
//            }else{
//                countMap.put(ch,1);
//            }
//        }
//
//        for(int i = 0;i < s.length();i++){
//            if(countMap.containsKey(s.charAt(i))){
//                letterArr[index] = s.charAt(i);
//                indexArr[index] = i;
//                index++;
//            }
//        }
//
//        if(index == 0){
//            return "";
//        }
//
//        index = index - 1;
//        int[] resultIdx = new int[2];
//
//        for(char i : letterArr){
//            System.out.print(i + " ");
//        }
//
//        int min = Integer.MAX_VALUE;
//
//
//
//        // 使用滑动窗口判断，滑动窗口的大小移动固定为t的长度
//        for(int i = length2 - 1;i <= index;i++){
//            // 需要判断当前窗口中是否包含了全部的t
//            // 如果在窗口中不发生contains，说明没有重复
////            Set<Character> set = new HashSet<>();
////
////            boolean flag = false;
////            for(int j = 0;j < length2;j++){
////                if(set.contains(s.charAt(i - j))){
////                    flag = true;
////                    break;
////                }else{
////                    set.add(s.charAt(i - j));
////                }
////            }
//
//            boolean flag = false;
//
//            Map<Character,Integer> map = new HashMap();
//            for(int j = 0;j < length2;j++){
//                if(map.containsKey(s.charAt(i - j))){
//                    map.put(s.charAt(i - j),map.get(s.charAt(i - j)) + 1);
//                }else{
//                    map.put(s.charAt(i - j),1);
//                }
//            }
//
//            if(map.size() != countMap.size()){
//                flag = true;
//            }
//
//            for(int k = 0;k < map.size();k++){
//                if(map.get(t.charAt(k)) != countMap.get(t.charAt(k))){
//                    flag = true;
//                }
//            }
//
//            // 发生了重复
//            if(flag){
//                continue;
//            }else{
//                if(min > (indexArr[i] - indexArr[i - length2 + 1] + 1)){
//                    min = indexArr[i] - indexArr[i - length2 + 1] + 1;
//                    // 需要记录下下标
//                    resultIdx[0] = indexArr[i - length2 + 1];
//                    resultIdx[1] = indexArr[i];
//                }
//            }
//        }
//
//        System.out.println("子串下标:" + resultIdx[0] + " : " + resultIdx[1]);
//
//        return s.substring(resultIdx[0],resultIdx[1] + 1);
//    }


    public static String minWindow(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();

        int left = 0;
        // 窗口至少为length2长度
        int right = -1;

        // 如何判断这个窗口中含有t的所有内容？看到一种优化策略是使用了Map记录当前窗口中还需要什么元素,以及需要几个
        Map<Character,Integer> needMap = new HashMap<>();

        for(char ch : t.toCharArray()){
            if(needMap.containsKey(ch)){
                needMap.put(ch,needMap.get(ch) + 1);
            }else{
                needMap.put(ch,1);
            }
        }

        String result = "";
        int needCount = length2;

        while(right < length1){
            boolean flag = isRight(needMap);

            if(needCount == 0){
                if(result.length() == 0 || result.length() > right - left + 1){
                    result = s.substring(left,right + 1);
                }
                // 最后要移动左指针
                char ch = s.charAt(left);
                if(needMap.containsKey(ch)){
                    if(needMap.get(ch) >= 0){
                        needCount++;
                    }
                    needMap.put(ch,needMap.get(ch) + 1);
                }

                left++;
            }else{
                // 移动右指针
                right = right + 1;

                if(right >= length1){
                    break;
                }else{
                    // 需要这个数
                    if(needMap.containsKey(s.charAt(right))){
                        if(needMap.get(s.charAt(right)) > 0){
                            needCount--;
                        }
                        needMap.put(s.charAt(right),needMap.get(s.charAt(right)) - 1);
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

