package CodeTop;

public class P_5 {
    public static void main(String[] args) {

//        String s = "babad";
//        String s = "cbbd";
        String s = "ac";
        String res = longestPalindrome(s);

        System.out.println(res);
    }

    // 难点在于回文子串可能是单数长度的，也可能是偶数长度的
    // 看了答案采用DP
    public static String longestPalindrome(String s) {
        int length = s.length();
        if(length <= 1){
            return s;
        }

        // dp[i][j]表示:s中下标i~j的子串是否为回文子串
        boolean[][] dpArr = new boolean[length][length];

        // 对dpArr进行初始化
        for(int i = 0;i < length;i++){
            dpArr[i][i] = true;
        }

        int maxLength = 1;
        int start = 0;

        // 状态转移方程 dp[i][j] = dp[i+1][j - 1] && s.charAt(i) == s.charAt(j)
        for(int j = 1;j < length;j++){
            for(int i = 0;i < j;i++){
                if(s.charAt(i) != s.charAt(j)){
                    dpArr[i][j] = false;
                }else{
                    if(j - i < 3){
                        dpArr[i][j] = true;
                    }else{
                        dpArr[i][j] = dpArr[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                    }
                }

                if(dpArr[i][j] == true && maxLength < (j - i + 1)){
                    maxLength = j - i + 1;
                    start = i;
                }
            }
        }

//        if(start == -1){
//            return "";
//        }

        return s.substring(start,start + maxLength);
    }
}
