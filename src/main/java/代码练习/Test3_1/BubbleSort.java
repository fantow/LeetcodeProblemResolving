package 代码练习.Test3_1;

// 冒泡排序
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        BubbleSort solution = new BubbleSort();

        solution.bubbleSort(nums);
        for(int num : nums){
            System.out.print(num + " ");
        }
    }

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
