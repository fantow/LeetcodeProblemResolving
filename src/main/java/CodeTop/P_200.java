package CodeTop;

public class P_200 {
    public static void main(String[] args) {

        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };

        int res = numIslands(grid);
        System.out.println(res);
    }

    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = 0;
        if(rows != 0){
            cols = grid[0].length;
        }

        boolean[][] isVisited = new boolean[rows][cols];

        int result = 0;

        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(grid[row][col] != '0' && !isVisited[row][col]){
                    bfs(grid,isVisited,row,col);
                    result++;
                }
            }
        }

        return result;
    }

    public static void bfs(char[][] grid,boolean[][] isVisited,int row,int col){
        int rows = grid.length;
        int cols = 0;
        if(rows != 0){
            cols = grid[0].length;
        }

        if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != '1'  || isVisited[row][col]){
            return ;
        }

        // 标记为被访问
        isVisited[row][col] = true;

        // 上
        bfs(grid,isVisited,row - 1,col);

        // 下
        bfs(grid,isVisited,row + 1,col);

        // 左
        bfs(grid,isVisited,row,col - 1);

        // 右
        bfs(grid,isVisited,row,col + 1);
    }
}
