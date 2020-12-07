package LCEveryDay;

public class P_861 {
    public static void main(String[] args) {
        int[][] A = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        int result = matrixScore(A);

        System.out.println(result);
    }

    // 没想出来，看了题解，先保证第一列中的1最多
    // 然后再对列进行翻转，保证每一列的1尽可能多
    public static int matrixScore(int[][] A) {
        int row = A.length;
        int col = A[0].length;

        if(row == 0){
            return 0;
        }

        // 保证每一列的第一个数都为1
        for(int i = 0;i < row;i++){
            if(A[i][0] == 1){
                continue;
            }else{
                // 否则进行翻转
                for(int j = 0;j < col;j++){
                    if(A[i][j] == 0){
                        A[i][j] = 1;
                    }else{
                        A[i][j] = 0;
                    }
                }
            }
        }

        // 再从第二列开始，保证每一列的1最多
        for(int j = 1;j < col;j++){
            int countOne = 0;
            for(int i = 0;i < row;i++){
                if(A[i][j] == 1){
                    countOne++;
                }
            }
            if(countOne >= row - countOne){
                continue;
            }else{
                for(int i = 0;i < row;i++){
                    if(A[i][j] == 0){
                        A[i][j] = 1;
                    }else{
                        A[i][j] = 0;
                    }
                }
            }
        }

        int result = 0;
        for(int i = 0;i < row;i++){
            int temp = 0;
            for(int j = col - 1;j >= 0;j--){
                temp += A[i][j] * (int)Math.pow(2,col - 1 - j);
            }
            result += temp;
        }

        return result;
    }
}
