package Hot100;

public class P_79 {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
//        String word = "ABCCED";
        String word = "SEE";
//        String word = "ABCB";

        boolean flag = exist(board, word);
        System.out.println(flag);
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        if(rows == 0){
            return false;
        }

        int cols = board[0].length;

        // 应该是使用回溯法
        boolean[][] isVisted = new boolean[rows][cols];

        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(dfs(board,row,col,isVisted,word,0)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(char[][] board,int row,int col,boolean[][] isVisited,String word,int idx){
        int length = word.length();
        if(idx >= length){
            return true;
        }

        int rows = board.length;
        if(rows == 0){
            return false;
        }

        int cols = board[0].length;

        if(row < 0 || row >= rows || col < 0 || col >= cols){
            return false;
        }

        if(isVisited[row][col] == true){
            return false;
        }

        if(word.charAt(idx) == board[row][col]){
            isVisited[row][col] = true;

            if(dfs(board,row - 1,col,isVisited,word,idx + 1) ||
                    dfs(board,row + 1,col,isVisited,word,idx + 1) ||
                    dfs(board,row,col - 1,isVisited,word,idx + 1) ||
                    dfs(board,row,col + 1,isVisited,word,idx + 1))   {
                return true;
            }

            // 向上
//            boolean upFlag = dfs(board,row - 1,col,isVisited,word,idx + 1);
//
//            // 向下
//            boolean downFlag = dfs(board,row + 1,col,isVisited,word,idx + 1);
//
//            // 向左
//            boolean leftFlag = dfs(board,row,col - 1,isVisited,word,idx + 1);
//
//            // 向右
//            boolean rightFlag = dfs(board,row,col + 1,isVisited,word,idx + 1);

            isVisited[row][col] = false;

//            if(upFlag || downFlag || leftFlag || rightFlag){
////                System.out.println(111);
//                return true;
//            }
        }

        return false;
    }

}
