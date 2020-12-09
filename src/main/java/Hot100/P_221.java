package Hot100;

public class P_221 {
    public static void main(String[] args) {
//        char[][] matrix = { {'1','0','1','1','1'},
//                            {'1','0','1','1','1'},
//                            {'1','1','1','1','1'},
//                            {'1','0','0','1','0'}};


//        char[][] matrix = {{'0','1'},{'1','0'}};

//        char[][] matrix = {{'0'}};
        char[][] matrix = {{'0'},{'1'}};

        int result = maximalSquare(matrix);

        System.out.println(result);
    }


    // 使用dp
    public static int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if(row == 0){
            return 0;
        }

        int col = matrix[0].length;

        // dp[i][j]表示的是以(i,j)为右下角构成的正方形的最大边长
        int[][] dpArr = new int[row][col];

        int maxLen = 0;

        // 初始化
        for(int i = 0;i < row;i++){
            if(matrix[i][0] == '1'){
                dpArr[i][0] = 1;
                maxLen = Math.max(maxLen,1);
            }
        }



        for(int j = 0;j < col;j++){
            if(matrix[0][j] == '1'){
                dpArr[0][j] = 1;
                maxLen = Math.max(maxLen,1);
            }
        }

        for(int i = 1;i < row;i++){
            for(int j = 1;j <col;j++){
                if(matrix[i][j] == '1'){
                    int min = Math.min(dpArr[i - 1][j],dpArr[i][j - 1]);
                    min = Math.min(dpArr[i - 1][j - 1],min);
                    dpArr[i][j] = min + 1;
                    maxLen = Math.max(maxLen,dpArr[i][j]);
                }
            }
        }

        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                System.out.print(dpArr[i][j] + " ");
            }
            System.out.println();
        }

        return maxLen;
    }







    public static int maximalSquare1(char[][] matrix) {
        int row = matrix.length;
        if(row == 0){
            return 0;
        }

        int col = matrix[0].length;

        // 这里指可能存在的正方形的最大边长
        int maxLength = row > col ? col : row;

        // 计算二维前缀和，其中sumArr[i][j]表示的是(0,0)~(i,j)这个区域中的总和
        int[][] sumArr = new int[row + 1][col + 1];

        sumArr[1][1] = matrix[0][0] - '0';

        // 初始化
        for(int i = 2;i < col;i++){
            sumArr[1][i] = sumArr[1][i - 1] + (matrix[1][i - 1] - '0');
        }

        for(int j = 2;j < row;j++){
            sumArr[j][1] = sumArr[j - 1][1] + (matrix[j][1] - '0');
        }



        for(int i = 2;i < row + 1;i++){
            for(int j = 2;j < col + 1;j++){
                sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i-1][j-1];
                if(matrix[i - 1][j - 1] == '1'){
                    sumArr[i][j] += (matrix[i - 1][j - 1] - '0');
                }
            }
        }

        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                System.out.print(sumArr[i][j] + " ");
            }
            System.out.println();
        }


        int curLen = 0;

//         其中至少大小为1
        if(sumArr[row][col] != 0){
            curLen = 1;
        }

        int resultLen = 1;
        // 最终长度一定不会超过maxLen
        while(curLen <= maxLength){
            int tempLen = curLen;
            for(int i = curLen;i < row;i++){
                for(int j = curLen;j < col;j++){
                    int tempArr = sumArr[i][j] - sumArr[i - curLen][j] - sumArr[i][j - curLen] + sumArr[i - curLen][j - curLen];
                    if(tempArr == curLen * curLen){
                        System.out.println("记录：  i:" + i + " j:" + j + " curLen:" + curLen);
                        resultLen = curLen;
                        curLen++;
                        break;
                    }
                }
            }
            // 如果在某一轮中没有提高，那就说明已经拿到最大值了
            if(tempLen == curLen){
                return resultLen * resultLen;
            }
        }
//        System.out.println(resultLen);

        return resultLen * resultLen;
    }
}
