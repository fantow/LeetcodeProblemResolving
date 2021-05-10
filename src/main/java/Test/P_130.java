package Test;

public class P_130 {
    public static void main(String[] args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'},
        };

        solve(board);

        for(int row = 0;row < board.length;row++){
            for(int col = 0;col < board[0].length;col++){
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void solve(char[][] board) {
        int rows = board.length;
        int cols = 0;
        if(rows != 0){
            cols = board[0].length;
        }


        // 应该是换一种思路，先将边界为0的找出来，再利用这些点去找里面没有被包围的点
        // 左右两个边
        // 先将得到的'O'转换为'Y'
        for(int row = 0;row < rows;row++){
            if(board[row][0] == 'O'){
                dfs(board,row,0);
            }

            if(board[row][cols - 1] == 'O'){
                dfs(board,row,cols - 1);
            }
        }


        // 上下两个边
        for(int col = 0;col < cols;col++){
            if(board[0][col] == 'O'){
                dfs(board,0,col);
            }

            if(board[rows - 1][col] == 'O'){
                dfs(board,rows - 1,col);
            }
        }


        // 再将'Y'变为'O'，将'O'变为'X'
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(board[row][col] == 'O'){
                    board[row][col] = 'X';
                }else if(board[row][col] == 'Y'){
                    board[row][col] = 'O';
                }
            }
        }


        return ;
    }

    // dfs遍历到的节点，需要被标记为'Y'
    public static void dfs(char[][] matrix,int row,int col){
        int rows = matrix.length;
        int cols = 0;
        if(rows != 0){
            cols = matrix[0].length;
        }

        if(row < 0 || row >= rows || col < 0 || col >= cols || matrix[row][col] != 'O'){
            return ;
        }

        // 先修改自己
        matrix[row][col] = 'Y';

        // 向上
        if(row - 1 >= 0){
            dfs(matrix,row - 1,col);
        }

        // 向下
        if(row + 1 < rows){
            dfs(matrix,row + 1,col);
        }

        // 向左
        if(col - 1 >= 0){
            dfs(matrix,row,col - 1);
        }

        // 向右
        if(col + 1 < cols){
            dfs(matrix,row,col + 1);
        }
    }
}
