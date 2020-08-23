package JZOffer;

import java.util.Arrays;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_60 {
    public static void main(String[] args) {
        int n = 2;
        double[] resultArr = twoSum(n);

        for(double num : resultArr){
            System.out.print(num + " ");
        }

    }

    // 题目限制了 1 <= n <= 11
    public static double[] twoSum(int n) {
        // 这个矩阵，使用col = 1表示1点数，使用row = 1表示 n = 1
        double[][] dpArr = new double[n + 1][n * 6 + 1];

        // 对 n = 1 进行初始化
        for(int i = 1;i <= 6;i++){
            // 这里不要一开始就初始化为0.6667，容易因为小数点保留问题损失精度
            dpArr[1][i] = 1.0 / 6.0;
        }

        for(int i = 2;i <= n;i++){
            for(int j = 2;j <= i * 6;j++){
                // 组成dp[i][j] 的可能有多种方式
                for(int k = 1;k <= 6 && j - k >= 1;k++) {
                    dpArr[i][j] += dpArr[i - 1][j - k] * dpArr[1][k];
                }
            }
        }

        double[] result = Arrays.copyOfRange(dpArr[n], n, n * 6 + 1);

        return result;
    }
}
