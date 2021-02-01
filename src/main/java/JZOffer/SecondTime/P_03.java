package JZOffer.SecondTime;

import java.util.Arrays;

public class P_03 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
        int result = findRepeatNumber2(nums);

        System.out.println(result);
    }

    // 方法1.先排序，再判断 preNum == nums[i]
    public static int findRepeatNumber(int[] nums) {
        int length = nums.length;

        Arrays.sort(nums);

        int preNum = nums[0];

        for(int i = 1;i < length;i++){
            if(preNum == nums[i]){
                return preNum;
            }
            preNum = nums[i];
        }

        return -1;
    }

    // 方法2.将位置不正确的元素摆放至正确的位置
    public static int findRepeatNumber2(int[] nums) {
        int length = nums.length;

        for(int i = 0;i < length;i++){
            while(nums[i] != i){
                // nums[i]一定在后面，如果到了nums[i]这一步，说明前面已经完成了交换
                // nums[nums[i]] 一定在前面
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }

                swap(nums,nums[i],i);
            }
        }

        return -1;
    }

    public static void swap(int[] nums,int from,int to){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

}
