package Hot100;

import java.util.Arrays;

public class P_621 {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;

        int result = leastInterval(tasks, n);
        System.out.println(result);
    }

    public static int leastInterval(char[] tasks, int n) {
        int length = tasks.length;

        if(length == 0){
            return 0;
        }

        if(length == 1){
            return 1;
        }

        int[] countArr = new int[26];

        for(char ch : tasks){
            countArr[ch - 'A']++;
        }

        int max = Integer.MIN_VALUE;

        //  获取到最大值
        for(int num : countArr){
            max = Math.max(num,max);
        }

        // 找到maxCount
        int maxCount = 0;

        for(int num : countArr){
            if(max == num){
                maxCount++;
            }
        }

        return Math.max((max - 1)* (n+1) + maxCount ,tasks.length);
    }



    public static int leastInterval1(char[] tasks, int n) {
        int length = tasks.length;
        if(length == 0){
            return 0;
        }

        if(length == 1){
            return 1;
        }

        int[] countArr = new int[26];

        // 对任务出现次数排序
        for(char ch : tasks){
            countArr[ch - 'A']++;
        }

        int count = length;
        int leastTime = 0;

        // 其实任务从哪个开始应该都不会影响最短结果
        while(count > 0){

            int startIdx = Integer.MIN_VALUE;
            int endIdx = Integer.MIN_VALUE;
            for(int j = 0;j < 26;j++){
                if(countArr[j] != 0){
                    if(startIdx == Integer.MIN_VALUE){
                        startIdx = j;
                    }
                    leastTime++;
                    count--;
                    countArr[j]--;
                    endIdx = j;
                }
            }

            int rowLength = endIdx - startIdx + 1;

            if(rowLength < n + 1 && count > 0){
                leastTime += (n + 1 -rowLength);
            }
        }

        return leastTime;
    }
}
