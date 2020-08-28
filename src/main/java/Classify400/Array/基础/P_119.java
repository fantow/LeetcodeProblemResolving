package Classify400.Array.基础;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_119 {
    public static void main(String[] args) {

        int rowIndex = 0;

        List<Integer> list = getRow(rowIndex);

        System.out.println(list);
    }


    // 要求优化到时间复杂度为O(k)
    public static List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0){
            return new ArrayList<Integer>(){{add(1);}};
        }
        List<Integer> upList = new ArrayList<Integer>(){{add(1);}};
        List<Integer> curList = upList;
        for(int i = 1;i <= rowIndex;i++){
            curList = new ArrayList<>();
            for(int j = 0;j <= i;j++){
                if(j == 0){
                    curList.add(1);
                }else if(j == i){
                    curList.add(1);
                }else{
                    curList.add(upList.get(j - 1) + upList.get(j));
                }
            }
            upList = curList;
        }

        return curList;
    }
}
