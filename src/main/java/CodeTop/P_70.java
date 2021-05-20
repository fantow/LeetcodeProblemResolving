package CodeTop;

public class P_70 {
    public static void main(String[] args) {

//        int n = 2;
        int n = 3;
        int res = climbStairs(n);

        System.out.println(res);
    }

    // 一次可以爬1或2个台阶
    public static int climbStairs(int n) {
        int length = n;

        int[] dpArr = new int[length + 1];

        dpArr[0] = 1;
        dpArr[1] = 1;

        // 转移方程: dpArr[i] = dpArr[i - 1] + dpArr[i - 2];
        for(int i = 2;i <= length;i++){
            dpArr[i] = dpArr[i - 1] + dpArr[i - 2];
        }

        return dpArr[length];
    }
}
