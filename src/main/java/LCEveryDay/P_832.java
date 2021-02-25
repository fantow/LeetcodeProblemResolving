package LCEveryDay;

public class P_832 {
    public static void main(String[] args) {
//        int[][] A = {
//                {1,1,0},
//                {1,0,1},
//                {0,0,0}
//        };


        int[][] A = {
                {1,1,0,0},
                {1,0,0,1},
                {0,1,1,1},
                {1,0,1,0}
        };


        int[][] arrays = flipAndInvertImage(A);

        for(int[] array : arrays){
            for(int num : array){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        int rows = A.length;
        int cols = 0;
        if(rows != 0){
            cols = A[0].length;
        }

        // 先翻转再取反
        for(int row = 0;row < rows;row++){
            for(int j = 0;j < cols / 2;j++){
                int temp = A[row][j];
                A[row][j] = A[row][cols - 1 - j];
                A[row][cols - 1 - j] = temp;
            }
        }

        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                A[row][col] = changeNum(A[row][col]);
            }
        }

        return A;
    }


    public static int changeNum(int num){
        if(num == 0){
            return 1;
        }else if(num == 1){
            return 0;
        }
        return -1;
    }
}
