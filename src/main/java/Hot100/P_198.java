package Hot100;

public class P_198 {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};
        int[] nums = {2,7,9,3,1};
//        int[] nums = {2,1,1,2};

        int i = rob(nums);

        System.out.println(i);
    }
    public static int rob(int[] nums) {
        int length = nums.length;
        if(length <= 1){
            return length == 0 ? 0 : nums[0];
        }

        // dp[i]存的是抢下标i的家，收益的最大值
        int[] dpArr = new int[length];

        // 对dpArr初始化
        dpArr[0] = nums[0];
        dpArr[1] = Math.max(nums[0],nums[1]);

        for(int i = 2;i < length;i++){
            dpArr[i] = Math.max(dpArr[i - 1],dpArr[i - 2] + nums[i]);
        }

        for(int i = 0;i < length;i++){
            System.out.print(dpArr[i] + " ");
        }
        System.out.println();

        return dpArr[length - 1] > dpArr[length - 2] ? dpArr[length - 1] : dpArr[length - 2];
    }
}
