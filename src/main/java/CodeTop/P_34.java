package CodeTop;

public class P_34 {
    public static void main(String[] args) {
//        int[] nums = {5,7,7,8,8,10};
//        int target = 8;
//        int target = 6;

        int[] nums = {};
        int target = 0;

        int[] arr = searchRange(nums, target);

        for(int num : arr){
            System.out.print(num + " ");
        }
    }

    // 找出给定目标值在数组中的开始位置和结束位置
    // 应该就是去计算target在nums的最左侧和最右侧的下标
    public static int[] searchRange(int[] nums, int target) {
        int length = nums.length;

        int[] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;

        // 找最左侧
        int left = 0;
        int right = length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        if(left >= 0 && left < length && nums[left] == target){
            arr[0] = left;
        }

        // 找最右侧
        left = 0;
        right = length - 1;

        while(left < right){
            int mid = left + (right - left + 1) / 2;

            if(nums[mid] <= target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }

        if(left >= 0 && left < length && nums[left] == target){
            arr[1] = left;
        }

        return arr;
    }
}