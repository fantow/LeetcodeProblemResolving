package CodeTop;

public class P_62 {
    public static void main(String[] args) {
//        int m = 3;
//        int n = 7;

        int m = 3;
        int n = 2;

        int res = uniquePaths(m, n);
        System.out.println(res);
    }

    // 只能向下或向右移动
    public static int uniquePaths(int m, int n) {

        // 用dp
        int[][] dpArr = new int[m][n];

        // 初始化
        for(int i = 1;i < m;i++){
            dpArr[i][0] = 1;
        }

        for(int j = 1;j < n;j++){
            dpArr[0][j] = 1;
        }

        for(int row = 1;row < m;row++){
            for(int col = 1;col < n;col++){
                dpArr[row][col] = dpArr[row - 1][col] + dpArr[row][col - 1];
            }
        }

        return dpArr[m - 1][n - 1];
    }
}
