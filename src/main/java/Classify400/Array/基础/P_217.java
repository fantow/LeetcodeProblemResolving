package Classify400.Array.基础;

import java.util.Arrays;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_217 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] nums = {1,2,3,1};

//        ---- test2 ----
        int[] nums = {1,2,3,4};

        boolean flag = containsDuplicate(nums);

        System.out.println(flag);
    }

    // 排序后判断
    public static boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        if(length <= 1){
            return false;
        }

        Arrays.sort(nums);

        for(int i = 0;i < length - 1;i++){
            if(nums[i] == nums[i + 1]){
                return true;
            }
        }
        return false;
    }
}
