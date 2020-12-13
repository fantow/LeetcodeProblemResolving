package Hot100;

public class P_200 {
    public static void main(String[] args) {
//        char[][] grid = {{'1','1','1','1','0'},
//                         {'1','1','0','1','0'},
//                         {'1','1','0','0','0'},
//                         {'0','0','0','0','0'}};


//        char[][] grid = {
//                {'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'}
//        };

        char[][] grid = {{'0'}};

        int result = numIslands(grid);
        System.out.println(result);
    }

    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        if(rows == 0){
            return 0;
        }
        int cols = grid[0].length;

        // 用来记录当前岛屿是否被访问过
        boolean[][] visited = new boolean[rows][cols];

        int count = 0;

        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(visited[i][j] != true && grid[i][j] == '1'){
                    count++;
                    dfs(visited,i,j,grid);
                }
            }
        }

        return count;
    }

    public static void dfs(boolean[][] visited,int row,int col,char[][] grid){
        int rows = grid.length;
        if(rows == 0){
            return ;
        }
        int cols = grid[0].length;

        if(row < 0 || row >= rows || col < 0 || col >= cols){
            return ;
        }

        // 如果是水或者已经被访问过，直接返回
        if(grid[row][col] == '0' || visited[row][col] == true){
            return ;
        }

        visited[row][col] = true;

        // 只有上下，左右才能算是岛屿
        // 向上
        dfs(visited,row - 1,col,grid);

        // 向下
        dfs(visited,row + 1,col,grid);

        // 向左
        dfs(visited,row,col - 1,grid);

        // 向右
        dfs(visited,row,col + 1,grid);

        return ;
    }
}
