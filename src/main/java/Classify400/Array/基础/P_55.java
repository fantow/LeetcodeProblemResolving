package Classify400.Array.基础;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_55 {
    public static void main(String[] args) {
//        --- test1 ----
//        int[] nums = {2,3,1,1,4};

//        ---- test2 ----
//        int[] nums = {3,2,1,0,4};

//        ---- test3 ----
        int[] nums = {0,2,3};

        boolean flag = canJump1(nums);
        System.out.println(flag);
    }

    public static boolean canJump(int[] nums) {
        int length = nums.length;
        if(length == 0 || length == 1){
            return true;
        }

        boolean[] dpArr = new boolean[length];
        if(nums[0] > 0){
            dpArr[0] = true;
        }else{
            dpArr[0] = false;
        }

        for(int i = 0;i < length - 1;i++){
            int step = nums[i];
            for(int j = 1;j <= step && i + j < length && dpArr[i + j - 1] == true;j++){
                dpArr[i + j] = true;
            }
        }

        for(boolean flag : dpArr){
            System.out.print(flag + " ");
        }
        System.out.println();

        return dpArr[length - 1];
    }

    // 更简单的方法：
    public static boolean canJump1(int[] nums) {
        int length = nums.length;
        if(length == 0 || length == 1){
            return false;
        }

        int pos = length - 1;
        for(int i = length - 2;i >= 0;i--){
            if(nums[i] + i >= pos){
                pos = i;
            }
        }

        return pos == 0;
    }



}
