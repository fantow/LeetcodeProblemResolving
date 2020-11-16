package Hot100;

public class P_5 {
    public static void main(String[] args) {
//        String s = "babad";

//        String s = "cbbd";
        String s = "ac";
        String str = longestPalindrome(s);

        System.out.println(str);
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        if(length <= 1){
            return s;
        }

        boolean[][] dpArr = new boolean[length][length];

        // 对数组进行初始化
        for(int i = 0;i < length;i++){
            dpArr[i][i] = true;
        }

        int maxLength = 1;
        int start = 0;

        // 状态转移方程为dp[i][j] = dp[i + 1][j - 1] && (s[i] == s[j])
        for(int j = 1;j < length;j++){
            for(int i = 0;i < j;i++){
                if(s.charAt(i) != s.charAt(j)){
                    dpArr[i][j] = false;
                }else{
                    // i，j构成的区间由1个字符或两个字符，或是三个字符组成，且前后i,j都相等，那么是回文字符
                    if(j - i < 3){
                        dpArr[i][j] = true;
                    }else{
                        dpArr[i][j] = dpArr[i + 1][j - 1];
                    }
                }

                if(dpArr[i][j] == true && maxLength < (j - i + 1)){
                    maxLength = j - i + 1;
                    start = i;
                }
            }
        }


        if(start == -1 || maxLength == Integer.MIN_VALUE){
            return "";
        }else{
            return s.substring(start,start + maxLength);
        }

    }
}
