package LCEveryDay;

public class P_643 {
    public static void main(String[] args) {
//        int[] nums = {1,12,-5,-6,50,3};
//        int k = 4;

        int[] nums = {-1};
        int k = 1;

        double result = findMaxAverage(nums, k);
        System.out.println(result);
    }

    public static double findMaxAverage(int[] nums, int k) {
        int length = nums.length;
        double sum = 0.0;

        double result = Double.MIN_VALUE;

        int left = 0;
        int right = 0;

        for(;right < length;right++){
            sum += nums[right];
            if(right - left + 1 < k){
                continue;
            }

            result = result == Double.MIN_VALUE ? sum / k : result > (sum / k) ? result : (sum / k);

            sum -= nums[left];
            left++;
        }

        return result;
    }
}
