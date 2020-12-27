package 代码练习.排序相关;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(nums);

        for(int num : nums){
            System.out.print(num + " ");
        }
    }

    // 选择排序的重点在于，选择出最大的，排到最后
    public void selectSort(int[] nums){
        int length = nums.length;

        for(int i = 0;i < length - 1;i++){
            int min = i;
            for(int j = i ;j < length;j++){
                if(nums[j] < nums[min]){
                    min = j;
                }
            }
            swap(nums,i,min);
        }
    }

    public void swap(int[] nums,int from,int to){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
