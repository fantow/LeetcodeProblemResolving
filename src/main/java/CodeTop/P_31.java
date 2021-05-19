package CodeTop;

public class P_31 {
    public static void main(String[] args) {

//        int[] nums = {1,2,3};
//        int[] nums = {3,2,1};
//        int[] nums = {1,1,5};
//        int[] nums = {1};
        int[] nums = {1,1,2};
//        int[] nums = {1,1,1,1};
//        int[] nums = {2,3,1};
        nextPermutation(nums);

        for(int num : nums){
            System.out.print(num + " ");
        }
    }

    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return ;
        }

        // 上一个元素的值
        int num = nums[length - 1];
        int left = -1;

        // 寻找第一个非单增序列(从后向前看)
        for(int i = length - 2;i >= 0;i--){
            if(nums[i] < num){
                left = i;
                break;
            }
            num = nums[i];
        }

        func(nums,left);
        return ;
    }

    // 将left~right部分构造成下一个序列
    // 传入的参数确保：nums[left] < nums[left + 1]
    public static void func(int[] nums,int left){
        int length = nums.length;

        // left == -1说明当前nums就是最大的了
        if(left == -1){
            // 只需要前后依次交换元素即可
            for(int i = 0;i < length / 2;i++){
                int temp = nums[i];
                nums[i] = nums[length - 1 - i];
                nums[length - 1 - i] = temp;
            }
            return;
        }

        // 需要在left ~ length - 1这部分找到比当前nums[left]大的元素作为新的nums[left]，然后后面按递增序列排序
        for(int i = length - 1;i >= left + 1;i--){
            if(nums[i] > nums[left]){
                // i 与left的元素交换位置
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;

                // 对left+1 ~ length - 1这部分进行交换
                for(int j = 0;j < (length - 1 - left) / 2;j++){
                    int tmp = nums[left + 1 + j];
                    nums[left + 1 + j] = nums[length - 1 - j];
                    nums[length - 1 - j] = tmp;
                }

                break;
            }
        }
    }
}
