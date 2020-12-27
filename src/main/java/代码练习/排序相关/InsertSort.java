package 代码练习.排序相关;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};

        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(nums);

        for(int num : nums){
            System.out.print(num + " ");
        }
    }

    public void insertSort(int[] nums){
        int length = nums.length;

        for(int i = 1;i < length;i++){
            int temp = nums[i];
            int j;
            for(j = i - 1;j >= 0 && nums[j] > temp;j--){
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }
    }

    public void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
