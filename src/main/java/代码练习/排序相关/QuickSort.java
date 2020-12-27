package 代码练习.排序相关;

import Hot100.P_4;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};

        QuickSort quickSort = new QuickSort();

        quickSort.quickSort(nums,0,nums.length - 1);

        for(int num : nums){
            System.out.print(num + " ");
        }
    }

    public int partition(int[] nums,int left,int right) {
        if (left < right) {
            int temp = nums[left];
            while (left < right) {

                while (left < right && nums[right] >= temp) {
                    right--;
                }
                nums[left] = nums[right];

                while (left < right && nums[left] <= temp) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = temp;
        }

        return left;
    }

    public void quickSort(int[] nums,int left,int right){
        if(left < right){
            int partition = partition(nums,left,right);
            quickSort(nums,left,partition - 1);
            quickSort(nums,partition + 1,right);
        }
    }

}
