package CodeTop;

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

        int res = minPathSum(grid);

        System.out.println(res);
    }

    // 找从左上角到右下角的一条数字和最小路径
    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = 0;
        if(rows != 0){
            cols = grid[0].length;
        }

        // 如果是找到一条路径，应该用dfs，但是找到最小路径，应该要用dp
        int[][] dpArr = new int[rows][cols];

        // 因为只能向下或向右移动，所以第0层和第0列需要被提前初始化
        dpArr[0][0] = grid[0][0];

        for(int i = 1;i < rows;i++){
            dpArr[i][0] = dpArr[i - 1][0] + grid[i][0];
        }

        for(int j = 1;j < cols;j++){
            dpArr[0][j] = dpArr[0][j - 1] + grid[0][j];
        }

        // 应该是逐行去更新
        for(int row = 1;row < rows;row++){
            for(int col = 1;col < cols;col++){
                dpArr[row][col] = Math.min(dpArr[row - 1][col],dpArr[row][col - 1]) + grid[row][col];
            }
        }

        return dpArr[rows - 1][cols - 1];
    }
}
