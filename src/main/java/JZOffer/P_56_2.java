package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_56_2 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] nums = {3,4,3,3};

//        ---- test2 ----
        int[] nums = {9,1,7,9,7,9,7};


        int result = singleNumber(nums);
        System.out.println(result);
    }

    public static int singleNumber(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return -1;
        }
        if(length == 1){
            return nums[0];
        }

        int[] arr = new int[32];
        int result = 0;

        for(int num : nums){
            int bitMast = 1;
            for(int i = 31;i >= 0;i--){
                if((num & bitMast) == bitMast){
                    arr[i]++;
                }
                bitMast <<= 1;
            }
        }

        int idx = 1;
        for(int i = 31;i >= 0;i--){
            result += (arr[i] % 3) * idx;
            idx <<= 1;
        }

        return result;
    }
}
