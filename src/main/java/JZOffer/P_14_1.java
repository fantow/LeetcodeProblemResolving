package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_14_1 {
    public static void main(String[] args) {
        int n = 10;
        int i = cuttingRope(n);

        System.out.println(i);
    }

    // 贪心算法，需要证明
    public static int cuttingRope1(int n) {
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

    // 动态规划
    public static int cuttingRope(int n){
        if(n == 2){
            return 1;
        }else if(n == 3){
            return 2;
        }

        int[] arr = new int[n + 1];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;

        int max = Integer.MIN_VALUE;
        for(int i = 4;i <= n;i++){
           for(int j = 1;j <= i/2;j++){
               int product = arr[j] * arr[i - j];
               if(max < product){
                   max = product;
               }
           }
           arr[i] = max;
        }
        return arr[n];
    }

}
