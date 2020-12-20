package LCEveryDay;

public class P_48 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        rotate(matrix);

        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix){
        for(int[] arr : matrix){
            for(int num : arr){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }


    // 题目保证是矩阵了,先水平翻转，后对角线翻转
    public static void rotate(int[][] matrix) {
        int row = matrix.length;
        if(row <= 1){
            return ;
        }

        // 水平翻转
        for(int i = 0;i < row / 2;i++){
            for(int j = 0;j < row;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row - 1 - i][j];
                matrix[row - 1 - i][j] = temp;
            }
        }

//         对角线翻转
        for(int i = 0;i < row;i++){
            for(int j = 0;j < i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
