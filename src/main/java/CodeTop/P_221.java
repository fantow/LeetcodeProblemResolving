package CodeTop;

public class P_221 {
    public static void main(String[] args) {
//        char[][] matrix = {
//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'}
//        };

//        char[][] matrix = {
//                {'0','1'},
//                {'1','0'}
//        };

        char[][] matrix = {
                {'0'}
        };

        int res = maximalSquare(matrix);

        System.out.println(res);
    }

    public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = 0;
        if(rows != 0){
            cols = matrix[0].length;
        }

        // 应该采用dp
        // 其中dpArr[i][j]表示以矩阵(i,j)点为右下点的，最大正方形边长
        int[][] dpArr = new int[rows][cols];

        int max = Integer.MIN_VALUE;

        // 初始化
        for(int i  = 0;i < rows;i++){
            if(matrix[i][0] == '1'){
                dpArr[i][0] = 1;
                max = Math.max(max,dpArr[i][0]);
            }
        }

        for(int j = 0;j < cols;j++){
            if(matrix[0][j] == '1'){
                dpArr[0][j] = 1;
                max = Math.max(max,dpArr[0][j]);
            }
        }

        // 对于dpArr[i][j] 的取值应该为：min(dpArr[i][j - 1],dpArr[i - 1][j],dpArr[i - 1][j - 1])
        for(int row = 1;row < rows;row++){
            for(int col = 1;col < cols;col++){
                if(matrix[row][col] == '1'){
                    int min = Math.min(dpArr[row][col - 1],dpArr[row - 1][col]);
                    min = Math.min(min,dpArr[row - 1][col - 1]);
                    dpArr[row][col] = min + 1;

                    if(max < dpArr[row][col]){
                        max = dpArr[row][col];
                    }
                }
            }
        }

        return max * max;
    }
}
