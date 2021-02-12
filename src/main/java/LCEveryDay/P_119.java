package LCEveryDay;

import java.util.ArrayList;
import java.util.List;

public class P_119 {
    public static void main(String[] args) {
        int rowIndex = 10;
        List<Integer> list = getRow(rowIndex);

        for(Integer num : list){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // 类似于DP，需要记忆化
    public static List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0){
            return new ArrayList<Integer>(){{add(1);}};
        }else if(rowIndex == 1){
            return new ArrayList<Integer>(){{add(1);add(1);}};
        }

        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(1);

        for(int i = 2;i <= rowIndex;i++){
            List<Integer> tempList = new ArrayList<>();
            tempList.add(1);

            for(int j = 1;j < temp.size();j++){
                tempList.add(temp.get(j) + temp.get(j - 1));
            }

            // 最后添加一个1
            tempList.add(1);
            temp = tempList;
        }

        return temp;
    }
}
