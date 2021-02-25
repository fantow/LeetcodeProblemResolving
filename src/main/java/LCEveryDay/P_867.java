package LCEveryDay;

public class P_867 {
    public static void main(String[] args) {
//        int[][] matrix = {
//            {1,2,3},
//            {4,5,6},
//            {7,8,9}
//        };

        int[][] matrix = {
            {1,2,3},
            {4,5,6}
        };

        int[][] transpose = transpose(matrix);

        for(int[] arr : transpose){
            for(int num : arr){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = 0;
        if(rows != 0){
            cols = matrix[0].length;
        }


        int[][] result = new int[cols][rows];

        // 只需要将索引逆置即可
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                result[col][row] = matrix[row][col];
            }
        }

        return result;
    }
}
