package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_14_2 {

    public static long[] arr;

    public static void main(String[] args) {
        int n = 211;
        long result1 = cuttingRope1(n);

        System.out.println(result1);
    }

    // 方法1.贪心算法
    public static int cuttingRope1(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }

        int count = n / 3;
        int mod = n % 3;

        if(mod == 0){
            return (int)getMod2(3,count,1000000007);
        }else if(mod == 1){
            return (int)((getMod2(3,count - 1,1000000007) * 4) % 1000000007);
        }else if(mod == 2){
            return (int)((getMod2(3,count - 1,1000000007) * 6) % 1000000007);
        }
        return -1;
    }

    // 大数求余算法1:循环求余
    public static long getMod1(int x,int a,int p){
        long result = 1;

        for(int i = 1;i <= a;i++){
            result = (result * x) % p;
        }

        return result;
    }

    // 大数求余算法2:快速幂求余。
    public static long getMod2(long x,int a,int p){
        long result = 1;
        while (a > 0){
            if(a % 2 == 1){
                result = (result * x) % p;
            }
            x = x * x % p;
            a /= 2;
        }
        return result;
    }

}
