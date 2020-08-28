package Classify400.Array.基础;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_118 {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> lists = generate(numRows);

        for(List list : lists){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        if(numRows == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> listResult = new ArrayList<>();
        listResult.add(new ArrayList<Integer>(){{add(1);}});

        for(int i = 1;i < numRows;i++){
            // 获取到上层List
            List<Integer> upList = listResult.get(i - 1);
            List<Integer> tempList = new ArrayList<>();
            for(int j = 0;j <= i;j++){
                // 如果是第一个，添加1
                if(j == 0){
                    tempList.add(1);
                }else if(j == i){
                    // 如果是最后一个，添加1
                    tempList.add(1);
                }else{
                    tempList.add(upList.get(j - 1) + upList.get(j));
                }
            }
            listResult.add(new ArrayList<>(tempList));
        }
        return listResult;
    }
}
