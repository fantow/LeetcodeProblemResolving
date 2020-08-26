package Classify400.Array.基础;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_26 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] nums = {1,1,7};

//        ---- test2 ----
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int result = removeDuplicates(nums);

        System.out.println(result);
    }

    // 给定一个排序数组，要求原地删除重复出现的元素
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        int curPtr = 1;
        int savePtr = 1;

        while(curPtr < length){
            if(nums[curPtr - 1] != nums[curPtr]){
                nums[savePtr] = nums[curPtr];
                savePtr++;
            }
            curPtr++;
        }

        return savePtr;
    }
}
