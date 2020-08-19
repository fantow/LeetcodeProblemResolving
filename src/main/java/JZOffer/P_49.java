package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_49 {
    public static void main(String[] args) {

        int n = 10;
        int result = nthUglyNumber(n);

        System.out.println(result);
    }

    public static int nthUglyNumber(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        int[] dpArr = new int[n];
        dpArr[0] = 1;
        int a = 0;
        int b = 0;
        int c = 0;
        int idx = 1;
        while(idx < n){
            int aValue = dpArr[a] * 2;
            int bValue = dpArr[b] * 3;
            int cValue = dpArr[c] * 5;

            // 相等时会被后面的数覆盖是，所以不影响
            dpArr[idx] = Math.min(aValue,Math.min(bValue,cValue));
            if(dpArr[idx] == aValue){
                a++;
            }
            if(dpArr[idx] == bValue){
                b++;
            }
            if(dpArr[idx] == cValue){
                c++;
            }

            idx++;
        }

        return dpArr[n - 1];
    }



}
