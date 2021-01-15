package Algo91.Chap01_数组_栈_队列;

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


        int[][] resultMatrix = updateMatrix(matrix);

        for(int i = 0;i < resultMatrix.length;i++){
            for(int j = 0;j < resultMatrix[0].length;j++){
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0){
            return null;
        }

        int cols = matrix[0].length;

        int[][] resultMatrix = new int[rows][cols];

        // 初始化为MaxValue
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                resultMatrix[row][col] = Integer.MAX_VALUE;
            }
        }

        boolean[][] isVisited = new boolean[rows][cols];
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                bfsFunc(matrix,resultMatrix,isVisited,row,col);
            }
        }

        return resultMatrix;
    }

    public static int bfsFunc(int[][] matrix,int[][] resultMatrix,boolean[][] isVisited,int row,int col){
        int rows = matrix.length;
        if(rows == 0){
            return Integer.MAX_VALUE;
        }

        int cols = matrix[0].length;
        if(row < 0 || row >= rows || col < 0 || cols >= cols){

        }



        return -1;
    }
}
