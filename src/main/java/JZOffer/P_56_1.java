package JZOffer;

import java.util.Arrays;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_56_1 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] nums = {4,1,4,6};

//        ---- test2 ----
        int[] nums = {1,2,10,4,1,4,3,3};

        int[] array = singleNumbers(nums);
        for (int a : array){
            System.out.print(a + " ");
        }
        System.out.println();
    }

    // 采用位运算
    public static int[] singleNumbers(int[] nums) {
        int length = nums.length;
        if(length <= 1){
            return new int[]{};
        }

        int k = 0;
        for(int num : nums){
            k ^= num;
        }

        int a = 0;
        int b = 0;

        int idx = 1;
        // 找到首位不同的
        while((k & idx) == 0){
            idx <<= 1;
        }

        for(int num : nums){
            if((num & idx) == 0){
                a ^= num;
            }else{
                b ^= num;
            }
        }

        return new int[]{a,b};
    }
}
