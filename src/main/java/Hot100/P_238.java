package Hot100;

public class P_238 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] resultArr = productExceptSelf1(nums);

        for(int num : resultArr){
            System.out.print(num + " ");
        }
    }

    public static int[] productExceptSelf1(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return null;
        }

        int[] resultArr = new int[length];

        int p = 1;
        int q = 1;

        for(int i = 0;i < length;i++){
            resultArr[i] = p;
            p *= nums[i];
        }

        for(int j = length - 1;j >= 0;j--){
            resultArr[j] *= q;
            q *= nums[j];
        }

        return resultArr;
    }

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] resultArr = new int[length];

        if(length == 0){
            return null;
        }

        int[] leftArr = new int[length];
        int[] rightArr = new int[length];

        int temp = 1;
        for(int i = 0;i < length;i++){
            if(i == 0){
                leftArr[i] = nums[i];
                temp = nums[i];
                continue;
            }
            leftArr[i] = temp * nums[i];
            temp = leftArr[i];
        }

        temp = 1;
        for(int j = length - 1;j >= 0;j--){
            if(j == length - 1){
                rightArr[j] = nums[j];
            }
            rightArr[j] = temp * nums[j];
            temp = rightArr[j];
        }

        for(int i = 0;i < length;i++){
            int leftVal = 1;
            int rightVal = 1;

            if(i + 1 < length){
                rightVal = rightArr[i + 1];
            }
            if(i - 1 >= 0){
                leftVal = leftArr[i - 1];
            }

            resultArr[i] = leftVal * rightVal;
        }

        return resultArr;
    }
}
