package Test;
import java.util.*;

public class P_002 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 读取队员个数K
//        int k = 2;
        int k = scanner.nextInt();

        int p = scanner.nextInt();

        // 读取比赛次数
        int[] n = new int[p];
        for(int i = 0;i < p;i++){
            n[i] = scanner.nextInt();
        }

        int[][] time = new int[k][p];

        for(int i = 0;i < k;i++){
            for(int j = 0;j < p;j++){
                time[i][j] = scanner.nextInt();
            }
        }

        int minVal = Integer.MAX_VALUE;

        // 需要根据比赛项目数进行排序
        int length = n.length;

        for(int t = 0;t < length;t++){
            // 每次都要读取各个队员的比赛时间，再进行排序
            int[] temp = new int[k];

            for(int i = 0;i < k;i++){
                // 第i个人的第t项目所用时间
                temp[i] = time[i][t];
            }

            Arrays.sort(temp);

            // 进行比赛次数和队员个数的判断

            // 如果比赛次数 <= 队员数 --> 一轮结束
            if(n[t] <= k){
                minVal = Math.min(minVal,temp[n[t] - 1]);
            }else{
                // 如果比赛次数 > 队员数 --> 需要多轮
                // (比赛次数 / 队员数) * 该项目最长耗时 + temp[(比赛次数 % 队员数)]
                if((n[t] % k) == 0){
                    // 如果可以整除
                    minVal = Math.min(minVal,(n[t] / k) * temp[temp.length - 1]);
                }else{
                    // 如果不可以整除
                    minVal = Math.min(minVal,(n[t] / k) * temp[temp.length - 1] + temp[n[t] % k - 1]);
                }
            }
        }

        System.out.println(minVal);
    }
}
