package CodeTop;

public class P_198 {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};
        int[] nums = {2,7,9,3,1};

        int res = rob(nums);
        System.out.println(res);
    }

    // 如果两间相邻的房屋在同一天被偷，系统会报警
    public static int rob(int[] nums) {
        int length = nums.length;

        // dpArr[i][0/1]，代表第i个房间，没被偷/被偷时的最大金额
        int[][] dpArr = new int[length][2];

        // 进行初始化
        dpArr[0][0] = 0;
        dpArr[0][1] = nums[0];

        int res = 0;

        for(int i = 1;i < length;i++){
            dpArr[i][0] = Math.max(dpArr[i - 1][0],dpArr[i - 1][1]);
            dpArr[i][1] = dpArr[i - 1][0] + nums[i];

            res = Math.max(res,Math.max(dpArr[i][0],dpArr[i][1]));
        }

        res = Math.max(res,Math.max(dpArr[0][0],dpArr[0][1]));

        return res;
    }
}
