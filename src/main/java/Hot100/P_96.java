package Hot100;

public class P_96 {
    public static void main(String[] args) {
        int n = 4;
        int result = numTrees(n);

        System.out.println(result);
    }


    // 应该是用回溯法
    public static int numTrees(int n) {
        if(n <= 2){
            return n;
        }

        // 感觉是全排列后去重
        // 如果当前root的值在x下标，那么递归时1~x-1的和x+1~n的即使交换顺序，得到的结果也是一样的
        boolean[] isVisited = new boolean[n + 1];
        int[] dpArr = new int[n + 1];

        // 初始化
        dpArr[0] = 1;
        dpArr[1] = 1;
        dpArr[2] = 2;
        dpArr[3] = 5;

        // 可以使用DP推导：
        // dp[i] ，1个节点做root，左可能有0~i-1个节点，右就会有 (i-1) - 左个数 个节点，可能性相加
        for(int i = 3;i <= n;i++){
            // 当有i个节点时，那么它的子节点有i-1个
            int count = 0;
            for(int leftCount = 0;leftCount <= i - 1;leftCount++){
                count += (dpArr[leftCount] * dpArr[i - 1 - leftCount]);
            }
            dpArr[i] = count;
        }

        return dpArr[n];
    }




}
