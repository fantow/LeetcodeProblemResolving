package Hot100;

public class P_85 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        int result = maximalRectangle(matrix);

        System.out.println(result);
    }


    // 做过一个求最大正方形面积的题，感觉很像
    public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row == 0){
            return 0;
        }

        int col = matrix[0].length;

        int[][] dpArr = new int[row][col];

        int maxArea = 0;

        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(matrix[i][j] == '1'){
                    if(j == 0){
                        dpArr[i][j] = 1;
                    }else{
                        dpArr[i][j] = dpArr[i][j - 1] + 1;
                    }

                    int width = dpArr[i][j];

                    for(int k = i;k >= 0;k--){
                        width = Math.min(width,dpArr[k][j]);

                        maxArea = Math.max(width * (i - k + 1),maxArea);
                    }
                }
            }
        }

        return maxArea;
    }
}
