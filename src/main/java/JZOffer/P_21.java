package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_21 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] resultArray = exchange2(nums);

        for(int arr : resultArray){
            System.out.println(arr);
        }
    }

    // 1.方法1,使用swap
    public static int[] exchange1(int[] nums) {

        int length = nums.length;
        if(length == 0){
            return null;
        }
        if(length == 1){
            return nums;
        }

        int idx = 0;
        int odd = 0;

        while(idx < length){
            if(nums[idx] % 2 == 1){
                swap(nums,idx,odd);
                odd++;
            }
            idx++;
        }

        return nums;
    }

    // 2.方法2，使用快排改
    public static int[] exchange2(int[] nums){
        int length = nums.length;
        if(length == 0){
            return null;
        }
        if(length == 1){
            return nums;
        }

        int left = 0;
        int right = length - 1;

        while(left < right){

            while(left < right && nums[left] % 2 == 1){
                left++;
            }

            while(left < right && nums[right] % 2 == 0){
                right--;
            }

            if(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }

        return nums;
    }

    public static void swap(int[] nums,int i,int j){
        if(i == j){
            return ;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    // 3.方法3，使用辅助数组
    public static int[] exchange3(int[] nums){
        int length = nums.length;
        if(length == 0){
            return new int[]{};
        }
        if(length == 1){
            return nums;
        }

        int[] resultArr = new int[length];

        int left = 0;
        int right = length - 1;

        int ptr = 0;
        while(left <= right && ptr < length){
            if(nums[ptr] % 2 == 0){
                resultArr[right--] = nums[ptr];
            }else{
                resultArr[left++] = nums[ptr];
            }
            ptr++;
        }

        return resultArr;
    }
}
