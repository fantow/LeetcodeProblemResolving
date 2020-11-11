package Hot100;

public class P_7 {
    public static void main(String[] args) {
//        int x = 123;
//        int x = -123;
//        int x = 120;
        int x = 1534236469;
        int result = reverse(x);
        System.out.println(result);
    }

    public static int reverse(int x) {
        boolean isNegitive = false;
        if(x < 0){
            isNegitive = true;
            x = Math.abs(x);
        }

        long result = 0;

        while (x > 0){
            result = result * 10 + x % 10;
            x = x / 10;
        }

        if(isNegitive){
            result = - result;
        }

        if(result >Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }

        return (int)result;
    }
}
