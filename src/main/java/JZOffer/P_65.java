package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_65 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int result = add(a, b);

        System.out.println(result);
    }

    public static int add(int a, int b) {
        int sum = 0;
        int carry = 0;

        do{
            sum = a ^ b;
            carry = (a & b) << 1;

            a = sum;
            b= carry;
        }while(carry != 0);

        return sum;
    }
}
