package LCEveryDay;

public class P_1423 {
    public static void main(String[] args) {
//        int[] cardPoints = {1,2,3,4,5,6,1};
//        int k = 3;

//        int[] cardPoints = {2,2,2};
//        int k = 2;

//        int[] cardPoints = {9,7,7,9,7,7,9};
//        int k = 7;

//        int[] cardPoints = {1,1000,1};
//        int k = 1;

        int[] cardPoints = {1,79,80,1,1,1,200,1};
        int k = 3;

        int result = maxScore(cardPoints, k);
        System.out.println(result);
    }

    // 1.滑动窗口，因为是对数组的左右两端取数，可以转化为在数组内部，窗口表示的是 不需要的数字
    public static int maxScore(int[] cardPoints, int k) {
        int length = cardPoints.length;

        // 窗口大小
        int windows = length - k;

        int left = 0;
        int right = windows;

        int sumVal = 0;
        int resultVal = 0;

        // 先将窗口初始化
        for(int i = 0;i < windows;i++){
            sumVal += cardPoints[i];
        }

        resultVal = sumVal;

        while(left < k){
            sumVal -= cardPoints[left++];
            sumVal += cardPoints[right++];

            resultVal = Math.min(resultVal,sumVal);
        }

        int sum = 0;
        for(int num : cardPoints){
            sum += num;
        }

        return sum - resultVal;
    }




    // 可以用二维DP试试【dp应该没法做，因为无法正确维护left,right指针】
    public static int maxScore1(int[] cardPoints, int k) {
        int length = cardPoints.length;

        // dpArr[i][0] 表示第i次从头部取，dpArr[i][1]表示第i次从尾部取
        int[][] dpArr = new int[k][2];

//        int left = 0;
//        int right = length - 1;

        // 当上一轮选的是头部
        int first_left = 0;
        int first_right = length - 1;

        // 当上一轮选的是尾部
        int sec_left = 0;
        int sec_right = length - 1;

        dpArr[0][0] = cardPoints[first_left++];
        dpArr[0][1] = cardPoints[sec_right--];

        for(int i = 1;i < k;i++){
            // 从头部取
//            dpArr[i][0] = Math.max(dpArr[i - 1][0],dpArr[i - 1][1]) + cardPoints[left++];

            if(dpArr[i - 1][0] > dpArr[i - 1][1]){
                dpArr[i][0] = dpArr[i - 1][0] + cardPoints[first_left++];
            }else{
                dpArr[i][0] = dpArr[i - 1][1] + cardPoints[sec_left++];
            }

            // 从尾部取
//            dpArr[i][1] = Math.max(dpArr[i - 1][0],dpArr[i - 1][1]) + cardPoints[right--];

            if(dpArr[i][0] > dpArr[i][1]){
                dpArr[i][1] = dpArr[i - 1][0] + cardPoints[sec_right--];
            }else{
                dpArr[i][1] = dpArr[i - 1][1] + cardPoints[first_right--];
            }

        }

        return Math.max(dpArr[k - 1][0],dpArr[k - 1][1]);
    }
}
