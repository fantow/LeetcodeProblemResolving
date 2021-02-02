package LCEveryDay;

import java.util.PriorityQueue;

public class P_424 {
    public static void main(String[] args) {
//        String s = "ABAB";
//        int k = 2;

//        String s = "AABABBA";
//        int k = 1;

        String s = "AAAA";
        int k = 2;

        int result = characterReplacement(s, k);
        System.out.println(result);
    }

    // 采用滑动窗口，并且需要维护一个结构用于记录当前窗口中的元素和个数，如果当前窗口中
    // 窗口大小 - 窗口中重复元素最多的个数 < k ，则窗口扩展
    public static int characterReplacement(String s, int k) {
        int length = s.length();

        int left = 0;
        int right = 0;

        int[] countArr = new int[26];

        if(k >= length){
            return length;
        }

        // 窗口最大长度
        int maxVal = 0;

        while(right < length){
            countArr[s.charAt(right) - 'A']++;

//            for(int num : countArr){
//                System.out.print(num + " ");
//            }
//            System.out.println();

            int currentWindows = right - left + 1;

            // 如果当前窗口的出现最多的元素 + k >= 当前窗口大小，就继续扩大窗口；否则，left++，并且需要删除
            // 出队元素
            if(countArr[getMostNum(countArr)] + k < currentWindows){
                countArr[s.charAt(left) - 'A']--;
                left++;
            }
            maxVal = Math.max(maxVal,countArr[getMostNum(countArr)] + k);
            right++;
        }

        return maxVal > length ? length : maxVal;
    }

    // 获取最大值的下标
    public static int getMostNum(int[] countArr){
        int maxIdx = 0;
        for(int i = 0;i < countArr.length;i++){
            if(countArr[maxIdx] < countArr[i]){
                maxIdx = i;
            }
        }
        return maxIdx;
    }

//    static class Pair{
//        // 元素值
//        int val;
//        // 出现次数
//        int count;
//
//        public Pair(int val, int count) {
//            this.val = val;
//            this.count = count;
//        }
//    }
}
