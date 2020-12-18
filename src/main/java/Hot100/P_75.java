package Hot100;

public class P_75 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
//        int[] nums = {2,0,1};
//        int[] nums = {0};
//        int[] nums = {2,0};
//        int[] nums = {1};
        sortColors(nums);

        for(int num : nums){
            System.out.print(num + " ");
        }
    }


    // 使用两个指针分别指向0和2应该存放的位置
    public static void sortColors(int[] nums) {
        int length = nums.length;

        if(length <= 1){
            return;
        }

        int zeroPtr = 0;
        int twoPtr = length - 1;
        int i = 0;

        while(i <= twoPtr){
            if(nums[i] == 0){
                swap(nums,i,zeroPtr);
                zeroPtr++;
                i++;
            }else if(nums[i] == 1){
                i++;
            }else{
                swap(nums,i,twoPtr);
                twoPtr--;
            }
        }
    }

    public static void swap(int[] nums,int from,int to){
        if(from < to){
            int num = nums[from];
            nums[from] = nums[to];
            nums[to] = num;
        }
        return;
    }


    // 使用快排(无法通过用例中不存在1的)
    public static void sortColors2(int[] nums) {
        int length = nums.length;
        if(length <= 1){
            return;
        }

        int idx = 0;
        int i = 0;
        for(i = 0;i < length;i++){
            if(nums[i] == 1){
                idx = i;
                break;
            }
        }

        // 没有1
        if(i == length){

        }

        // 找到1的位置，让其作为快排的pivot
        // 为了方便套模板，将1的位置和数组下标0的元素交换
        int temp = nums[0];
        nums[0] = nums[idx];
        nums[idx] = temp;

        quickSort(nums);

    }

    public static void quickSort(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        int num = nums[left];
        while(left < right){
            while(left < right && num < nums[right]){
                right--;
            }
            nums[left] = nums[right];

            while(left < right && num >= nums[left]){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = num;

        return;
    }



    // 通过计数方式，时间复杂度超100%
    public static void sortColors1(int[] nums) {
        int length = nums.length;
        if(length <= 1){
            return;
        }

        int[] sumArr = new int[3];

        for(int num : nums){
            sumArr[num]++;
        }

        int num = 0;
        int idx = 0;
        for(int i = 0;i < 3;i++){
            int count = sumArr[i];
            for(int j = 0;j < count;j++){
                nums[idx] = num;
                idx++;
            }
            num++;
        }

        return ;
    }
}
