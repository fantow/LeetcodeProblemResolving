package Test;

import java.util.Scanner;

public class FanggeTest {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // 矩阵的边长
//        int n = scanner.nextInt();
//
//        // 每步最多走多少格
//        int k = scanner.nextInt();
//
//        int[][] matrix = new int[n][n];
//
//        for(int row = 0;row < n;row++){
//            for(int col = 0;col < n;col++){
//                matrix[row][col] = scanner.nextInt();
//            }
//        }

        int n = 3;
        int k = 1;

        int[][] matrix = {
                {0,5,37},
                {55,10,19},
                {12,9,18}
        };

        // 本质上就是一个DFS，从左上角出发
        boolean[][] isVisited = new boolean[n][n];

        int maxVal = 0;

        // 表示每一步走的步长
        maxVal = Math.max(dfs(matrix,0,0,k,isVisited,0,Integer.MIN_VALUE),maxVal);

        System.out.println(maxVal);
    }

    // 还有一个限制条件：本次到达格子的值要比上一个大
    public static int dfs(int[][] matrix,int row,int col,int k,boolean[][] isVisited,int val,int preVal){
        int rows = matrix.length;
        int cols = 0;
        if(rows != 0){
            cols = matrix[0].length;
        }

        // 判断row，col是否合法
        if(row < 0 || row >= rows || col < 0 || col >= cols){
            return 0;
        }

        if(isVisited[row][col]){
            return 0;
        }

        // 当前格子的值要比上一个的大
        if(preVal != Integer.MIN_VALUE && preVal >= matrix[row][col]){
            return val;
        }

        isVisited[row][col] = true;

        val += matrix[row][col];

        int maxVal = val;

        // 尝试各种步长
        for(int step = 1;step <= k;step++){
            // 向上
            maxVal = Math.max(maxVal,dfs(matrix,row - step,col,k,isVisited,val,matrix[row][col]));

            // 向下
            maxVal = Math.max(maxVal,dfs(matrix,row + step,col,k,isVisited,val,matrix[row][col]));

            // 向左
            maxVal = Math.max(maxVal,dfs(matrix,row ,col - step,k,isVisited,val,matrix[row][col]));

            // 向右
            maxVal = Math.max(maxVal,dfs(matrix,row,col + step,k,isVisited,val,matrix[row][col]));
        }

        isVisited[row][col] = false;

        return maxVal;
    }

}
