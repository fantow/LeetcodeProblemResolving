package Hot100;

import java.util.HashMap;
import java.util.Map;

public class P_560 {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;

//        int[] nums = {1};
//        int k = 0;

//        int[] nums = {100,1,2,3,100,1,2,3,4};
//        int k = 3;

//        int[] nums = {1,-1,0};
//        int k = 0;

        int result = subarraySumPro(nums, k);
        System.out.println(result);
    }

    // 因为求得是连续子数组，所以应该使用滑动窗口
    // 前缀和/二维DP，双指针是否只能暴力遍历？因为数组无序，无法优化


    // 使用前缀和
    public static int subarraySum(int[] nums, int k) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        int[] sumArr = new int[length + 1];

        sumArr[0] = 0;

        for(int i = 1;i <= length;i++){
            sumArr[i] = sumArr[i - 1] + nums[i - 1];
        }

        int count = 0;

        for(int i = 0;i <= length;i++){
            for(int j = i + 1;j <= length;j++){
                if(sumArr[j] - sumArr[i] == k){
                    System.out.println(sumArr[i] + " -> " + sumArr[j]);
                    count++;
                }
            }
        }

        return count;
    }


    // 使用Hash结构优化前缀和
    public static int subarraySumPro(int[] nums, int k) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        // 前缀和 --> 出现次数
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int preSum = 0;
        int count = 0;

        for(int i = 0;i < length;i++){
            preSum += nums[i];

            if(map.containsKey(preSum - k)){
                count += map.get(preSum - k);
            }

            map.put(preSum,map.getOrDefault(preSum,0) + 1);
        }

        return count;
    }



    // 当前写法超出内存限制，可以优化一下二维DP
    // 优化后超时间复杂度，不能使用O(n^2)的算法
    public static int subarraySum1(int[] nums, int k) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        // dpArr[i][j] 表示下标为i~j部分的和
//        int[][] dpArr = new int[length][length];
        int[][] dpArr = new int[2][length];
        int count = 0;

        // 数组初始化
//        for(int i = 0;i < length;i++){
//            dpArr[i][i] = nums[i];
//            if(dpArr[i][i] == k){
//                count++;
//            }
//        }

//        for(int j = 1;j < length;j++){
//            dpArr[0][j] = nums[j] + dpArr[0][j - 1];
//            if(dpArr[0][j] == k){
//                count++;
//            }
//        }

//         代替对第一行的初始化
        for(int j = 0;j < length;j++){
            if(j == 0){
                dpArr[0][j] = nums[j];
                if(dpArr[0][j] == k){
                    count++;
                }
                continue;
            }
            dpArr[0][j] = nums[j] + dpArr[0][j - 1];
            if(dpArr[0][j] == k){
                count++;
            }
        }


        // 从上往下，从左向右推导
//        for(int i = 1;i < length;i++){
//            for(int j = i + 1;j < length;j++){
//                dpArr[i][j] = dpArr[i - 1][j] - nums[i - 1];
//                if(dpArr[i][j] == k){
//                    count++;
//                }
//            }
//        }

//        for(int i = 0;i < length;i++){
//            System.out.print(dpArr[0][i] + " ");
//        }
//        System.out.println();

        // 优化推导过程
        for(int i = 1;i < length;i++){
            for(int j = i;j < length;j++){
                if(j == i){
                    dpArr[i % 2][j] = nums[i];
                    if(dpArr[i % 2][j] == k){
                        count++;
                    }
                    continue;
                }
                dpArr[i % 2][j] = dpArr[(i-1) % 2][j] - nums[i - 1];
                if(dpArr[i % 2][j] == k){
                    count++;
                }
            }

//            for(int j = 0;j < length;j++){
//                System.out.print(dpArr[0][j] + " ");
//            }
//            System.out.println();
//
//            for(int j = 0;j < length;j++){
//                System.out.print(dpArr[1][j] + " ");
//            }
//            System.out.println();
        }

        return count;
    }
}
