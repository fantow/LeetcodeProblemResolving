package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_47 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[][] grid = {
//                {1,3,1},
//                {1,5,1},
//                {4,2,1}
//        };
//        ---- test2 ----
//        int[][] grid = {{0}};

//        ---- test3 ----
        int[][] grid = {{9,1,4,8}};

        int result = maxValue1(grid);
        System.out.println(result);
    }

    // 方法1.这道题和机器人回溯的那道类似
    // 这种方法在用例中被判超时，那这题应该是想让你用DP解决
    public static int maxValue(int[][] grid) {
        int rows = grid.length;
        if(rows == 0){
            return -1;
        }

        int cols = grid[0].length;
        // 因为只能向右或向下移动，所以一定不会发生重复访问的问题

        int maxResult = Integer.MIN_VALUE;
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                int result = dfs(grid,row,col,0);
                if(result > maxResult){
                    maxResult = result;
                }
            }
        }

        return maxResult;
    }

    // currentVal的上一轮的值，还没有加上本轮的grid[row][col]
    public static int dfs(int[][] grid,int row,int col,int currentVal){
        int rows = grid.length;
        if(rows == 0){
            return 0;
        }
        int cols = grid[0].length;

        // 递归的结束条件
        if(row >= rows || col >= cols){
            return currentVal;
        }

        currentVal += grid[row][col];

        // 向右移动
        int moveRight = dfs(grid,row,col + 1,currentVal);

        // 向下移动
        int moveDown = dfs(grid,row + 1,col,currentVal);

        return Math.max(moveRight,moveDown);
    }


    // 方法2.应该还可以通过DP方法解决
    public static int maxValue1(int[][] grid) {
        int rows = grid.length;
        if(rows == 0){
            return 0;
        }
        int cols = grid[0].length;

        // 其实可以直接在原矩阵上改，这样空间复杂度降低为O(1)
        int[][] dpArr = new int[rows][cols];

        // dpArr的上，左边界因为只能唯一确定，所以会在初始化填入
        // 非上，左边界的格子的值V(x,y),应该由其上或左格子中的最大值确定

        // 初始化上边界
        dpArr[0][0] = grid[0][0];
        int maxValue = dpArr[0][0];
        for(int i = 1;i < cols;i++){
            dpArr[0][i] = dpArr[0][i - 1] + grid[0][i];
            if(maxValue < dpArr[0][i]){
                maxValue = dpArr[0][i];
            }
        }

        // 初始化左边界
        for(int j = 1;j < rows;j++){
            dpArr[j][0] = dpArr[j - 1][0] + grid[j][0];
            if(maxValue < dpArr[j][0]){
                maxValue = dpArr[j][0];
            }
        }

        for(int row = 1;row < rows;row++){
            for(int col = 1;col < cols;col++){
                dpArr[row][col] = grid[row][col] + Math.max(dpArr[row - 1][col],dpArr[row][col - 1]);
                if(maxValue < dpArr[row][col]){
                    maxValue = dpArr[row][col];
                }
            }
        }

        return maxValue;
    }

}
