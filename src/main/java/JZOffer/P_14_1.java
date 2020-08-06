package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_14_1 {
    public static void main(String[] args) {
        int n = 2;
        int i = cuttingRope(n);

        System.out.println(i);
    }

    public static int cuttingRope(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }

        int count3 = n / 3;
        int mod = n % 3;

        if(mod == 0){
            return 3 * count3;
        }else if(mod == 1){
            // 退一个3，去凑4
            return (int)Math.pow(3,count3 - 1) * 4;
        }else if(mod == 2){
            // 退一个3，去凑5
            return (int)Math.pow(3,count3 - 1) * 6;
        }

        return -1;
    }
}
