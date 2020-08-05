package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */

//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
//请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
public class P_04 {

    public static void main(String[] args) {
        int[][] arrays = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int[] targets = new int[]{5,20};
        for(int target : targets){
            boolean flag = findNumberIn2DArray(arrays, target);
            System.out.println(flag);
        }
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 行数
        int rows = matrix.length;
        if(rows == 0){
            return false;
        }

        // 列数
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while(row < rows && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }

}
