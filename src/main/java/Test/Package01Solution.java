package Test;

import java.util.Scanner;

public class Package01Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int v = scanner.nextInt();

        int[] values = new int[n + 1];
        int[] volumes = new int[n + 1];

        // 获取数值
        for(int i = 1;i <= n;i++){
            volumes[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }

        // 01背包需要一个二维数组
        int[][] dpArr = new int[n + 1][v + 1];

        // 对dp初始化


        // 转移方程：dpArr[i][j] 表示遍历到第i个物品，体积为j时的最大价值
        for(int i = 1;i <= n;i++){
            for(int j = 0;j <= v;j++){
                // 不选i
                dpArr[i][j] = dpArr[i - 1][j];
                if(j >= volumes[i]){
                    dpArr[i][j] = Math.max(dpArr[i][j],dpArr[i - 1][j - volumes[i]] + values[i]);
                }
            }
        }


//        for(int row = 0;row <= n;row++){
//            for(int col = 0;col <= v;col++){
//                System.out.print(dpArr[row][col] + " ");
//            }
//            System.out.println();
//        }

        int maxVal = 0;

        for(int j = 0;j <= v;j++){
            maxVal = Math.max(maxVal,dpArr[n][j]);
        }

        System.out.println(maxVal);
    }
}
