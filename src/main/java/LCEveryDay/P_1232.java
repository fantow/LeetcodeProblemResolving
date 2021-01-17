package LCEveryDay;

public class P_1232 {
    public static void main(String[] args) {
//        int[][] coordinates = {
//                {1,2},{2,3},{3,4},{4,5},{5,6}
//        };

//        int[][] coordinates = {
//                {1,1},{2,2},{3,4},{4,5},{5,6},{7,7}
//        };

        int[][] coordinates = {
                {0,0},{0,1},{0,-1}
        };

        boolean result = checkStraightLine(coordinates);

        System.out.println(result);
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int nums = coordinates.length;
        if(nums <= 2){
            return true;
        }

        // 先计算直线的斜率和b
        double x1 = coordinates[0][0];
        double y1 = coordinates[0][1];

        double x2 = coordinates[1][0];
        double y2 = coordinates[1][1];


        // 题目保证了不含重复点
        if(x1 == x2){
            for(int i = 2;i < nums;i++){
                if(coordinates[i][0] != x1){
                    return false;
                }
            }
        }else {

            double k = x1 == x2 ? 1 : (y1 - y2) / (x1 - x2);
            double b = x1 == x2 ? 0 : y1 - k * x1;

            for (int i = 2; i < nums; i++) {
                int[] pair = coordinates[i];

                double x = pair[0];
                double y = pair[1];

                if (y != k * x + b) {
                    return false;
                }
            }
        }
        return true;
    }
}
