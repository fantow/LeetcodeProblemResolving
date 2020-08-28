package Classify400.Array.基础;

import java.util.HashSet;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_219 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] nums = {1,2,3,1};
//        int k = 3;

//        ---- test2 ----
//        int[] nums = {1,0,1,1};
//        int k = 1;

//        ---- test3 ----
        int[] nums = {1,2,3,1,2,3};
        int k = 2;

        boolean flag = containsNearbyDuplicate1(nums, k);
        System.out.println(flag);
    }

    // k相当于设置了一个滑动窗口
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;

        if(length < k){
            k = length;
        }

        for(int i = 0;i < length - 1;i++){
            for(int j = 1;j <= k && i + j < length ;j++){
                if(nums[i] == nums[i + j]){
                    return true;
                }
            }
        }

        return false;
    }

    // 利用空间换时间，通过hashSet检查是否存在重复
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        int length = nums.length;

        if(k == 0){
            return false;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0;i < length;i++){
            if(set.contains(nums[i])){
                return true;
            }

            if(set.size() == k){
                set.remove(nums[i - k]);
            }
            set.add(nums[i]);
        }
        return false;
    }

}
