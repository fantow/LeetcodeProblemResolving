package LCEveryDay;

public class P_283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};

        moveZeroes(nums);

        for(int i : nums){
            System.out.print(i + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        if(length <= 1){
            return;
        }

        // 双指针
        int slowPtr = 0;
        int fastPtr = 0;

        while(fastPtr < length){
            if(nums[fastPtr] != 0){
                nums[slowPtr++] = nums[fastPtr];
            }
            fastPtr++;
        }

        while(slowPtr < length){
            nums[slowPtr++] = 0;
        }
    }
}
