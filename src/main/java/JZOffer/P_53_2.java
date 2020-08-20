package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_53_2 {

    public static void main(String[] args) {
//        ---- test1 ----
//        int[] nums = {0,1,3};

//        ---- test2 ----
        int[] nums = {0,1,2,3,4,5,6,7,9};

        int result = missingNumber2(nums);
        System.out.println(result);
    }

    // 方法1.遍历数组
    public static int missingNumber1(int[] nums) {
        int length = nums.length;
        int i = 0;
        for(;i < length;i++){
            if(nums[i] != i){
                return i;
            }
        }

        return i;
    }


    // 方法2.二分法
    // 可以分析为找到数组中第一个大于mid的值的下标，所以使用 <=
    public static int missingNumber2(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= mid){
                left = mid +1;
            }else{
                right = mid - 1;
            }
        }

        return left;
    }
}
