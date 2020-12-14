package LCEveryDay;

import java.util.*;

public class P_49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strs = {};
        List<List<String>> lists = groupAnagrams(strs);

        for(List<String> list : lists){
            System.out.println(list);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        int length = strs.length;

        List<List<String>> resultList = new ArrayList<>();

        if(length == 0){
            return resultList;
        }

        Map<String,List<String>> map = new HashMap<>();

        // 将strs中的所有字符串按字典顺序排放
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String s = new String(chars);
            if(map.containsKey(s)){
                map.get(s).add(str);
            }else{
                map.put(s,new ArrayList<String>(){{add(str);}});
            }
        }

        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            resultList.add(entry.getValue());
        }

        return resultList;
    }
}
