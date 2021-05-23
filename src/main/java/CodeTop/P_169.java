package CodeTop;

public class P_169 {
    public static void main(String[] args) {
//        int[] nums = {3,2,3};
        int[] nums = {2,2,1,1,1,2,2};
//        int[] nums = {2,2};
        int res = majorityElement(nums);

        System.out.println(res);
    }

    // 找出在数组中出现次数大于L/2的元素
    public static int majorityElement(int[] nums) {
        int count = 0;
        int res = Integer.MIN_VALUE;

        for(int num : nums){
            if(res != num && count == 0){
                res = num;
                count++;
            }else if(res != num &&count != 0){
                count--;
            }else{
                count++;
            }
        }

        return count > 0 ? res : -1;
    }
}
