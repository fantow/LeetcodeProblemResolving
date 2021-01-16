package Algo91.Chap01_数组_栈_队列;

import java.util.LinkedList;
import java.util.Queue;

public class P_542 {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {0,0,0},
//                {0,1,0},
//                {0,0,0}
//        };

        int[][] matrix = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };

//        int[][] matrix = {
//                {1,0,1,1,0,0,1,0,0,1},
//                {0,1,1,0,1,0,1,0,1,1},
//                {0,0,1,0,1,0,0,1,0,0},
//                {1,0,1,0,1,1,1,1,1,1},
//                {0,1,0,1,1,0,0,0,0,1},
//                {0,0,1,0,1,1,1,0,1,0},
//                {0,1,0,1,0,1,0,0,1,1},
//                {1,0,0,0,1,1,1,1,0,1},
//                {1,1,1,1,1,1,1,0,1,0},
//                {1,1,1,1,0,1,0,0,1,1}
//        };

        int[][] result = updateMatrix(matrix);

        for(int i = 0;i < result.length;i++){
            for(int j = 0;j < result[0].length;j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }


    // 使用BFS做，之前一直用的DFS
    public static int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0){
            return null;
        }
        int cols = matrix[0].length;

        int[][] result = new int[rows][cols];
        boolean[][] isVisited = new boolean[rows][cols];
        int visited = 0;

        Queue<Pair> queue = new LinkedList<>();

        for(int row = 0;row < rows;row ++){
            for(int col = 0;col < cols;col++){
                if(matrix[row][col] == 0){
                    queue.offer(new Pair(row,col,matrix[row][col]));
                    isVisited[row][col] = true;
                    visited++;
                    result[row][col] = 0;
                }
            }
        }

        while(!queue.isEmpty() || visited < rows * cols){
            Pair pair = queue.poll();
            int row = pair.x;
            int col = pair.y;
            int val = pair.val;

            // 向上
            if(row - 1 >= 0){
                if(isVisited[row - 1][col] == false && matrix[row - 1][col] != 0){
                    result[row - 1][col] = val + 1;
                    isVisited[row - 1][col] = true;
                    visited++;
                    queue.offer(new Pair(row - 1,col,val + 1));
                }
            }

            // 向下
            if(row + 1 < rows){
                if(isVisited[row + 1][col] == false && matrix[row + 1][col] != 0){
                    result[row + 1][col] = val + 1;
                    isVisited[row + 1][col] = true;
                    visited++;
                    queue.offer(new Pair(row + 1,col,val + 1));
                }
            }

            // 向左
            if(col - 1 >= 0){
                if(isVisited[row][col - 1] == false && matrix[row][col - 1] != 0){
                    result[row][col - 1] = val + 1;
                    isVisited[row][col - 1] = true;
                    visited++;
                    queue.offer(new Pair(row,col - 1,val + 1));
                }
            }

            // 向右
            if(col + 1 < cols){
                if(isVisited[row][col + 1] == false && matrix[row][col + 1] != 0){
                    result[row][col + 1] = val + 1;
                    isVisited[row][col + 1] = true;
                    visited++;
                    queue.offer(new Pair(row,col + 1,val + 1));
                }
            }
        }

        return result;
    }


    public static class Pair{
        public int x;
        public int y;
        public int val;

        public Pair(int x, int y,int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

//    public static int[][] updateMatrix(int[][] matrix) {
//        int rows = matrix.length;
//        if(rows == 0){
//            return null;
//        }
//
//        int cols = matrix[0].length;
//
//        int[][] result = new int[rows][cols];
//
//        // 可以表示： 0 --> 还没计算，
//        //           1 --> 正在计算，
//        //           2 --> 计算完成
//        int[][] isVisited = new int[rows][cols];
//
//        for(int row = 0;row < rows;row++){
//            for(int col = 0;col < cols;col++){
//                func(matrix,result,isVisited,row,col);
//            }
//        }
//
//        return result;
//    }

    public static int func(int[][] matrix,int[][] result,int[][] isVisited,int row,int col){
        int rows = matrix.length;
        if(rows == 0){
            return Integer.MAX_VALUE;
        }
        int cols = matrix[0].length;

        if(row < 0 || row >= rows || col < 0 || col >= cols){
            return Integer.MAX_VALUE;
        }

        // 如果该点值为0，就可以直接确定该点路径长度为0
        if(matrix[row][col] == 0){
            isVisited[row][col] = 2;
            result[row][col] = 0;
        }


        // 如果该点正在被计算，先返回Integer.MAX_VALUE
        if(isVisited[row][col] == 1){
            return Integer.MAX_VALUE;
        }

        // 如果该值已经计算完成，就直接返回
        if(isVisited[row][col] == 2){
            return result[row][col];
        }

        // 将该点状态改为正在计算
        isVisited[row][col] = 1;

        int minVal = Integer.MAX_VALUE;

        // 向上
        int upVal = func(matrix,result,isVisited,row - 1,col);
        minVal = Math.min(minVal,upVal);

        // 向下
        int downVal = func(matrix, result, isVisited, row + 1, col);
        minVal = Math.min(minVal,downVal);

        // 向左
        int leftVal = func(matrix, result, isVisited, row, col - 1);
        minVal = Math.min(minVal,leftVal);

        // 向右
        int rightVal = func(matrix, result, isVisited, row, col + 1);
        minVal = Math.min(minVal,rightVal);

        result[row][col] = minVal + 1;
        isVisited[row][col] = 2;

        return minVal + 1;
    }
}
