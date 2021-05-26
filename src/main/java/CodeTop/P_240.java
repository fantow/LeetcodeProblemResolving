package CodeTop;

public class P_240 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };

//        int target = 5;
//        int target = 16;
//        int target = 0;
        int target = 25;

        boolean flag = searchMatrix(matrix, target);
        System.out.println(flag);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = 0;
        if(rows != 0){
            cols = matrix[0].length;
        }

        int row = 0;
        int col = cols - 1;
        // 查找顺序：从右上到左下
        while(row < rows && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                // 向下查找
                row ++;

            }else{
                col--;
            }
        }

        return false;
    }
}
