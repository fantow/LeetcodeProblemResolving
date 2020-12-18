package Hot100;

public class P_64 {
    public static void main(String[] args) {
//        int[][] grid = {
//                {1,3,1},
//                {1,5,1},
//                {4,2,1}
//        };

        int[][] grid = {
                {1,2,3},
                {4,5,6}
        };

        int result = minPathSum(grid);
        System.out.println(result);
    }

    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        if(rows == 0){
            return 0;
        }

        int cols = grid[0].length;

        // 使用dp[][]
        // 题目给定了，每次只能向下或向上走，所以dp[i][j]表示到达(i,j)的最小路径
        // dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j],dp[i][j - 1]);


        // 先对dp初始化
        int[][] dpArr = new int[rows][cols];

        dpArr[0][0] = grid[0][0];
        for(int i = 1;i < rows;i++){
            dpArr[i][0] = grid[i][0] + dpArr[i - 1][0];
        }

        for(int j = 1;j < cols;j++){
            dpArr[0][j] = grid[0][j] + dpArr[0][j - 1];
        }

        for(int row = 1;row < rows;row++){
            for(int col = 1;col < cols;col++){
                dpArr[row][col] = grid[row][col] + Math.min(dpArr[row - 1][col],dpArr[row][col - 1]);
            }
        }

        return dpArr[rows - 1][cols - 1];
    }
}
