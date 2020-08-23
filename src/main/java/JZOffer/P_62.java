package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_62 {
    public static void main(String[] args) {
        int n = 5;
        int m = 3;

        int result = lastRemaining(n, m);
        System.out.println(result);
    }

    public static int lastRemaining(int n, int m) {
        int last = 0;
        for(int i = 2;i <= n;i++){
            last = (last + m) % i;
        }

        return last;
    }
}
