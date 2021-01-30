package LCEveryDay;

import java.util.*;

public class P_1631 {
    public static void main(String[] args) {
//        int[][] heights = {
//            {1,2,2},
//            {3,8,2},
//            {5,3,5}
//        };

//        int[][] heights = {
//            {1,2,3},
//            {3,8,4},
//            {5,3,5}
//        };

//        int[][] heights = {
//                {1,2,1,1,1},
//                {1,2,1,2,1},
//                {1,2,1,2,1},
//                {1,2,1,2,1},
//                {1,1,1,2,1}
//        };

//        int[][] heights = {{3}};

        int[][] heights = {{7,9},{3,6},{6,9},{3,6}};

        int result = minimumEffortPath(heights);
        System.out.println(result);
    }

    // 使用DFS回溯报超时，这次使用并查集
    public static int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = 0;
        if(rows != 0){
            cols = heights[0].length;
        }

        // 构建并查集数组
        int[] arr = new int[rows * cols];

        // 初始化并查集数组
        for(int i = 0;i < rows * cols;i++){
            arr[i] = i;
        }

        List<Edge> list = new ArrayList<>();

        // 得到每个节点的边，并排序
        // todo:这里写的有点问题，最好将节点按照顺序编号，这样就可以使用一维表示节点了
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                int currentPoint = row * cols + col;

                // 与上一行节点连接成的边
                if(row - 1 >= 0){
                    int upPoint = (row - 1) * cols + col;
//                    System.out.println(currentPoint + " --> " + upPoint + " --> " + Math.abs(heights[row][col] - heights[row - 1][col]));
                    list.add(new Edge(upPoint,currentPoint,Math.abs(heights[row][col] - heights[row - 1][col])));
                }

                // 与左侧节点连接成的边
                if(col - 1 >= 0){
                    int rightPoint = row * cols + col - 1;
//                    System.out.println(currentPoint + " --> " + rightPoint + " --> " + Math.abs(heights[row][col] - heights[row][col - 1]));
                    list.add(new Edge(currentPoint,rightPoint,Math.abs(heights[row][col] - heights[row][col - 1])));
                }
            }
        }

        Collections.sort(list, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.val - o2.val;
            }
        });

        for(Edge edge : list){
            System.out.println("val:" + edge.val + " x:" + edge.x + " y:" + edge.y);
        }
        System.out.println();

        // 合并规则：将大的节点向小的节点合并
        for(Edge edge : list){
            int x = edge.x;
            int y = edge.y;

            if(x > y){
                int temp = x;
                x = y;
                y = temp;
            }

            if(find(arr,x) != find(arr,y)){
                union(arr,x,y);
            }

            // 表明最后一个节点已经与第一个节点合并
            if(find(arr,rows * cols - 1) == find(arr,0)){
                return edge.val;
            }

        }

        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();

        return 0;
    }

    public static int find(int[] arr,int x){
        if(x != arr[x]){
            arr[x] = find(arr,arr[x]);
        }

        return arr[x];
    }

    public static void union(int[] arr,int to,int from){
        int rootFrom = find(arr,from);
        int rootTo = find(arr,to);

        if(rootFrom != rootTo){
            arr[rootFrom] = rootTo;
        }

        return ;
    }

    static class Edge{
        int x;
        int y;
        int val;

        public Edge(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

}
