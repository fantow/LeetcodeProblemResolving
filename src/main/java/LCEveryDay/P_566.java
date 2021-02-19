package LCEveryDay;

public class P_566 {
    public static void main(String[] args) {
        int[][] nums = {
                {1,2},
                {3,4}
        };

//        int r = 1;
//        int c = 4;

//        int r = 2;
//        int c = 4;

        int r = 4;
        int c = 1;

//        int[][] nums = {{1},{2},{3},{4}};

//        int r = 2;
//        int c = 2;

        int[][] ints = matrixReshape(nums, r, c);

        for(int[] arr : ints){
            for(int num : arr){
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int cols = 0;
        if(rows != 0){
            cols = nums[0].length;
        }

        if(rows * cols != r * c){
            return nums;
        }


        int[][] tempArr = new int[r][c];

        for(int tempRow = 0;tempRow < r;tempRow++){
            for(int tempCol = 0;tempCol < c;tempCol++){
                int num = tempRow * c + tempCol;
                int oldRow = num / cols;
                int oldCols = num % cols;

                tempArr[tempRow][tempCol] = nums[oldRow][oldCols];
            }
        }

        return tempArr;
    }
}
