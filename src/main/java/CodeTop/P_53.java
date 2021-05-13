package CodeTop;

public class P_53 {
    public static void main(String[] args) {

//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {-2,1,-3,-4};
        int[] nums = {5,4,-1,7,8};
//        int[] nums = {-2,-1};
        int res = maxSubArray(nums);
        System.out.println(res);
    }

    // 在遍历过程中维护一个最小和的下标
    public static int maxSubArray(int[] nums) {
        int length = nums.length;

        if(length == 1){
            return nums[0];
        }

        // 前缀和数组
        int[] arr = new int[length];

        arr[0] = nums[0];
        for(int i = 1; i < length;i++){
            arr[i] = arr[i - 1] + nums[i];
        }

        int max = arr[0];

        int min = 0;

        for(int i = 0;i < length;i++){
            if(max < arr[i] - min){
                max = arr[i] - min;
            }

            if(min > arr[i]){
                min = arr[i];
            }
        }

        return max;
    }
}
