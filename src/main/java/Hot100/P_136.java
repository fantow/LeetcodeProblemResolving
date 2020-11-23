package Hot100;

public class P_136 {
    public static void main(String[] args) {
//        int[] nums = {2,2,1};
        int[] nums = {4,1,2,1,2};

        int result = singleNumber(nums);
        System.out.println(result);

    }

    public static int singleNumber(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        if(length == 1){
            return nums[0];
        }

        int result = 0;

        for(int i = 0;i < length;i++){
            result ^= nums[i];
        }

        return result;
    }
}
