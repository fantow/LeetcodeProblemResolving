package CodeTop;

public class P_695 {
    public static void main(String[] args) {
//        int[][] grid = {
//                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
//                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
//        };

//        int[][] grid = {
//                {0,0,0,1},
//                {0,0,0,1},
//                {0,0,0,1},
//                {0,0,0,1}
//        };

        int[][] grid = {
                {0,0,0,0,0,0,0,0}
        };

        int res = maxAreaOfIsland(grid);

        System.out.println(res);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = 0;
        if(rows != 0){
            cols = grid[0].length;
        }

        int maxArea = 0;
        boolean[][] isVisited = new boolean[rows][cols];

        // 返回最大的岛屿面积
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(grid[row][col] == 1 && !isVisited[row][col]){
                    maxArea = Math.max(maxArea,bfs(grid,isVisited,row,col));
                }
            }
        }

        return maxArea;
    }

    public static int bfs(int[][] grid,boolean[][] isVisited,int row,int col){
        int rows = grid.length;
        int cols = 0;
        if(rows != 0){
            cols = grid[0].length;
        }

        if(row < 0 || row >= rows || col < 0 || col >= cols){
            return 0;
        }

        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        int res = 0;

        if(grid[row][col] == 1 && !isVisited[row][col]){
            isVisited[row][col] = true;

            // 向上
            up = bfs(grid,isVisited,row - 1,col);

            // 向下
            down = bfs(grid,isVisited,row + 1,col);

            // 向左
            left = bfs(grid,isVisited,row,col - 1);

            // 向右
            right = bfs(grid,isVisited,row,col + 1);

            res = up + down + left + right + 1;
        }

        return res;
    }
}
