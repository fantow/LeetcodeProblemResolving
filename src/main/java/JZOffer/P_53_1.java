package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_53_1 {
    public static void main(String[] args) {
//        ---- test1 ----
        int[] nums = {5,7,7,8,8,9,10};
        int target = 8;

//        ---- test2 ----
//        int[] nums = {1};
//        int target = 1;

//        ---- test3 ----
//        int[] nums = {2,2};
//        int target = 3;

//        ---- test4 ----
//        int[] nums = {1,2,3};
//        int target = 1;

        int result = search2(nums, target);

        System.out.println(result);
    }

    // 最简单的方法，从头遍历
    public static int search(int[] nums, int target) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        int count = 0;
        boolean findNum = false;
        for(int i = 0;i < length;i++){
            if(nums[i] == target){
                findNum = true;
                count++;
            }else if(!findNum){
                continue;
            }else{
                return count;
            }
        }

        return count;
    }

    // 方法2.使用二分查找
    public static int search1(int[] nums, int target) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        int left = 0;
        int right = length;

        // 先找到第一个大于等于target的下标 (需要保证数组中存在target，否则直接返回0)
        // 再找到第一个大于target的下标
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }


        if(left >= length){
            return 0;
        }

        // 证明数组中不包含target
        if(nums[left] != target){
            return 0;
        }
        int firstIdx = left;

        left = 0;
        right = length - 1;
        // 再去找第一个大于target的下标
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[left] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(firstIdx);
        System.out.println(left);

        return left - firstIdx;

    }

    public static int search2(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;
        // 若数组中无 target ，则提前返回
//        if(j >= 0 && nums[j] != target) return 0;
        if(i - 1 >= 0 && nums[i - 1] != target){
            return 0;
        }

        // 搜索左边界 right
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }


}
