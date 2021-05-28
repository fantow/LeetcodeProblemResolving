package CodeTop;

public class P_704 {
    public static void main(String[] args) {
//        int[] nums = {-1,0,3,5,9,12};
//        int target = 9;

        int[] nums = {5};
        int target = 5;

        int res = search(nums, target);
        System.out.println(res);
    }


    // 需要采用二分法实现查找
    public static int search(int[] nums, int target) {
        int length = nums.length;
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

        if(left >= 0){
            return nums[left] == target ? left : -1;
        }

        return -1;
    }
}
