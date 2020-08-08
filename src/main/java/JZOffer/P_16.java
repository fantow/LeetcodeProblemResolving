package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_16 {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2;
        double result = myPow(x, n);

        System.out.println(result);;
    }

    public static double myPow(double x, int n) {

        if(x == 0){
            return 0;
        }

        // 防止越界
        long b = n;

        if(b < 0){
            b = -b;
            x = 1 / x;
        }

        if(b == 0){
            return 1;
        }

        if(b == 1){
            return x;
        }


        double result = 1;
        while(b != 0){
            if(b % 2 == 1){
                result *= x;
            }
            x *= x;
            b /= 2;
        }

        return result;
    }
}
