package Algo91.Chap01_数组_栈_队列;

public class P_200 {
    public static void main(String[] args) {
//        char[][] grid = {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'},
//        };


        //  ["1","1","0","0","0"],
        //  ["1","1","0","0","0"],
        //  ["0","0","1","0","0"],
        //  ["0","0","0","1","1"]

        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},
        };

        int nums = numIslands(grid);
        System.out.println(nums);
    }

    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        if(rows == 0){
            return 0;
        }

        int cols = grid[0].length;
        boolean[][] isVisited = new boolean[rows][cols];

        int count = 0;
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(grid[row][col] == '1' && !isVisited[row][col]){
                    bfsFunc(grid,isVisited,row,col);
                    count++;
                }
            }
        }

        return count;
    }

    public static void bfsFunc(char[][] grid,boolean[][] isVisited,int row,int col){
        int rows = grid.length;
        if(rows == 0){
            return ;
        }

        int cols = grid[0].length;
        if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != '1' || isVisited[row][col] == true){
            return ;
        }


//        System.out.println("value: " + grid[row][col]);
        isVisited[row][col] = true;

//        for(int i = 0;i < rows;i++){
//            for(int j = 0;j < cols;j++){
//                System.out.print(isVisited[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        // 向上
        bfsFunc(grid,isVisited,row - 1,col);

        // 向下
        bfsFunc(grid,isVisited,row + 1,col);

        // 向左
        bfsFunc(grid,isVisited,row ,col - 1);

        // 向右
        bfsFunc(grid,isVisited,row,col + 1);

        return;
    }

}
