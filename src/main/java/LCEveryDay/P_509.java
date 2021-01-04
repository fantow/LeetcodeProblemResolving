package LCEveryDay;

public class P_509 {
    public static void main(String[] args) {
//        int n = 2;
//        int n = 3;
        int n = 4;

        int result = fib(n);

        System.out.println(result);
    }

    public static int fib(int n) {
        int[] dpArr = new int[n + 1];

        dpArr[0] = 0;
        dpArr[1] = 1;

        for(int i = 2;i <= n;i++){
            dpArr[i] = dpArr[i - 1] + dpArr[i - 2];
        }

        return dpArr[n];
    }
}
