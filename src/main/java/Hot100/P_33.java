package Hot100;

public class P_33 {
    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 0;

//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 3;

//        int[] nums = {1};
//        int target = 0;

//        int[] nums = {1,3};
//        int target = 1;

        int[] nums = {1,3};
        int target = 2;

        int result = search(nums, target);

        System.out.println(result);
    }

    public static int search(int[] nums, int target) {
        int length = nums.length;

        if(length == 0){
            return -1;
        }

        int left = 0;
        int right = length - 1;

        while(left < right){
            int mid = (left + right) / 2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[mid] < target && nums[right] >= target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }

        if(nums[left] != target){
            return -1;
        }

        return left;
    }
}
