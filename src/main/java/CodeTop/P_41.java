package CodeTop;

public class P_41 {
    public static void main(String[] args) {

        int[] nums = {1,2,0};
        int res = firstMissingPositive(nums);

        System.out.println(res);
    }

    // 要求以O(n)时间复杂度，并且使用常数级别的空间复杂度
    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;

        for(int i = 0;i < length;i++){
            while(nums[i] > 0 && nums[i] <= length && nums[nums[i] - 1] != nums[i]){
                swap(nums,i,nums[i] - 1);
            }
        }

        for(int i = 0;i < length;i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }

        return length + 1;
    }

    public static void swap(int[] nums,int from,int to){
        int length = nums.length;

        if(from < 0 || from >= length || to < 0 || to >= length){
            return;
        }

        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;

        return;
    }

}
