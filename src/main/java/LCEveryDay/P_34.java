package LCEveryDay;

public class P_34 {
    public static void main(String[] args) {
//        int[] nums = {5,7,7,8,8,10};
//        int target = 8;

//        int[] nums = {5,7,7,8,8,10};
//        int target = 6;

        int[] nums = {};
        int target = 0;

        int[] result = searchRange(nums, target);

        System.out.println(result[0] + " -> " + result[1]);
    }

    // 用二分法先找左边界，再找右边界，每次都需要判断是否等于target
    public static int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int[] resultArr = new int[2];

        if(length == 0){
            resultArr[0] = -1;
            resultArr[1] = -1;
            return resultArr;
        }

        int left = 0;
        int right = length - 1;

        // 先找左边界
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        if(nums[left] != target){
            resultArr[0] = -1;
            resultArr[1] = -1;
            return resultArr;
        }else{
            resultArr[0] = left;
        }

        // 再找右边界
        left = 0;
        right = length - 1;
        while(left < right){
            int mid = (left + right + 1) / 2;
            if(nums[mid] <= target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }

        resultArr[1] = left;

        return resultArr;
    }


}
