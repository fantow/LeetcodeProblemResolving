package LCEveryDay;

public class P_62 {
    public static void main(String[] args) {
//        int m = 3;
//        int n = 2;

//        int m = 7;
//        int n = 3;

        int m = 23;
        int n = 12;

        int resultPathCount = uniquePaths(m, n);

        System.out.println(resultPathCount);
    }

    // dfs会超时，改用dp试试
    public static int uniquePaths(int m, int n) {
        int[][] dpArr = new int[m][n];

        // 对dp数组进行初始化
        for(int i = 0;i < n;i++){
            dpArr[0][i] = 1;
        }

        for(int j = 0;j < m;j++){
            dpArr[j][0] = 1;
        }

        // 注意遍历顺序，dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        // 所以需要其位置上和左的值
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                dpArr[i][j] = dpArr[i - 1][j] + dpArr[i][j - 1];
            }
        }


        return dpArr[m - 1][n - 1];
    }



    static int result = 0;

    // 应该是使用回溯(不是回溯，是DFS)
    // 看来dfs会超时
    public static int uniquePaths1(int m, int n) {
        if(m == 0 && n == 0){
            return 0;
        }else if(m == 1 && n == 1){
            return 1;
        }

        dfsFun(m,n,0,0);

        return result;
    }

    // i,j 表示当前的位置
    // 应该不会发送重复路径
    public static void dfsFun(int m,int n,int i,int j){
        System.out.println("i:" + i + " j:" + j + " count:" + result);
        if(i == m - 1 && j == n - 1){
            result++;
            return;
        }

        if(i < 0 || i > m || j < 0 || j > n){
            return;
        }

        // 向下
        dfsFun(m,n,i + 1,j);

        // 向右
        dfsFun(m,n,i,j + 1);

        return;
    }
}
