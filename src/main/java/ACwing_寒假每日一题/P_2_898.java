package ACwing_寒假每日一题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 应该是一道回溯问题
public class P_2_898 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] arr = new int[510][510];
        // 三角形行数
        int n = scanner.nextInt();

        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= i;j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        int[][] count = new int[510][510];

        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= i + 1;j++){
                count[i][j] = arr[i][j] + Math.max(count[i - 1][j], count[i - 1][j + 1]);
            }
        }

        int max = 0;
        for(int i = 0;i <= n;i++){
            max = Math.max(max,count[n][i]);
        }

        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= i;j++){
                System.out.print(count[i][j] + " ");
            }
            System.out.println();
        }


        System.out.println(max);

    }
}
