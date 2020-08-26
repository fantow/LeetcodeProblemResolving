package Classify400.Array.基础;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_189 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] nums = {1,2,3,4,5,6,7};
//        int k = 3;

//        ---- test2 ----
        int[] nums = {1,2};
        int k = 3;

        rotate(nums,k);

        for(int num : nums){
            System.out.print(num + " ");
        }
    }

    // 旋转数组，如果使用辅助数组很好做，原地旋转需要转动三次：左逆置，右逆置，整体逆置即可
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        if(length == 0 || length == 1){
            return;
        }

        if(k > length - 1){
            k %= length;
        }
        int rotateIdx = length - 1 - k;


        // 左部分旋转
        reverse(nums,0,rotateIdx);
        // 右部分旋转
        reverse(nums,rotateIdx + 1,length - 1);
        // 整体旋转
        reverse(nums,0,length - 1);
    }

    public static void reverse(int[] nums,int left,int right) {
        if (left < right) {
            while(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }
    }

}
