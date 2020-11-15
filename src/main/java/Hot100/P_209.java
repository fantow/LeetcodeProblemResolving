package Hot100;

public class P_209 {
    public static void main(String[] args) {
//        int s = 7;
//        int[] nums = {2,3,1,2,4,3};
//
////        int s = 3;
////        int[] nums = {1,1};
//
//        int len = minSubArrayLen1(s, nums);
//        System.out.println(len);

        int[] nums = {1,2,3,3,3,4,5};
//        int i = findLeft(3, nums);
        int i = findRight(3,nums);
        System.out.println(i);
    }

    public static int findLeft(int target,int[] nums){
        int length = nums.length;

        int left = 0;
        int right = length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] >= target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }


    public static int findRight(int target,int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] <= target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }

        return left;
    }


    public static int minSubArrayLen1(int s, int[] nums) {
        int length = nums.length;
        if(length < 1){
            return 0;
        }

        // 求前缀和
        int[] sums = new int[length + 1];
        sums[0] = 0;
        for(int i = 0;i < length;i++){
            sums[i + 1] = sums[i] + nums[i];
        }

        int result = Integer.MAX_VALUE;

        for(int i = 1;i <= length;i++) {
            int target = sums[i - 1] + s;
            int bound = binarySearch(target, sums);

            if(sums[bound] >= target){
                result = Math.min(result,bound - (i - 1));
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    // 这样写需要注意：一定保证可以找到，否则还需要对结果进行判断
    public static int binarySearch(int target,int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }




    public static int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        if(length < 1){
            return 0;
        }

        int left = 0;
        int right = -1;
        // 用来记录窗口中包含元素的总和
        int sum = 0;

        int minLength = Integer.MAX_VALUE;
        while(left < length){
            if(sum < s){
                right++;
                if(right >= length){
                    break;
                }
                sum += nums[right];
            }else{
                if(minLength > right - left + 1){
                    minLength = right - left + 1;
                }
                // 如果修改了right = left 这就是暴力解法
                // 如果不改变right，就是滑动窗口解法
//                right = left;
                sum -= nums[left];
                left++;
            }
        }

        if(minLength == Integer.MAX_VALUE){
            minLength = 0;
        }

        return minLength;
    }
}
