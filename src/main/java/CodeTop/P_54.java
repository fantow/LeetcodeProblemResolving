package CodeTop;

import java.util.ArrayList;
import java.util.List;

public class P_54 {
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

        List<Integer> list = spiralOrder(matrix);
        System.out.println(list);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = 0;
        if(rows != 0){
            cols = matrix[0].length;
        }

        int up = 0;
        int down = rows - 1;
        int left = 0;
        int right = cols - 1;

        List<Integer> list = new ArrayList<>();

        int count = 0;

        while(count < rows * cols){

            // 上，左到右
            for(int i = left;i <= right && count < rows * cols;i++){
                list.add(matrix[up][i]);
                count++;
            }
            up++;

            // 右，上到下
            for(int i = up;i <= down && count < rows * cols;i++){
                list.add(matrix[i][right]);
                count++;
            }
            right--;

            // 下，右到左
            for(int i = right;i >= left && count < rows * cols;i--){
                list.add(matrix[down][i]);
                count++;
            }
            down--;

            // 左，下到上
            for(int i = down;i >= up && count < rows * cols;i--){
                list.add(matrix[i][left]);
                count++;
            }
            left++;
        }

        return list;
    }
}
