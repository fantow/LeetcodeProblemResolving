package Hot100;

public class P_74 {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        boolean flag = searchMatrix(matrix, target);

        System.out.println(flag);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0){
            return false;
        }

        int col = matrix[0].length;

        int i = 0;
        int j = col - 1;

        while(i >= 0 && i < row && j >= 0 && j < col){
            int num = matrix[i][j];
            if(num == target){
                return true;
            }else if(num > target){
                j--;
            }else {
                i++;
            }
        }

        return false;
    }


    public static boolean searchMatrix1(int[][] matrix, int target) {
        // 行数
        int row = matrix.length;
        if(row == 0){
            return false;
        }

        // 列数
        int col = matrix[0].length;

        // 从右上角开始找
        for(int i = 0;i < row;i++){
            for(int j = col - 1;j >= 0;j--){
                int num = matrix[i][j];
                if(num == target){
                    return true;
                }else if(num > target){
                    // 如果当前值比targe大，向左找
                    continue;
                }else{
                    // 如果当前值比target大，向下找
                    break;
                }
            }
        }

        return false;
    }
}
