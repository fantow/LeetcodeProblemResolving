package Classify400.Array.基础;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_80 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] nums = {1,1,1,2,2,3};

//        ---- test2 ----
        int[] nums = {0,0,1,1,1,1,2,3,3};

        int result = removeDuplicates(nums);

        System.out.println(result);
    }

    // 给定一个排序数组，使得每个元素最多出现两次，多余的元素要被原地删除
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        int count = 1;

        int curPtr = 1;
        int savePtr = 1;

        while(curPtr < length){
            if(nums[curPtr - 1] != nums[curPtr]){
                nums[savePtr] = nums[curPtr];
                savePtr++;
                count = 1;
            }else if(nums[curPtr - 1] == nums[curPtr] && count < 2){
                nums[savePtr] = nums[curPtr];
                count++;
                savePtr++;
            }
            curPtr++;
        }

        return savePtr;
    }
}
