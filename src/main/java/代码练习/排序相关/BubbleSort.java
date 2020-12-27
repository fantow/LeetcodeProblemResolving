package 代码练习.排序相关;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(nums);

        for(int num : nums){
            System.out.print(num + " ");
        }
    }


    // 重点是左右交换
    public void bubbleSort(int[] nums){
        int length = nums.length;

        for(int i = 0;i < length - 1;i++){
            boolean flag = true;
            for(int j = 0;j < length - i - 1;j++){
                if(nums[j] > nums[j + 1]){
                    swap(nums,j,j + 1);
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }

    public void swap(int[] nums,int from,int to){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
