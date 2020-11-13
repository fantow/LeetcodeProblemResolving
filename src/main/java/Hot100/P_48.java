package Hot100;

import java.util.LinkedList;

public class P_48 {
    public static void main(String[] args) {
//        int[][] maxtrix = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };

        int[][] maxtrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };


        rotate(maxtrix);
        for(int i = 0;i < maxtrix.length;i++){
            for(int j = 0;j < maxtrix.length;j++){
                System.out.print(maxtrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        if(length == 0){
            return;
        }

        int ptr1 = 0;
        int ptr2 = length - 1;

        while(ptr2 - ptr1 >= 1){
            for(int i = 0;i < ptr2 - ptr1;i++){
                int temp = matrix[ptr1][ptr1 + i];
                matrix[ptr1][ptr1 + i] = matrix[ptr2 - i][ptr1];
                matrix[ptr2 - i][ptr1] = matrix[ptr2][ptr2 - i];
                matrix[ptr2][ptr2 - i] = matrix[ptr1 + i][ptr2];
                matrix[ptr1 + i][ptr2] = temp;
            }
            ptr1++;
            ptr2--;
        }

        return;
    }
}
