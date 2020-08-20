package JZOffer;


/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class BinarySearchFor53 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,6,7};
        int target = 5;

        int result = binarySearch_1(nums,target);

        System.out.println(result);
    }

    // 单纯的找target值
    public static int binarySearch_1(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    // 查找第一个大于等于target的值(左边界)
    public static int binarySearch_2(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return left;
    }

    // 查找第一个大于target的值(右边界，开区间)
    public static int binarySearch_3(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return left;
    }

}
