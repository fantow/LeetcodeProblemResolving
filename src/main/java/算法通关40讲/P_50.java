package 算法通关40讲;

public class P_50 {
    public static void main(String[] args) {
//        double x = 2.00000;
//        int n = 10;

//        double x = 2.10000;
//        int n = 3;

//        double x =  2.00000;
//        int n = -4;

//        double x = -2.00000;
//        int n = 2;

//        double x = 0.44894;
//        int n = -5;

//        double x =  1.00000;
//        int n = -2147483648;

//        double x = -1.00000;
//        int n = 2147483647;

        double x = 2.00000;
        int n = -2147483648;

        double result = myPow(x, n);
        System.out.println(result);
    }


    public static double myPow(double x, int n) {
        boolean isSymbolPositive = n >= 0 ? true : false;
        boolean isNumPositive = x >= 0 ? true : false;

        long newN = n;

        if(!isSymbolPositive){
            newN = -newN;
        }



        if(newN == 0){
            return 1.0;
        }

        if(!isNumPositive){
            x = -x;
        }

        double result = powFunc(x,newN);

        if(!isSymbolPositive){
            result = 1.0 / result;
        }

        if(n % 2 != 0 && !isNumPositive){
            result = - result;
        }

        return result;
    }

    public static double powFunc(double x,long n){
        if(n == 1){
            return x;
        }

        double result = powFunc(x, n / 2);

        result *= result;

        if(n % 2 == 1){
            result *= x;
        }

        return result;
    }

}
