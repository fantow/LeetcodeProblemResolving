package Classify400.Array.基础;

import java.util.Enumeration;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_275 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] citations = {0,1,3,5,6};

//        ---- test2 ----
//        int[] citations = {100};

//        ---- test3 ----
        int[] citations = {0};

        int result = hIndex(citations);

        System.out.println(result);
    }

    // 题目要求将时间复杂度优化到logN
    // 应该是要使用二分法
    // 最后的，目标是找到第一个citations[i] >= n - i的值
    public static int hIndex(int[] citations) {
        int length = citations.length;

        int left = 0;
        int right = length - 1;

//        while(left <= right){
//            int mid = left + (right - left) / 2;
//            if(citations[mid] == length - mid){
//                return length - mid;
//            }else if(citations[mid] < length - mid){
//                left = mid + 1;
//            }else{
//                right = mid - 1;
//            }
//        }

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(citations[mid] < length - mid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return length - left;
    }
}
