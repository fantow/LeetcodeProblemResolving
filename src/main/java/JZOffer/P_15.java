package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_15 {
    public static void main(String[] args) {
        int n = -11;
        int result = hammingWeight1(n);

        System.out.println(result);
    }

    // 负数二进制在计算机中存储方式：取反 + 1
    // 方法1.采用右移
    public static int hammingWeight1(int n) {
        int count = 0;
        while(n != 0){
            if((n & 1) == 1){
                count++;
            }
            // 无符号右移
            n >>>= 1;
        }

        return count;
    }


    // 方法2.采用n&(n - 1)
    public static int hammingWeight2(int n){
        int count = 0;
        while(n != 0){
            count++;
            n &= n - 1;
        }

        return count;
    }
}
