package JZOffer;


/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_39 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2,2,5,4,2};
//        int[] nums = {3,2,3};
//        int[] nums = {3,3,4};
        int result = majorityElement(nums);
        System.out.println(result);
    }

    public static int majorityElement(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return -1;
        }
        if(length == 1){
            return nums[0];
        }

        int result = 0;
        int count = 0;

        for(int i = 0;i < length;i++){
            int num = nums[i];
            if(count == 0){
                result = num;
            }
            count += (result == num) ? 1 : -1;
        }

        return result;
    }
}
