package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_43 {
    public static void main(String[] args) {
        int n = 12;
        int count = countDigitOne(n);

        System.out.println(count);
    }

    // 每轮只计算某位i，出现1的次数
    // digit = 0 --> high * pow(10,i)
    // digit = 1 --> high * pow(10,i) + low + 1
    // digit != 0 && digit != 1 --> (high + 1) * pow(10,i)
    public static int countDigitOne(int n) {
        int digit = 1;
        int count = 0;
        int high = n / 10;
        int low = 0;
        int current = n % 10;
        // 两个不能同时等于0，保证个位数用例也能通过
        while(high != 0 || current != 0){
            if(current == 0){
                count += high * digit;
            }else if(current == 1){
                count += high * digit + low + 1;
            }else{
                count += (high + 1) * digit;
            }
            low += current * digit;
            current = high % 10;
            high /= 10;
            digit *= 10;
        }

        return count;
    }
}
