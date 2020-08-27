package Classify400.Array.基础;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_41 {
    public static void main(String[] args) {
//        ---- test1 ----
        int[] nums = {1,2,0};

//        ---- test2 ----
//        int[] nums = {3,4,-1,1};

        int result = firstMissingPositive(nums);

        System.out.println(result);
    }

    // 没想出来，看了题解
    // 和剑指Offer03中的一种解法类似，原地交换nums中的数字到自己对应的位置
    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        if(length == 0 || length == 1){
            return 0;
        }

        for(int i = 0;i < length;i++){
            while(nums[i] > 0 && nums[i] <= length && nums[nums[i] - 1] != nums[i]){
                swap(nums,nums[i] - 1,i);
            }
        }

        for(int i = 0;i < length;i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }

        return length + 1;
    }

    public static void swap(int[] nums,int from,int to){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }


}
