package Classify400.Array.基础;

import java.util.Arrays;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_45 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int result = jump1(nums);

        System.out.println(result);
    }

    // 方法1.正着推
    public static int jump(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        int[] dpArr = new int[length];
        for(int i = 0;i < length;i++){
            dpArr[i] = Integer.MAX_VALUE;
        }
        dpArr[0] = 0;

        for(int i = 0;i < length;i++){
            int step = nums[i];
            for(int j = 1;j <= step && i + j < length;j++){
                if(i == 0){
                    dpArr[i + j] = 1;
                }else{
                    dpArr[i + j] = Math.min(dpArr[i + j],dpArr[i] + 1);
                }
            }
            System.out.print("step:" + step + "dpArr:");
        }

        return dpArr[length - 1] == Integer.MAX_VALUE ? -1 : dpArr[length - 1];
    }

    // 方法2.使用贪心，每次找到涉及范围内最大的步子
    public static int jump1(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        int maxPosition = 0;
        int steps = 0;
        int end = 0;

        for(int i = 0;i < length - 1;i++){
            maxPosition = Math.max(maxPosition,nums[i] + i);
            // end记录的是本步最多能到达哪个格子
            if(i == end){
                end = maxPosition;
                steps++;
            }
        }

        return steps;
    }



}
