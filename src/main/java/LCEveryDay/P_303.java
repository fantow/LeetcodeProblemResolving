package LCEveryDay;

public class P_303 {

    public int[] arr = null;

    public P_303(int[] nums){
        int length = nums.length;
        arr = new int[length];

        int temp = 0;

        // 构建前缀和数组
        for(int i = 0;i < length;i++){
            arr[i] = temp + nums[i];
            temp = arr[i];
        }
    }

    // 就是一个前缀和问题
    public int sumRange(int i, int j) {
        if(i == 0){
            return arr[j];
        }

        return arr[j] - arr[i - 1];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};

        P_303 numArray = new P_303(nums);

        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2,5));
        System.out.println(numArray.sumRange(0,5));
    }
}
