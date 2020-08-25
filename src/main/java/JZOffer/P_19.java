package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_19 {
    public static void main(String[] args) {
//        ---- test1 ----
//        String s = "aa";
//        String p = "a";

//        ---- test2 ----
//        String s = "aa";
//        String p = "a*";

//        ---- test3 ----
        String s = "aab";
        String p = "c*a*b";

        boolean flag = isMatch(s, p);

        System.out.println(flag);
    }

    // 采用dp完成
    public static boolean isMatch(String s, String p) {
        int length1 = s.length();
        int length2 = p.length();

        // dpArr[i][j] 表示在s中的前i位和p中的前j位的字符匹配结果
        boolean[][] dpArr = new boolean[length1 + 1][length2 + 1];
        dpArr[0][0] = true;

        // 确定边界
        for(int i = 0;i < length2;i++){
            // 不会为dpArr[0][0] 赋值，因为短路
            // 这里的dpArr[0][i - 1] 相对于dpArr来说，就是向前倒了2步
            if(p.charAt(i) == '*' && dpArr[0][i - 1]){
                dpArr[0][i + 1] = true;
            }
        }

        for(int i = 0;i < length1;i++){
            for(int j = 0;j < length2;j++){
                // 先判断'.'
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                    dpArr[i + 1][j + 1] = dpArr[i][j];
                }else if(p.charAt(j) == '*'){
                    // 再判断含有'*'的情况
                    if(p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.'){
                        // 如果p.charAt(j - 1) != s.charAt(i) --> 尝试将 j-1 和j位的‘*’删除掉再去匹配
                        dpArr[i + 1][j + 1] = dpArr[i + 1][j - 1];
                    }else{
                        // 在 j-1 表示的字符等于i的情况下，
                        // dp[i + 1][j] --> 匹配0个字符
                        // dp[i][j + 1] --> 匹配多个字符时
                        // dp[i + 1][j - 1] --> 删除一个字符
                        dpArr[i + 1][j + 1] = (dpArr[i + 1][j] || dpArr[i][j + 1]
                                                || dpArr[i + 1][j - 1]);

                    }
                }
            }
        }

        for(int i = 0;i <= length1;i++){
            for(int j = 0;j <= length2;j++){
                System.out.print(dpArr[i][j] + " ");
            }
            System.out.println();
        }

        return dpArr[length1][length2];
    }
}
