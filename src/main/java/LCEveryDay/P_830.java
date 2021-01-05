package LCEveryDay;

import java.util.ArrayList;
import java.util.List;

public class P_830 {
    public static void main(String[] args) {
//        String s = "abbxxxxzzy";
//        String s = "abc";
        String s = "abcdddeeeeaabbbcd";
//        String s = "aba";
//        String s = "aaa";

        List<List<Integer>> lists = largeGroupPositions(s);

        for(List<Integer> list : lists){
            for(Integer num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        int length = s.length();

        List<List<Integer>> resultList = new ArrayList<>();

        if(length == 0){
            return resultList;
        }

        int curStart = 0;
        int curEnd = 0;
        while(curEnd < length){
            if(s.charAt(curStart) == s.charAt(curEnd)){
                if(curEnd != length - 1){
                    curEnd++;
                }else{
                    if(curEnd - curStart >= 2){
                        List<Integer> list = new ArrayList<>();
                        list.add(curStart);
                        list.add(curEnd);
                        resultList.add(list);
                    }
                    curEnd++;
                }
            }else{
                if(curEnd - curStart >= 3){
                    List<Integer> list = new ArrayList<>();
                    list.add(curStart);
                    list.add(curEnd - 1);
                    resultList.add(list);
                }
                curStart = curEnd;
            }
        }

        return resultList;
    }
}
