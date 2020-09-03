package Classify400.Array.基础;

/**
 * @Description:
 * @Author chenyang270@jd.com
 * @CreateDate
 * @Version: 1.0
 */
public class P_287 {
    public static void main(String[] args) {
//        ---- test1 ----
        int[] nums = {1,3,4,2,2};

//        ---- test2 ----
//        int[] nums = {3,1,3,4,2};

        int result = findDuplicate(nums);
        System.out.println(result);
    }

    public static int findDuplicate(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        // 因为题目说了该数组从1开始到n-1，其中有n个数
        int left = 1;
        int right = length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            int count = 0;

            // 找到数组中小于等于mid的值
            for(int num : nums){
                if(num <= mid){
                    count++;
                }
            }

            if(count <= mid){
                left = mid+1;
            }else{
                right = mid;
            }
        }

        return left;
    }
}
