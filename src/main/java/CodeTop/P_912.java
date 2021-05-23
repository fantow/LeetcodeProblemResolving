package CodeTop;

public class P_912 {
    public static void main(String[] args) {
//        int[] nums = {5,2,3,1};
        int[] nums = {5,1,1,2,0,0};
        int[] res = sortArray(nums);

        for(int num : res){
            System.out.print(num + " ");
        }
    }

    // 要求使用快排
    public static int[] sortArray(int[] nums) {
        int length = nums.length;

        int left = 0;
        int right = length - 1;

        quickSort(nums,left,right);

        return nums;
    }

    public static int partition(int[] nums,int left,int right){
        if(left < right){
            int temp = nums[left];
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
        }
        return left;
    }

    public static void quickSort(int[] nums,int left,int right){
        if(left < right){
            int pivot = partition(nums, left, right);
            quickSort(nums,left,pivot - 1);
            quickSort(nums,pivot + 1,right);
        }
    }

}
