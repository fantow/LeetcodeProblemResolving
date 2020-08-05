package JZOffer;

import com.sun.org.apache.xerces.internal.dom.AbortException;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_12 {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

//        char[][] board = {
//                {'a','b'},
//                {'c','d'}
//        };

        String word = "ABCCED";
//        String word = "abcd";
        boolean flag = exist(board, word);

        System.out.println(flag);
    }

    // 使用回溯法
    public static boolean exist(char[][] board, String word) {
        char[] charArray = word.toCharArray();
        int rows = board.length;
        if(rows == 0){
            return false;
        }

        int cols = board[0].length;

        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(dfs(board,charArray,row,col,0)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(char[][] board,char[] word,int row,int col,int len){
        if(len == word.length){
            return true;
        }
        if(row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] != word[len]){
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '*';

        boolean flag = dfs(board,word,row - 1,col,len + 1) ||
                       dfs(board,word,row + 1,col,len + 1) ||
                       dfs(board,word,row,col - 1,len + 1) ||
                       dfs(board,word,row,col + 1,len + 1);

        board[row][col] = temp;
        return flag;
    }

}
