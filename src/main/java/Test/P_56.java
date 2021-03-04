package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P_56 {
    public static void main(String[] args) {
//        int[][] intervals = {
//            {1,3},{2,6},{8,10},{15,18}
//        };

//        int[][] intervals = {
//                {1,4},{4,5}
//        };

        int[][] intervals = {
                {1,4},{2,3}
        };

        int[][] resultArr = merge(intervals);

        for(int[] num : resultArr){
            System.out.println(num[0] + " -> " + num[1]);
        }
    }

    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;

        if(length == 0){
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();

        int left = intervals[0][0];
        int right = intervals[0][1];

        for(int i = 1;i < length;i++){
            int[] point = intervals[i];
            // 融合
            if(point[0] <= right){
                right = point[1] > right ? point[1] : right;
            }else{
                // 单独分开
                // 写入list中
                int[] arr = new int[2];
                arr[0] = left;
                arr[1] = right;

                list.add(arr);

                left = point[0];
                right = point[1];
            }
        }

        // 还可能涉及到最后的判断
        int[] arr = new int[2];
        arr[0] = left;
        arr[1] = right;
        list.add(arr);

        int[][] resultArr = new int[list.size()][2];

        for(int i = 0;i < list.size();i++){
            resultArr[i] = list.get(i);
        }

        return resultArr;
    }
}
