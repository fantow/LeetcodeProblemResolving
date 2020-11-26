package LCEveryDay;

import Hot100.P_2;

import java.util.Arrays;

public class P_164 {
    public static void main(String[] args) {
//        int[] nums = {3,6,9,1};
//        int[] nums = {10};
        int[] nums = {1,1,1,1};
        int gap = maximumGap(nums);

        System.out.println(gap);
    }

    // 正解应该是使用桶排序
    public static int maximumGap(int[] nums) {
        int length = nums.length;
        if(length == 0 || length == 1){
            return 0;
        }

        // 计算桶的容量和桶的个数
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0;i < length;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }

        int capacity = Math.max(1,(max - min) / (length - 1));
        int count = (max - min) / capacity + 1;

        // 需要遍历所有的元素，但是并不需要将所有元素存入桶
        // 只需要存桶中的最大和最小值就行了
        int[][] bucket = new int[count][2];

        for(int i = 0;i < count;i++){
            bucket[i][0] = -1;
            bucket[i][1] = -1;
        }

        int result = Integer.MIN_VALUE;

        for(int i = 0;i < length;i++){
            int idx = (nums[i] - min) / capacity;

            if(bucket[idx][0] == -1){
                bucket[idx][0] = nums[i];
                bucket[idx][1] = nums[i];
            }else{
                bucket[idx][0] = Math.min(bucket[idx][0],nums[i]);
                bucket[idx][1] = Math.max(bucket[idx][1],nums[i]);
            }
            result = Math.max(result,bucket[idx][1] - bucket[idx][0]);
        }


        for(int i = 0;i < count;i++){
            for(int j = 0;j < 2;j++){
                System.out.print(bucket[i][j] + " ");
            }
            System.out.println();
        }


        // 计算桶间
        int prev = -1;
        for(int i = 0;i < count;i++){
            if(bucket[i][0] == -1){
                continue;
            }

            if(prev != -1){
                result = Math.max(result,bucket[i][0] - bucket[prev][1]);
            }
            prev = i;
        }

        return result;
    }


    // 直接使用Arrays.sort()居然通过了
    public static int maximumGap1(int[] nums) {
        int length = nums.length;
        if(length == 0 || length == 1){
            return 0;
        }

        Arrays.sort(nums);

        int result = 0;

        for(int i = 1;i < length;i++){
            result = Math.max(result,nums[i] - nums[i - 1]);
        }

        return result;
    }
}
