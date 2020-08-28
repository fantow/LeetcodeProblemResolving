package Classify400.Array.基础;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_169 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] nums = {3,2,3};

//        ---- test2 ----
//        int[] nums = {2,2,1,1,1,2,2};

//        ---- test3 ----
        int[] nums = {1,2,2,1,1,2,2};

        int result = majorityElement(nums);

        System.out.println(result);
    }

    // 采用__计数法
    public static int majorityElement(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return -1;
        }

        int result = nums[0];
        int count = 1;

        for(int i = 1;i < length;i++){
            if(result == nums[i]){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                result = nums[i];
                count = 1;
            }
        }

        return count > 0 ? result : -1;
    }
}
