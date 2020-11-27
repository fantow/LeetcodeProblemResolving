package Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_438 {
    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String p = "abc";

        String s = "abab";
        String p = "ab";

        List<Integer> list = findAnagrams(s, p);
        System.out.println(list);
    }

    // 这里说是要找到异位词，但是相同顺序的也会被算为结果
    public static List<Integer> findAnagrams(String s, String p) {
        int length1 = s.length();
        int length2 = p.length();

        List<Integer> resultList = new ArrayList<>();

        if(length1 < length2){
            return resultList;
        }

        // 一个问题：如何在进行窗口滑动的同时，判断窗口中的元素组成与p相同？

        // tempMap用于记录窗口内的元素组成
        Map<Character,Integer> tempMap = new HashMap<>();


        // countMap用于记录s的元素组成
        Map<Character,Integer> countMap = new HashMap<>();

        for(int i = 0;i < length2;i++){
            countMap.put(p.charAt(i),countMap.getOrDefault(p.charAt(i),0) + 1);
        }

        int left = 0;

        // 保证right指向的元素已经被包含
        int right = 0;

        while(right < length1){
//
            System.out.println("--------------------");
            System.out.println("left: " + left + " right: " + right);
            for(Map.Entry<Character,Integer> entry : tempMap.entrySet()){
                System.out.print(entry.getKey() + " : " + entry.getValue() + " ");
            }
            System.out.println();

            while(right < length1 && right - left < length2){
                tempMap.put(s.charAt(right),tempMap.getOrDefault(s.charAt(right),0) + 1);
                right++;
            }


            if(tempMap.equals(countMap)){
                resultList.add(left);
                tempMap.put(s.charAt(left),tempMap.get(s.charAt(left)) - 1);
                left++;
            }else{
                int cot = tempMap.get(s.charAt(left));
                if(cot == 1){
                    tempMap.remove(s.charAt(left));
                }else{
                    tempMap.put(s.charAt(left),tempMap.get(s.charAt(left)) - 1);
                }
                left++;
//                tempMap.put(s.charAt(right),tempMap.getOrDefault(s.charAt(right),0) + 1);
//                right++;
            }
        }

        return resultList;
    }
}
