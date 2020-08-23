package JZOffer;

import java.util.Arrays;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_61 {
    public static void main(String[] args) {
//        ---- test1 ----
        int[] nums = {1,2,3,4,5};

//        ---- test2 ----
//        int[] nums = {0,0,1,2,5};

//        ---- test3 ----
//        int[] nums = {0,0,2,2,5};

        boolean flag = isStraight(nums);

        System.out.println(flag);
    }

    // 先排序，在判断时先除去0，在遍历过程中记录有多少不满足连续，最后判断不连续个数 == 0的个数
    public static boolean isStraight(int[] nums) {
        int length = nums.length;
        if(length < 5){
            return false;
        }

        Arrays.sort(nums);
        int zero = 0;
        for(int i = 0;i < length - 1;i++){
            if(nums[i] == 0){
                zero++;
            }else{
                if(nums[i] == nums[i + 1]){
                    return false;
                }
            }
        }

        return nums[length - 1] - nums[zero] < 5;
    }
}
