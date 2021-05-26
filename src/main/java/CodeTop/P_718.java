package CodeTop;

public class P_718 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};

        int res = findLength(nums1, nums2);
        System.out.println(res);
    }

    // 用滑动窗口方法解
    public static int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int res = 0;

        for(int i = 0;i < n;i++){
            int len = Math.min(m,n - i);
            int maxLen = maxLen(nums1,nums2,i,0,len);
            res = Math.max(res,maxLen);
        }

        for(int i = 0;i < m;i++){
            int len = Math.min(n,m - i);
            int maxLen = maxLen(nums1,nums2,0,i,len);
            res = Math.max(res,maxLen);
        }

        return res;
    }

    public static int maxLen(int[] nums1,int[] nums2,int addA,int addB,int len){
        int res = 0;
        int k = 0;

        for(int i = 0;i < len;i++){
            if(nums1[addA + i] == nums2[addB + i]){
                k++;
            }else{
                k = 0;
            }

            res = Math.max(res,k);
        }

        return res;
    }

    // 用dp方法解
//    public static int findLength(int[] nums1, int[] nums2) {
//        int length1 = nums1.length;
//        int length2 = nums2.length;
//
//        int[][] dpArr = new int[length1 + 1][length2 + 1];
//
//        int max = 0;
//
//        for(int i = 1;i <= length1;i++){
//            for(int j = 1;j <= length2;j++){
//                if(nums1[i - 1] == nums2[j - 1]){
//                    dpArr[i][j] = dpArr[i - 1][j - 1] + 1;
//                    max = Math.max(max,dpArr[i][j]);
//                }else {
//                    dpArr[i][j] = 0;
//                }
//            }
//        }
//
//        return max;
//    }
}
