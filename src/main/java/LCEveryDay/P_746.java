package LCEveryDay;

public class P_746 {
    public static void main(String[] args) {
//        int[] cost = {10,15,20};
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int result = minCostClimbingStairs(cost);

        System.out.println(result);
    }

    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        // 题目说了cost长度会在2~1000，所以这里不判<=1的情况了


        // dpArr[i]表示到达第i个台阶，需要耗费的体力。
        // 递推公式：dp[i] = Min(dp[i - 1],dp[i - 2]) + cost[i];
        int[] dpArr = new int[length + 2];

        // 对dp初始化
        dpArr[0] = 0;
        dpArr[1] = cost[0];
        dpArr[2] = Math.min(dpArr[0],dpArr[1]) + cost[1];

        // dp[i] = Min(dp[i - 1],dp[i - 2]) + cost[i]
        for(int i = 3;i <= length + 1;i++){
            if(i == length + 1){
                dpArr[i] = Math.min(dpArr[i - 1],dpArr[i - 2]) + 0;
            }else{
                dpArr[i] = Math.min(dpArr[i - 1],dpArr[i - 2]) + cost[i - 1];
            }
        }

//        for(int num : dpArr){
//            System.out.print(num + " ");
//        }

        return dpArr[length + 1];
    }
}
