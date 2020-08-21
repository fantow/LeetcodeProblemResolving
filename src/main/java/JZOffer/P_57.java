package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_57 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] nums = {2,7,11,15};
//        int target = 9;

//        ---- test2 ----
        int[] nums = {10,26,30,31,47,60};
        int target = 40;
        int[] resultArr = twoSum(nums, target);

        for(int a : resultArr){
            System.out.print(a + " ");
        }
    }

    // 双指针
    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        if(length <= 1){
            return new int[]{};
        }

        int left = 0;
        int right = length - 1;
        while(left < right){
            if(nums[left] + nums[right] == target){
                return new int[]{nums[left],nums[right]};
            }else if(nums[left] + nums[right] > target){
                right--;
            }else{
                left++;
            }
        }

        return new int[]{};
    }
}
