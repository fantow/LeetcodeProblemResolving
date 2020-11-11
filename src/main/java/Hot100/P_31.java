package Hot100;

import java.util.Arrays;

public class P_31 {
    public static void main(String[] args) {

        int[] nums = {1,3,2};
//        int[] nums = {1,2,3,8,5,7,6,4};
        nextPermutation(nums);

        for(int i : nums){
            System.out.println(i);
        }
    }

    // 本质上是找下一个比他大的数
    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        if(length <= 1){
            return;
        }

        // 从后向前找第一个i < j的地方(这里的本质是从后向前找到第一个非升序数)
        // 再从j~end从后向前找第一个i < k的地方
        for(int i = length - 1;i > 0;i--){
            if(nums[i] > nums[i - 1]){
                for(int j = length - 1;j >= i;j--){
                    if(nums[j] > nums[i - 1]) {
                        int temp = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = temp;
                        Arrays.sort(nums,i,length);
                        return;
                    }
                }
            }
        }

        Arrays.sort(nums);
    }
}
