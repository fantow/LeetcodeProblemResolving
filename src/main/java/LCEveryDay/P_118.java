package LCEveryDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_118 {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> lists = generate(numRows);
        for(List<Integer> list : lists){
            System.out.println(list);
        }
    }

    // 应该是用DP做
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        // 初始化List
        if(numRows == 0){
            return resultList;
        }

        List<Integer> list = new ArrayList<>();
        list.add(1);

        resultList.add(list);

        if(numRows == 1){
            return resultList;
        }

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        resultList.add(list1);
        if(numRows == 2){
            return resultList;
        }

        // 开始推导
        for(int i = 2;i < numRows;i++){
            // 获取到上一个list
            List<Integer> lastList = resultList.get(i - 1);
            List<Integer> tempList = new ArrayList<>();

            tempList.add(1);
            for(int j = 1;j < lastList.size();j++){
                tempList.add(lastList.get(j - 1) + lastList.get(j));
            }

            tempList.add(1);
            resultList.add(tempList);
        }

        return resultList;
    }
}
