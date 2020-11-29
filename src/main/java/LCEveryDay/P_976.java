package LCEveryDay;

import java.util.Arrays;

public class P_976 {
    public static void main(String[] args) {
        int[] A = {2,1,2};
        int result = largestPerimeter(A);

        System.out.println(result);
    }

    public static int largestPerimeter(int[] A) {
        int length = A.length;

        if(length < 3){
            return 0;
        }

        Arrays.sort(A);

        for(int i = length - 1;i >= 2;i--){
            if(A[i - 2] + A[i - 1] > A[i]){
                return A[i] + A[i - 1] + A[i - 2];
            }
        }

        return 0;
    }
}
