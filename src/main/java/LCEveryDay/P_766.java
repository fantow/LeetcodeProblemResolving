package LCEveryDay;

public class P_766 {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1,2,3,4},
//                {5,1,2,3},
//                {9,5,1,2}
//        };

//        int[][] matrix = {
//                {1,2},
//                {2,2}
//        };

        int[][] matrix = {{1},{2},{3}};

        boolean flag = isToeplitzMatrix(matrix);

        System.out.println(flag);
    }


    // 判断从左上到右下的这一条线上元素是否相等
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = 0;
        if(rows != 0){
            cols = matrix[0].length;
        }

        if(rows == 0){
            return true;
        }

        // 需要从第一列和第一行遍历
        // 先判断第一列的元素是否符合要求
        for(int row = rows - 1;row >= 1;row--){
            int num = matrix[row][0];
            int tempRow = row;
            int tempCol = 0;

            for(;tempRow < rows && tempCol < cols;tempRow++,tempCol++){
                if(matrix[tempRow][tempCol] != num){
                    return false;
                }
            }
        }

        // 再判断第一行的元素是否符合要求
        for(int col = 0;col < cols;col++){
            int num = matrix[0][col];
            int tempRow = 0;
            int tempCol = col;

            for(;tempRow < rows && tempCol < cols;tempRow++,tempCol++){
                if(matrix[tempRow][tempCol] != num){
                    return false;
                }
            }
        }

        return true;
    }
}
