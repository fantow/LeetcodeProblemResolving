package CodeTop;

public class P_48 {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };

        int[][] matrix = {
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };

        rotate(matrix);

        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix.length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 先水平上下翻转，再以主对角线翻转
    public static void rotate(int[][] matrix) {
        int length = matrix.length;

        // 水平上下翻转
        for(int i = 0;i < length / 2;i++){
            int[] temp = matrix[i];
            matrix[i] = matrix[length - 1 - i];
            matrix[length - 1 - i] = temp;
        }

        // 以主对角线翻转
        for(int i = 0;i < length;i++){
            for(int j = i + 1;j < length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        return ;
    }
}
