package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_10_1 {

    public static int[] arr = new int[101];

    public static void main(String[] args) {
        arr[0] = 0;
        arr[1] = 1;
        int n = 100;
        int result = fib(n);
        System.out.println(result);
    }

    public static int fib(int n) {
        if(n == 0 || n ==1){
            return n;
        }

        int i = 2;
        while(i <= n){
            arr[i] = ((arr[i - 1] % 1000000007) + (arr[i - 2] % 1000000007)) % 1000000007;
            i++;
        }

        return arr[n];
    }

}
