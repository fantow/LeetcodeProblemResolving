package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P_56 {
    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals = {{1,4},{4,5}};
        int[][] ints = merge(intervals);

        for(int[] num : ints){
            for(int i = 0;i < num.length;i++){
                System.out.print(num[i] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if(length == 0){
            return null;
        }

        if(length == 1){
            return intervals;
        }

        List<int[]> resultList = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] < o2[1] ? -1 : 1;
                }else{
                    return o1[0] < o2[0] ? -1 : 1;
                }
            }
        });

        int left = intervals[0][0];
        int right = intervals[0][1];

        for(int i = 1;i < length;i++){
            if(right >= intervals[i][0]){
                right = Math.max(right,intervals[i][1]);
            }else{
                // 将当前结果记录，并更新left，right
                int[] arr = new int[2];
                arr[0] = left;
                arr[1] = right;
                resultList.add(arr);

                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        int[] arr = new int[2];
        arr[0] = left;
        arr[1] = right;
        resultList.add(arr);

        int size = resultList.size();
        int[][] resultArr = new int[size][2];

        for(int i = 0;i < size;i++){
            resultArr[i] = resultList.get(i);
        }

        return resultArr;
    }
}
