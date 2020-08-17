package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_42 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

//        ---- test2 ----
        int[] nums = {-1,-2};
        int result = maxSubArray(nums);

        System.out.println(result);
    }

    // 使用动态规划
    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return -1;
        }
        if(length == 1){
            return nums[0];
        }

        int[] arr = new int[length];
        arr[0] = nums[0];
        int max = Integer.MIN_VALUE;

        for(int i = 1;i < length;i++){
            if(arr[i - 1] > 0){
                arr[i] = arr[i - 1] + nums[i];
            }else{
                arr[i] = nums[i];
            }
            if(max < arr[i]){
                max = arr[i];
            }
        }

        return arr[0] > max ? arr[0] : max;
    }

    public static int maxSubArray2(int[] nums){
        int length = nums.length;
        if(length == 0){
            return -1;
        }
        if(length == 1){
            return nums[0];
        }
        // 遍历过程中，临时存储结果的变量
        int temp = 0;

        // 当前的最大值
        int max = Integer.MIN_VALUE;

        for(int i = 0;i < length;i++){
            if(temp <= 0){
                temp = nums[i];
            }else{
                temp = nums[i] + temp;
            }
            max = Math.max(temp,max);
        }
        return max;
    }

}
