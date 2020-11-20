package Hot100;

import java.util.ArrayList;
import java.util.List;

public class P_51 {

    public static List<List<String>> resultList = new ArrayList<>();
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> lists = solveNQueens(n);

        for(List<String> list : lists){
            System.out.println(list);
        }
    }

    // 题解中使用了一个二维数组记录当前棋盘的状态，相当于将tempList和isVisited合并了
    public static List<List<String>> solveNQueens(int n) {
        if(n == 0){
            return resultList;
        }

        char[][] chess = new char[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                chess[i][j] = '.';
            }
        }
        solve(chess,0);

        return resultList;
    }

    public static void solve(char[][] chess,int row){
        int length = chess.length;
        if(row == length){
            List<String> tempList = new ArrayList<>();
            for(int i = 0;i < length;i++){
                tempList.add(new String(chess[i]));
            }
            resultList.add(tempList);
            return;
        }

        for(int col = 0;col < length;col++){
            if(isValid(chess,row,col)){
                chess[row][col] = 'Q';
                solve(chess,row + 1);
                // 恢复现场
                chess[row][col] = '.';
            }else{
                continue;
            }
        }

        return;
    }

    public static boolean isValid(char[][] chess,int row,int col){
        // 判断行
//        for(int i = 0;i < chess.length;i++){
//            if(chess[row][i] == 'Q'){
//                return false;
//            }
//        }

        // 判断列
        for(int j= 0;j < chess.length;j++){
            if(chess[j][col] == 'Q'){
                return false;
            }
        }

        // 判断左上对角线
        for(int i = row - 1,j = col - 1;i >= 0 && j >= 0;i--,j--){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }

        // 判断右上对角线
        for(int i = row - 1,j = col + 1;i >= 0 && j < chess.length;i--,j++){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }

        // 为什么不需要判断左下和右下？因为是按行遍历的，下面一定没有

        return true;
    }




}
