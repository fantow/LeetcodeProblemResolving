package Classify400.Array.基础;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_220 {
    public static void main(String[] args) {

//        ---- test1 ----
//        int[] nums = {1,2,3,1};
//        int k = 3;
//        int t = 0;

//        ---- test2 ----
//        int[] nums = {1,0,1,1};
//        int k = 1;
//        int t = 2;

//        ---- test3 ----
//        int[] nums = {1,5,9,1,5,9};
//        int k = 2;
//        int t = 3;

//        ---- test4 ----
//        int[] nums = {-1,2147483647};
//        int k = 1;
//        int t = 2147483647;

//        ---- test5 ----
        int[] nums = {2147483647,-2147483647};
        int k = 1;
        int t = 2147483647;

        boolean flag = containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(flag);
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int length = nums.length;
        if(k == 0){
            return false;
        }

        if(length <= 1){
            return false;
        }

        for(int i = 0;i < length;i++){
            for(int j = 1;j <= k && i + j < length;j++){

                long temp = (long)nums[i] - nums[i + j];
                System.out.println(temp);
                if(temp < 0){
                    temp = - temp;
                }
                if(temp <= t){
                    return true;
                }
            }
        }

        return false;
    }
}
