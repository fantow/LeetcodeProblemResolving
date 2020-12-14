package Hot100;

public class P_152 {
    public static void main(String[] args) {
//        int[] nums = {2,3,-2,4};
//        int[] nums = {-2,0,-1};
//        int[] nums = {-2,3,-4};
        int[] nums = {0,2};
//        int[] nums = {-1,-2,-9,-6};
        int result = maxProduct(nums);

        System.out.println(result);
    }

    // 看了题解，的确是用dp做，也使用了二维数组做，不同点在于二维数组的第二维分别存的是最大和最小值
    public static int maxProduct(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }else if(length == 1){
            return nums[0];
        }


        // dp[i]表示由i构成的最大连续子数组的数值是多少
        int[][] dpArr = new int[length][2];

        // 初始化
        dpArr[0][0] = nums[0];
        dpArr[0][1] = nums[0];

        int result = nums[0];

        for(int i = 1;i < length;i++){
            int num1 = dpArr[i - 1][0] * nums[i];
            int num2 = dpArr[i - 1][1] * nums[i];

            if(num1 > nums[i] && num2 > nums[i]){
                dpArr[i][0] = Math.max(num1,num2);
                dpArr[i][1] = nums[i];

//            }else(num1 < nums[i] && num2 < nums[i]){
            }else{
                int temp = Math.max(num1,num2);
                dpArr[i][0] = Math.max(temp,nums[i]);
                dpArr[i][1] = Math.min(num1,num2);
//                System.out.println(num1 + " -- " + num2);
            }

            result = Math.max(result,dpArr[i][0]);
        }

//        for(int i = 0;i < length;i++){
//            System.out.println(dpArr[i][0] + " " + dpArr[i][1]);
//        }


        return result;
    }



    // 用二维dp试试 -- 内存超时
    public static int maxProduct2(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }else if(length == 1){
            return nums[0];
        }

        int[][] dpArr = new int[length][length];

        int result = Integer.MIN_VALUE;

        // 进行初始化
        for(int i = 0;i < length;i++){
            if(nums[i] > result){
                result = nums[i];
            }
            dpArr[i][i] = nums[i];
        }


        for(int i = 0;i < length;i++){
            for(int j = i + 1;j < length;j++){
                dpArr[i][j] = dpArr[i][j - 1] * nums[j];
                if(dpArr[i][j] > result){
                    result = dpArr[i][j];
                }
            }
        }

        for(int[] arr : dpArr){
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }


        return result;
    }



    // 这个是错的，无法通过用例{-2,3,-4}
    public static int maxProduct1(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }else if(length == 1){
            return nums[0];
        }


        // dp[i]表示由i构成的最大连续子数组的数值是多少
        int[] dpArr = new int[length];

        // 初始化
        dpArr[0] = nums[0];

        for(int i = 1;i < length;i++){
            if(nums[i] * dpArr[i - 1] > nums[i]){
                dpArr[i] = nums[i] * dpArr[i - 1];
            }else{
                dpArr[i] = nums[i];
            }
        }

        int result = dpArr[0];

        for(int i = 1;i < length;i++){
            result = Math.max(result,dpArr[i]);
        }

        return result;
    }
}
