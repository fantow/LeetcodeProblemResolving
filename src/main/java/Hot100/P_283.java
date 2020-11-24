package Hot100;

public class P_283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);

        for(int num : nums){
            System.out.print(num + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int length = nums.length;

        int slowPtr = 0;
        int fastPtr = 0;

        while(fastPtr < length){
            if(nums[fastPtr] != 0){
                nums[slowPtr] = nums[fastPtr];
                slowPtr++;
            }
            fastPtr++;
        }

        while (slowPtr < length){
            nums[slowPtr++] = 0;
        }

        return;
    }
}
