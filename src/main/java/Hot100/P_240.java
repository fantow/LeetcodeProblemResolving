package Hot100;

public class P_240 {
    public static void main(String[] args) {
//        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] matrix = {{1,1}};
        int target = 2;
        boolean flag = searchMatrix(matrix, target);

        System.out.println(flag);
    }

    // 应该是使用主对角线(矩阵不保证是m*m的)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0){
            return false;
        }
        int col = matrix[0].length;

        int i = 0;
        int j = col - 1;

        // 从右上遍历，如果大就向下走，否则向左走
        while(i >= 0 && i < row && j >= 0 && j < col){
            int num = matrix[i][j];
            if(num == target){
                return true;
            }else if(num > target){
                j--;
            }else{
                i++;
            }
        }

        return false;
    }
}
