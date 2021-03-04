package 代码练习.Test3_1;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        QuickSort solution = new QuickSort();

        solution.quickSort(nums,0,nums.length - 1);
        for(int num : nums){
            System.out.print(num + " ");
        }
    }

    public void quickSort(int[] nums,int left,int right){
        if(left < right){
            int pivot = partition(nums,left,right);
            quickSort(nums,left,pivot - 1);
            quickSort(nums,pivot + 1,right);
        }
    }

    public int partition(int[] nums,int left,int right){
        int length = nums.length;

        int temp = nums[left];
        while(left < right){
            while(left < right && nums[right] > temp){
                right--;
            }
            nums[left] = nums[right];

            while(left < right && nums[left] < temp){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;

        return left;
    }

}
