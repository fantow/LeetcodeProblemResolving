package LCEveryDay;

import java.util.Arrays;

public class P_561 {
    public static void main(String[] args) {
//        int[] nums = {1,4,3,2};
        int[] nums = {6,2,6,5,1,2};
        int result = arrayPairSum(nums);

        System.out.println(result);
    }

    public static int arrayPairSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);

        int result = 0;

        for(int i = 0;i < length;i += 2){
            result += nums[i];
        }

        return result;
    }
}
