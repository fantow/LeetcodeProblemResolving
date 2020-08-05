package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_10_2 {

    public static int[] arr = new int[101];
    static{
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
    }

    public static void main(String[] args) {
        int n = 7;
        int result = numWays(n);

        System.out.println(result);
    }

    public static int numWays(int n) {
        if(n == 0 || n == 1 || n == 2){
            return arr[n];
        }
        int i = 3;
        while(i <= n){
            arr[i] = ((arr[i - 1] % 1000000007) + (arr[i - 2] % 1000000007)) % 1000000007;
            i++;
        }

        return arr[n];
    }

}
