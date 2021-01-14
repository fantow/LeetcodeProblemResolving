package LCEveryDay;

import java.util.ArrayList;
import java.util.List;

// 输入：[0,1,1]
// 输出：[true,false,false]

// 输入：[1,1,1]
// 输出：[false,false,false]

// 输入：[0,1,1,1,1,1]
// 输出：[true,false,false,false,true,false]

// 输入：[1,1,1,0,1]
// 输出：[false,false,false,false,false]
public class P_1018 {
    public static void main(String[] args) {
        int[] A = {0,1,1};
        List<Boolean> result = prefixesDivBy5(A);

        for(Boolean flag : result){
            System.out.print(flag + " ");
        }
        System.out.println();
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> resultList = new ArrayList<>();
        int length = A.length;
        if(length == 0){
            return resultList;
        }

        int temp = 0;

        for(int i = 0;i < length;i++){
            temp = temp * 2 + A[i];

            if(temp >= 10){
                temp = temp - 10;
            }

            if(temp % 5 == 0){
                resultList.add(true);
            }else{
                resultList.add(false);
            }
        }

        return resultList;
    }
}
