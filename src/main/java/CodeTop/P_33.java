package CodeTop;

public class P_33 {
    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};
//        int target = 0;
        int target = 3;

        int res = search(nums, target);
        System.out.println(res);
    }


    // 应该是用二分法去做
    public static int search(int[] nums, int target) {
        int length = nums.length;

        int left = 0;
        int right = length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(target == nums[mid]){
                return mid;
            }

            // 如果左侧有序
            if(nums[left] <= nums[mid]){
                // 且target就在left~mid区间
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else {
                // 右侧有序
                if(nums[mid] < target && target <= nums[right]){
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
