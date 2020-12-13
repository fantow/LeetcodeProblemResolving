package Hot100;

public class P_169 {
    public static void main(String[] args) {
//        int[] nums = {3,2,3};
        int[] nums = {2,2,1,1,1,2,2};
        int result = majorityElement(nums);

        System.out.println(result);
    }

    public static int majorityElement(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return -1;
        }else if(length == 1){
            return nums[0];
        }

        int tempNum = -1;
        int count = 0;

        for(int i = 0;i < length;i++){
            if(count == 0){
                tempNum = nums[i];
                count++;
                continue;
            }
            if(tempNum == nums[i]){
                count++;
            }else{
                count--;
            }
        }

        return tempNum;
    }
}
