package LCEveryDay;

public class P_724 {
    public static void main(String[] args) {
//        int[] nums = {1, 7, 3, 6, 5, 6};
//        int[] nums = {1, 2, 3};
        int[] nums = {-1,-1,-1,0,1,1};
        int result = pivotIndex(nums);

        System.out.println(result);
    }

    public static int pivotIndex(int[] nums) {
        int length = nums.length;
        if(length <= 2){
            return -1;
        }

        // 先计算sum
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        int leftSum = 0;

        // rightSum = sum - nums[i] - leftSum;
        for(int i = 0;i < length;i++){
            if(leftSum == sum - nums[i] - leftSum){
                return i;
            }else{
                leftSum += nums[i];
            }
        }

        return -1;
    }
}
