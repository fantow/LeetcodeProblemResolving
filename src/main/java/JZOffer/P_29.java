package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_29 {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };

        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        int[] arr = spiralOrder2(matrix);
        for(int a : arr){
            System.out.println(a);
        }
    }

    // 利用index 与 rows * cols 判断是否打印结束.
    public static int[] spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0){
            return new int[]{};
        }

        // 如果只有一行
        if(rows == 1){
            return matrix[0];
        }

        int cols = matrix[0].length;

        int[] arrResult = new int[rows * cols];

        int row = 0;
        int col = 0;
        int index = 0;


        int leftMin = 0;
        int rightMax = cols - 1;
        int upMin = 0;
        int downMax = rows - 1;

        // 想一下条件
        while(index < rows * cols){

            // 先右移
            while(col <= rightMax && index < rows * cols){
                arrResult[index++] = matrix[row][col++];
            }
            col--;
            row++;
            upMin++;

            // 第二步向下移动
            while(row <= downMax && index < rows * cols){
                arrResult[index++] = matrix[row++][col];
            }
            row--;
            col--;
            rightMax--;

            //第三步向左移动
            while(col >= leftMin && index < rows * cols){
                arrResult[index++] = matrix[row][col--];
            }
            col++;
            row--;
            downMax--;

            // 第四部向上移动
            while(row >= upMin && index < rows * cols){
                arrResult[index++] = matrix[row--][col];
            }
            row++;
            col++;
            leftMin++;
        }

        return arrResult;
    }

    // 利用矩阵边界是否相遇判断是否打印结束
    public static int[] spiralOrder2(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0){
            return new int[]{};
        }
        if(rows == 1){
            return matrix[0];
        }

        int cols = matrix[0].length;

        int upMin = 0;
        int downMax = rows - 1;
        int leftMin = 0;
        int rightMax = cols - 1;

        int[] arrResult = new int[rows * cols];
        int index = 0;

        while(true){
            // 第一步先向右移动
            for(int i = leftMin;i <= rightMax;i++){
                arrResult[index++] = matrix[upMin][i];
            }
            if(++upMin> downMax){
                break;
            }

            // 第二步向下移动
            for(int i = upMin;i <= downMax;i++){
                arrResult[index++] = matrix[i][rightMax];
            }
            if(--rightMax < leftMin){
                break;
            }

            // 第三步向左移动
            for(int i = rightMax;i >= leftMin;i--){
                arrResult[index++] = matrix[downMax][i];
            }
            if(--downMax < upMin){
                break;
            }

            // 第四步向上移动
            for(int i = downMax;i >= upMin;i--){
                arrResult[index++] = matrix[i][leftMin];
            }
            if(++leftMin > rightMax){
                break;
            }
        }

        return arrResult;
    }
}
