package LCEveryDay;

import java.util.Arrays;
import java.util.Comparator;

public class P_452 {
    public static void main(String[] args) {
//        int[][] points = {{1,2},{3,4},{5,6},{7,8}};
//        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
//        int[][] points = {{1,2},{2,3},{3,4},{4,5}};
//        int[][] points = {{1,2}};
//        int[][] points = {{2,3},{2,3}};
//        int[][] points = {{-2147483648,2147483647}};
//        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
//        int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        int result = findMinArrowShots(points);

        System.out.println(result);
    }

    public static int findMinArrowShots(int[][] points) {
        int length = points.length;
        if(length == 0){
            return 0;
        }

        // 使用左节点排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] < o2[1] ? -1 : 1;
                } else {
                    return o1[0] < o2[0] ? -1 : 1;

                }
            }
        });

        int left = points[0][0];
        int right = points[0][1];
        int count = 1;
        int min_right = right;

        for(int i = 1;i < length;i++){
            System.out.println("left:" + left + " right:" + right + " position_left: " + points[i][0] + " position_right: " + points[i][1]);
            if(right < points[i][0] || min_right < points[i][0]){
                count++;
                right = points[i][1];
                min_right = right;
            }else{
                min_right = Math.min(min_right,points[i][1]);
            }
        }

        return count;
    }
}
