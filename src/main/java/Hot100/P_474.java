package Hot100;

public class P_474 {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;

//        String[] strs = {"10","0","1"};
//        int m = 1;
//        int n = 1;

        int result = findMaxForm1(strs, m, n);
        System.out.println(result);
    }

    public static int findMaxForm1(String[] strs, int m, int n) {
        int strsNum = strs.length;
        int[][][] dp = new int[strsNum + 1][m + 1][n + 1];


        for (int i = 1; i <= strsNum; i++) {
            int[] cnt = getDigit(strs[i - 1]);

            for (int j = 0; j <= m; j++) {
                for(int k = 0; k <= n; k++) {

                    if (cnt[1] > j || cnt[0] > k) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - cnt[1]][k - cnt[0]] + 1);
                    }
                }
            }
        }

        return dp[strsNum][m][n];
    }

    // 题目要求是最多有m个0，n个1
    public static int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        if(length == 0){
            return 0;
        }

        // 为什么m+1,n+1，因为需要记录 = 0的情况
        int[][][] dpArr = new int[length + 1][m + 1][n + 1];

        for(int i = 1;i <= length;i++){
            int[] digit = getDigit(strs[i - 1]);
            for(int j = 0;j <= m;j++){
                for(int k = 0;k <= n;k++){
                    // 选i和不选i
                    int mCount = digit[0];
                    int nCount = digit[1];
                    if(j < mCount || k < nCount){
                        dpArr[i][j][k] = dpArr[i - 1][j][k];
                    }else{
                        dpArr[i][j][k] = Math.max(dpArr[i - 1][j][k],dpArr[i - 1][j - mCount][k - nCount] + 1);
                    }
                }
            }
        }

        return dpArr[length][m][n];
    }

    public static int[] count(String str) {
        int[] cnt = new int[2];
        for (char c : str.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }




    public static int[] getDigit(String str){
        int length = str.length();
        int[] digits = new int[2];
        if(length == 0){
            digits[0] = 0;
            digits[1] = 0;
            return digits;
        }

        int mCount = 0;
        int nCount = 0;

        for(int i = 0;i < length;i++){
            if(str.charAt(i) == '1'){
                mCount++;
            }else{
                nCount++;
            }
        }

        digits[0] = mCount;
        digits[1] = nCount;
        System.out.println(digits[0] + " -> " + digits[1]);
        return digits;
    }
}
