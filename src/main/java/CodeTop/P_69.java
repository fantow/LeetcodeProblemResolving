package CodeTop;

public class P_69 {
    public static void main(String[] args) {

//        int x = 2;
//        int x = 4;
//        int x = 8;
        int x = 2147395599;
        int res = mySqrt(x);

        System.out.println(res);
    }

    // 计算平方根，并且只返回整数部分
    public static int mySqrt(int x) {
        long left = 0;
        long right = x / 2 + 1;

        while (left < right){
            long mid = (left + right + 1) / 2;
            if(mid * mid <= x){
                left = mid;
            }else {
                right = mid - 1;
            }
        }

        return (int)left;
    }
}
