package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_64 {
    public static void main(String[] args) {
        int n = 3;
        int result = sumNums(n);

        System.out.println(resultTemp);
    }

    public static int resultTemp = 0;
    public static int sumNums(int n) {
        boolean flag = n >= 1 && sumNums(n - 1) > 0;
        resultTemp += n;
        return resultTemp;
    }
}
