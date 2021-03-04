package Test;

import java.util.Arrays;
import java.util.Comparator;

public class P_452 {
    public static void main(String[] args) {
        int[][] points = {
                {10,16},{2,8},{1,6},{7,12}
        };

        int result = findMinArrowShots(points);
        System.out.println(result);
    }

    // 右排序方式
    public static int findMinArrowShots(int[][] points) {
        int length = points.length;
        if(length == 0){
            return 0;
        }

        // 这一解先用右排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] > o2[1]){
                    return 1;
                }else if(o1[1] < o2[1]){
                    return -1;
                }else{
                    return 0;
                }
            }
        });

        int pre = points[0][1];
        int count = 1;

        for(int i = 1;i < length;i++){
            if(points[i][0] > pre){
                count++;
                pre = points[i][1];
            }
        }

        return count;
    }
}
