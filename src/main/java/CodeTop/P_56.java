package CodeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P_56 {
    public static void main(String[] args) {

//        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals = {{1,4},{4,5}};
//        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] merge = merge(intervals);

        for(int[] arr : merge){
            for(int num : arr){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;

        // 按第二个元素进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        int left = intervals[0][0];
        int right = intervals[0][1];

        List<int[]> list = new ArrayList<>();

        for(int i = 1;i <= length - 1;i++){
            // 因为已经按right排好序了，所以不用再考虑right > < = intervals[i]的问题了
            if(left > intervals[i][1]){
                int[] arr = new int[2];
                arr[0] = left;
                arr[1] = right;
                list.add(arr);

                left = intervals[i][0];
                right = intervals[i][1];
            }else {
                left = Math.min(left,intervals[i][0]);
            }
        }

        int[] arr = new int[2];
        arr[0] = left;
        arr[1] = right;
        list.add(arr);

        int[][] res = new int[list.size()][2];

        for(int i = 0;i < list.size();i++){
            res[i] = list.get(i);
        }

        return res;
    }
}
