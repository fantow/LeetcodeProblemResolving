package LCEveryDay;

public class P_304 {

    public int[][] sumMatrix = null;


    public static void main(String[] args) {

    }

    public P_304(int[][] matrix){
        int rows = matrix.length;
        int cols = 0;
        if(rows != 0){
            cols = matrix[0].length;
        }

        sumMatrix = new int[rows][cols];

        int temp = 0;
        for(int col = 0;col < cols;col++){
            sumMatrix[0][col] = temp + matrix[0][col];
            temp = sumMatrix[0][col];
        }

        // 构建sumMatrix
        for(int row = 1;row < rows;row++){
            for(int col = 0;col < cols;col++){


            }
        }
    }


    public int sumRegion(int row1, int col1, int row2, int col2) {

        return 0;
    }
}
