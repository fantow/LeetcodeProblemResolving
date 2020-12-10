package Hot100;

import java.util.Arrays;
import java.util.Comparator;

public class P_215 {
    public static void main(String[] args) {
//        int[] nums = {3,2,1,5,6,4};
//        int k = 2;

//        int[] nums = {3,2,3,1,2,4,5,5,6};
//        int k = 4;

        int[] nums = {1};
        int k = 1;

        int result = findKthLargest2(nums, k);
        System.out.println(result);
    }


    // 使用快排，定位到partition=len-k的位置的数
    public static int findKthLargest2(int[] nums, int k) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        int result = quickSort(nums, 0, length - 1, k);
        return result;
    }


    public static int quickSort(int[] nums,int left,int right,int k){
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        if(left > right){
            return 0;
        }

        int pivot = partition(nums, left, right);
        if(pivot == length - k){
            return nums[pivot];
        }
        int leftResult = quickSort(nums, left, pivot - 1, k);
        int rightResult = quickSort(nums,pivot + 1,right,k);

        if(leftResult == 0 && rightResult == 0){
            return 0;
        }else if(leftResult == 0){
            return rightResult;
        }else{
            return leftResult;
        }
    }

    public static int partition(int[] nums,int left,int right){
        int temp = nums[left];
        if(left >= right){
            return 0;
        }
        while(left < right){
            while(left < right && nums[right] >= temp){
                right--;
            }
            nums[left] = nums[right];

            while(left < right && nums[left] <= temp){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;

        return left;
    }


    // 最普通的解法
    public static int findKthLargest1(int[] nums, int k) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        // 先对数组排序
        Arrays.sort(nums);

        return nums[length - k];
    }
}
