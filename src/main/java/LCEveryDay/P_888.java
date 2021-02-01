package LCEveryDay;

import java.util.*;

public class P_888 {
    public static void main(String[] args) {
//        int[] A = {1,1};
//        int[] B = {2,2};

//        int[] A = {1,2};
//        int[] B = {2,3};

//        int[] A = {2};
//        int[] B = {1,3};

        int[] A = {1,2,5};
        int[] B = {2,4};

        int[] resultArr = fairCandySwap(A, B);

        for(int num : resultArr){
            System.out.print(num + " ");
        }
        System.out.println();

    }

    // 用Map保存其中一个数组的元素内容
    public static int[] fairCandySwap(int[] A, int[] B) {
        Set<Integer> set = new HashSet<>();

        int[] arr = new int[2];

        for(int num : B){
            set.add(num);
        }

        Arrays.sort(A);

        int sumA = 0;
        int sumB = 0;

        for(int num : A){
            sumA += num;
        }

        for(int num : B){
            sumB += num;
        }

        // 题目保证了两个sum的和一定不会相等
        int diff = sumA - sumB;

        // sumA 小于 sumB
        if(diff < 0){
            // 需要从B中获取大的到A
            int diffVal = Math.abs(diff) / 2;
            for(int num : A){
                if(set.contains(num + diffVal)){
                    arr[0] = num;
                    arr[1] = num + diffVal;
                    return arr;
                }
            }
        }else{
            int diffVal = Math.abs(diff) / 2;
            for(int num : A){
                if(set.contains(num - diffVal)){
                    arr[0] = num;
                    arr[1] = num - diffVal;
                    return arr;
                }
            }
        }

        return arr;
    }
}
