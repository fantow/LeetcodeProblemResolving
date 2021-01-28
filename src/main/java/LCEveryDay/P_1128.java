package LCEveryDay;

import java.util.Arrays;
import java.util.Comparator;

public class P_1128 {
    public static void main(String[] args) {

//        int[][] dominoes = {{1,2},{2,1},{3,4},{5,6}};
//        int[][] dominoes = {{1,2},{1,2},{1,1},{1,2},{2,2}};
        int[][] dominoes = {{2,2},{1,2},{1,2},{1,1},{1,2},{1,1},{2,2}};

        int result = numEquivDominoPairs(dominoes);

        System.out.println(result);
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int nums = dominoes.length;
        if(nums <= 1){
            return 0;
        }

        // 需要将dominoes的两个元素转换位置
        for(int i = 0;i < nums;i++){
            int t1 = dominoes[i][0];
            int t2 = dominoes[i][1];

            if(t1 > t2){
                int temp = t1;
                dominoes[i][0] = t2;
                dominoes[i][1] = t1;
            }
        }
//
        Arrays.sort(dominoes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });

//        for(int[] arr : dominoes){
//            for(int num : arr){
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }


        int count = 0;

        // n^2的方案超时
////        for(int i = 0;i < nums;i++){
////            for(int j = i + 1;j < nums;j++){
////                if(dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]){
////                    count++;
////                }
////            }
////        }

        int t1 = 0;
        int t2 = 0;
        int tempCount = 0;

        for(int i = 0;i < nums;i++){
            if(i == 0){
                t1 = dominoes[i][0];
                t2 = dominoes[i][1];
                tempCount = 1;
                continue;
            }

            if(t1 == dominoes[i][0] && t2 == dominoes[i][1]){
                tempCount++;
            }else{
                // 计算方法C(n,2)
                if(tempCount == 2){
                    count += 1;
                }else if(tempCount >= 2){
                    int temp = 1;
                    temp = tempCount * (tempCount - 1);
                    temp /= 2;
                    count += temp;
                }

                t1 = dominoes[i][0];
                t2 = dominoes[i][1];
                tempCount = 1;
            }
        }

        if(tempCount >= 2){
            if(tempCount == 2){
                count += 1;
            }else{
                int temp = 1;
                temp = tempCount * (tempCount - 1);
                temp /= 2;
                count += temp;
            }
        }

        return count;
    }

}
