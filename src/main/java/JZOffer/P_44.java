package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_44 {
    ;
    public static void main(String[] args) {

        int n = 1000000000;
        int result = findNthDigit(n);
        System.out.println(result);
    }


    public static int findNthDigit(int n) {
        long start = 1;
        int digit = 1;
        long count = 9;

        while(n > count){
            start *= 10;
            digit += 1;

            n -= count;

            count = 9 * start * digit;
        }

        long num = start + (n - 1) / digit;

        // 比如 4 % 1 = 0
        int result = Long.toString(num).charAt((n - 1) % digit) - '0';
        return result;
    }
}
