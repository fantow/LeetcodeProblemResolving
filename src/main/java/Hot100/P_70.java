package Hot100;

public class P_70 {
    public static void main(String[] args) {
//        int n = 2;
//        int n = 3;
        int n = 4;


        int i = climbStairs(n);

        System.out.println(i);
    }

    // dp问题
    public static int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }

        int[] dpArr = new int[n + 1];
        dpArr[0] = 1;
        dpArr[1] = 1;

        for(int i = 2;i <= n;i++){
            dpArr[i] = dpArr[i - 1] + dpArr[i - 2];
        }

        return dpArr[n];
    }
}
