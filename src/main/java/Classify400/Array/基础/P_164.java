package Classify400.Array.基础;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description:
 * @Author chenyang270@jd.com
 * @CreateDate
 * @Version: 1.0
 */
public class P_164 {
    public static void main(String[] args) {
//        ---- test1 ----
        int[] nums = {3,6,9,1};

//        ---- test2 ----
//        int[] nums = {10};

        int result = maximumGap2(nums);
        System.out.println(result);
    }

    // 最简单的解决方式，先排序，再遍历一次
    // 如果是要求时间复杂度为O(n)，一定不能用比较类型的排序方法，一定会超过log2n
    public static int maximumGap(int[] nums) {
        int length = nums.length;
        if(length < 2){
            return 0;
        }

        Arrays.sort(nums);
        int maxGap = Integer.MIN_VALUE;
        for(int i = 0;i < length - 1;i++){
            int gap = nums[i + 1] - nums[i];
            maxGap = Math.max(maxGap,gap);
        }

        return maxGap;
    }


    // 使用空间换时间，计数排序，将数字存在辅助数组中
    public static int maximumGap1(int[] nums) {
        int length = nums.length;
        if(length < 2){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num : nums){
            max = Math.max(num,max);
            min = Math.min(num,min);
        }

        int bias = 0 - min;

        int[] tempArr = new int[max - min + 1];
        for(int num : nums){
            tempArr[bias + num]++;
        }

        int result = 0;
        int ptr = -1;

        for(int i = 0;i < tempArr.length;i++){
            if(tempArr[i] != 0){
                if(ptr != -1){
                    result = Math.max(result,i - ptr);
                }
                ptr = i;
            }
        }
        return result;
    }


    public static class Bucket{
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    // 使用桶排序
    public static int maximumGap2(int[] nums) {
        int length = nums.length;
        if(length < 2){
            return 0;
        }

        // 如果给定的数字都是连续的，这样可以保证会有一个元素不在这个桶中

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num : nums){
            max = Math.max(max,num);
            min = Math.min(min,num);
        }

        int bucketSize = Math.max((max - min) / (nums.length - 1), 1);

        Bucket[] buckets = new Bucket[(max -min) / bucketSize + 1];

        for(int i = 0;i < length;i++){
            int idx = (nums[i] - min) /bucketSize;
            if(buckets[idx] == null){
                buckets[idx] = new Bucket();
            }
            buckets[idx].max = Math.max(buckets[idx].max,nums[i]);
            buckets[idx].min = Math.min(buckets[idx].min,nums[i]);
        }

        int preMax = -1;
        int maxGap = 0;

        for(int i = 0;i < buckets.length;i++){
            if(buckets[i] != null && preMax != -1){
                // 因为要找的是相邻元素的最大间距，所以要用本桶的min - 前一个桶的preMax
                maxGap = Math.max(maxGap,buckets[i].min - preMax);
            }

            if(buckets[i] != null){
                preMax = buckets[i].max;
            }
        }

        return maxGap;
    }

}
