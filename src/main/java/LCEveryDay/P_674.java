package LCEveryDay;

public class P_674 {
    public static void main(String[] args) {
//        int[] nums = {1,3,5,4,7};
        int[] nums = {2,2,2,2,2};
        int result = findLengthOfLCIS(nums);

        System.out.println(result);
    }

    public static int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        int preNum = nums[0];
        int maxLen = 1;
        int temp = 1;

        for(int i = 1;i < length;i++){
            if(preNum < nums[i]) {
                temp++;
            }else {
                temp = 1;
            }
            preNum = nums[i];
            maxLen = Math.max(maxLen,temp);
        }

        return maxLen;
    }
}
