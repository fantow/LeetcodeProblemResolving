package Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_30 {
    public static void main(String[] args) {

//        String s =  "barfoothefoobarman";
//        String[] words = {"foo","bar"};

        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};

        List<Integer> list = findSubstring(s, words);
        for(int i : list){
            System.out.print(i + " ");
        }

    }

    public static List<Integer> findSubstring(String s, String[] words) {
        int length = s.length();

        Map<String,Integer> needMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();

        if(words.length == 0){
            return new ArrayList<>();
        }

        int wordLength = words[0].length();

        for(String word : words){
            if(needMap.containsKey(word)){
                needMap.put(word,needMap.get(word) + 1);
            }else{
                needMap.put(word,1);
            }
        }

        if(length < words.length * wordLength){
            return new ArrayList<>();
        }

        int totalLength = words.length * wordLength;
        for(int i = 0;i <= s.length() - totalLength;i++){
            boolean flag = false;
            String substring = s.substring(i, i + totalLength);

            Map<String,Integer> tempMap = new HashMap<>();

            // 这里有优化空间
            for(int j = 0;j < totalLength;j += wordLength){
                String word = substring.substring(j,j + wordLength);
                if(!needMap.containsKey(word)){
                    flag = true;
                    break;
                }
                tempMap.put(word,tempMap.getOrDefault(word,0) + 1);
            }

//            if(needMap.equals(tempMap)){
//                resultList.add(i);
//                System.out.println("add:" + i);
//            }


            if(flag){
                continue;
            }else {
                if (needMap.equals(tempMap)) {
                    resultList.add(i);
                }
            }
        }

        return resultList;
    }

}
