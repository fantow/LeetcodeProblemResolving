package Hot100;

public class P_55 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(nums);
        System.out.println(result);
    }

    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }else if(length == 1){
            return nums[0];
        }

        int[] sums = new int[length + 1];
        sums[0] = 0;

        for(int i = 0;i < length;i++){
            sums[i + 1] = Math.max(nums[i],sums[i] + nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1;i <= length;i++){
            if(max < sums[i]){
                max = sums[i];
            }
        }

        return max;
    }
}
