package Hot100;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;

public class P_312 {
    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        int result = maxCoins(nums);

        System.out.println(result);
    }

    public static int maxCoins(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        int[][] dpArr = new int[length + 2][length + 2];
        int[] newNums = new int[length + 2];

        newNums[0] = 1;
        newNums[length + 1] = 1;

        for(int i = 1;i <= length;i++){
            newNums[i] = nums[i - 1];
        }

        // dp[i][j] = max(dp[i][k] + dp[k][j] + nums[k - 1] * nums[k] * nums[k + 1]);
        // 需要注意推导顺序，应该先列后行
        for(int i = length - 1;i >= 0;i--){
            for(int j = i + 2;j <= length + 1;j++){
                for(int k = i + 1;k < j;k++){
//                    int tempVal = newNums[k - 1] * newNums[k] * newNums[k + 1];
                    int tempVal = newNums[k] * newNums[i] * newNums[j];
                    tempVal += dpArr[i][k] + dpArr[k][j];
                    dpArr[i][j] = Math.max(dpArr[i][j],tempVal);
                }

                for(int[] arr : dpArr){
                    for(int a : arr){
                        System.out.print(a + " ");
                    }
                    System.out.println();
                }
                System.out.println("========");
            }
        }

        return dpArr[0][length + 1];
    }




    // 可以使用回溯法
    public static int maxCoins1(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        int maxCount = 0;

        boolean[] isVisited = new boolean[length];

        int visitedCount = 1;
        for(int i = 0;i < length;i++){
            int tempCount = DfsFunc(nums,isVisited,i,visitedCount);
//            System.out.println(tempCount);
//            System.out.println("===================");
            maxCount = Math.max(maxCount,tempCount);
        }

        return maxCount;
    }

    public static int dfs(int[] nums,boolean[] isVisited,int index,int visitedCount){
        int length = nums.length;
        if(visitedCount > length){
            System.out.println(123);
            return 0;
        }

        isVisited[index] = true;
        System.out.println(nums[index]);

        for(int i = 0;i < length;i++){
            if(isVisited[i] != true){
                dfs(nums,isVisited,i,visitedCount + 1);
            }
        }
//        dfs();

        isVisited[index] = false;

        return 0;
    }


    // visitedCount表示当前已经访问过的节点数
    public static int DfsFunc(int[] nums,boolean[] isVisited,int index,int visitedCount){
        int length = nums.length;

        if(visitedCount == length){
            return 0;
        }

        isVisited[index] = true;

        int tempValue = nums[index];
        // 如果有左右值/如果没有左右值

        // 找到左边第一个未被访问的点
        int leftOffset = 1;
        int leftValue = 0;
        while(index - leftOffset >= 0 && isVisited[index - leftOffset] != false){
            leftOffset++;
        }

        if(index - leftOffset < 0){
            leftValue = 1;
        }else{
            leftValue = nums[index - leftOffset];
        }
//        tempValue *= leftValue;

        // 找到右边第一个未被访问到的点
        int rightOffset = 1;
        int rightValue = 0;
        while(index + rightOffset < length  && isVisited[index + rightOffset] != false){
            rightOffset++;
        }

        if(index + rightOffset >= length){
            rightValue = 1;
        }else{
            rightValue = nums[index + rightOffset];
        }
        tempValue = leftValue * rightValue * tempValue;

        int maxCount = 0;
        boolean flag = false;
        for(int i = 0;i < length;i++){
            flag = true;
            int tempCount = tempValue;
            if(isVisited[i] != true){
                tempCount += DfsFunc(nums,isVisited,i,visitedCount + 1);
            }

            maxCount = Math.max(maxCount,tempCount);
        }

        isVisited[index] = false;

        return flag == true ? maxCount : tempValue;
    }

}
