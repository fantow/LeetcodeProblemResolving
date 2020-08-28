package Classify400.Array.基础;

import java.util.Arrays;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_274 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] citations = {3,0,6,1,5};

//        ---- test2 ----
//        int[] citations = {1,1,1,1,1,1};

//        ---- test3 ----
        int[] citations = {100};

//        ---- test4 ----
//        int[] citations = {0};

        int result = hIndex(citations);
        System.out.println(result);
    }

    public static int hIndex(int[] citations) {
        int length = citations.length;

        if(length  == 0){
            return length;
        }

        // 先对citations进行排序
        Arrays.sort(citations);

        int maxResult = 0;

        // 这个num不仅和剩下的长度有关，还和本身的长度有关
        for(int i = 0;i < length;i++){
            if(citations[i] > 0) {
                if (citations[i] <= length - i) {
                    maxResult = citations[i];
                } else {
                    maxResult = Math.max(maxResult, length - i);
                }
            }
        }

        return maxResult;
    }
}
