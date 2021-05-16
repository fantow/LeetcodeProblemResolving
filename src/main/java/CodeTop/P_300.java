package CodeTop;

public class P_300 {
    public static void main(String[] args) {
//        int[] nums = {10,9,2,5,3,7,101,18};

        int[] nums = {0,1,0,3,2,3};

//        int[] nums = {7,7,7,7,7,7,7};

        int res = lengthOfLIS(nums);

        System.out.println(res);
    }



    // 如果需要O(n*logn)的算法，需要修改dp的定义
    public static int lengthOfLIS(int[] nums) {
        int length = nums.length;

        // tail[i]表示 i+1长度的子序列的最后一个元素
        int[] tails = new int[length];

        int res = 0;

        for(int num : nums){
            int i = 0;
            int j = res;

            while(i < j){
                int m = i + (j - i) / 2;
                if(tails[m] < num){
                    i = m + 1;
                }else{
                    j = m;
                }
            }

            tails[i] = num;
            if(res == j){
                res++;
            }
        }

        return res;
    }

    // 应该是用DP，
    // 一般DP有两种做法
    // 1.dp[i]表示以i下标元素作为结尾的最长长度
    // 2.dp[i]表示从0~i下标元素这部分的最长长度，记录最后的结果
//    public static int lengthOfLIS(int[] nums) {
//        int length = nums.length;
//
//        int[] dpArr = new int[length];
//
//        dpArr[0] = 1;
//
//        for(int i = 1;i < length;i++){
//            int maxLength = 0;
//            // 再去向前找，
//            for(int j = i - 1 ;j >= 0;j--){
//                if(nums[i] > nums[j]){
//                    if(maxLength < dpArr[j]){
//                        maxLength = dpArr[j];
//                    }
//                }
//            }
//            dpArr[i] = maxLength + 1;
//        }
//
//        for(int num : dpArr){
//            System.out.print(num + " ");
//        }
//        System.out.println();
//
//        int res = 0;
//
//        for(int num : dpArr){
//            res = Math.max(res,num);
//        }
//
//        return res;
//    }
}
