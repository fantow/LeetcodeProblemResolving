package Classify400.Array.基础;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_27 {
    public static void main(String[] args) {

        int[] nums = {3,2,2,3};
        int val = 3;

        int result = removeElement(nums, val);
        System.out.println(result);
    }

    // 题目难度在于要求原地删除
    // 使用双指针，一个用于遍历，一个用于存数据
    // 比较简单
    public static int removeElement(int[] nums, int val) {
        int curPtr = 0;
        int savePtr = 0;
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        while(curPtr < length){
            if(nums[curPtr] != val){
                nums[savePtr] = nums[curPtr];
                savePtr++;
            }
            curPtr++;
        }

        return savePtr;
    }


}
