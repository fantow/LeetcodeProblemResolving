package 算法通关40讲;

public class P_169 {
    public static void main(String[] args) {
//        int[] nums = {3,2,3};
//        int[] nums = {2,2,1,1,1,2,2};
//        int[] nums = {2,2,1,1};
        int[] nums = {3,3,4};
        int result = majorityElement(nums);

        System.out.println(result);
    }

    // 摩尔投票
    public static int majorityElement(int[] nums) {
        int length = nums.length;

        int count = 0;
        int temp = 0;

        for(int i = 0;i < length;i++){
            if(i == 0){
                temp = nums[i];
                count++;
                continue;
            }

            if(nums[i] != temp){
                count--;
            }else{
                count++;
            }

            if(count == 0){
                temp = nums[i];
                count = 1;
            }
        }

        return count > 0 ? temp : -1;
    }
}
