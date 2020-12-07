package Hot100;

public class P_287 {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        int result = findDuplicate(nums);

        System.out.println(result);
    }

    // 因为题目要求不能修改原数组，并且要求时间复杂度 < O(n^2)
    public static int findDuplicate(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        int left = 1;
        int right = length;

        while(left < right){
            int mid = (left + right) / 2;

            // 在左边
            if(mid < getCount(nums,mid)){
                right = mid;
            }else {
                // 在右边
                left = mid + 1;
            }
            System.out.println("left:" + left + " right:" + right);
        }

        return left;
    }

    public static int getCount(int[] nums,int target){
        int length = nums.length;
        int count = 0;
        for(int i = 0;i < length;i++){
            if(nums[i] <= target){
                count++;
            }
        }

        return count;
    }

}
