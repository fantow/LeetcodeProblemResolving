package LCEveryDay;

import java.util.*;

public class P_1584 {
    public static void main(String[] args) {
//        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
//        int[][] points = {{3,12},{-2,5},{-4,1}};
        int[][] points = {{0,0},{1,1},{1,0},{-1,1}};
        int result = minCostConnectPoints(points);
        System.out.println(result);
    }

    // 克鲁斯卡尔算法
    public static int minCostConnectPoints(int[][] points) {
        int nums = points.length;

        List<Edge> edgeList = new ArrayList<>();

        // 并查集用
        int[] arr = new int[nums];

        for(int i = 0;i < nums;i++){
            arr[i] = i;
        }

        // 先计算出每条边的长度，再按照这个长度排序
        for(int i = 0;i < nums;i++){
            int[] point = points[i];

            for(int j = i + 1;j < nums;j++){
                int[] point2 = points[j];
                int len = calc(point, point2);
                Edge edge = new Edge(len,i,j);
                edgeList.add(edge);
            }
        }

        // 再对Edge排序
        Collections.sort(edgeList, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.len - o2.len;
            }
        });

        int resultLen = 0;

        for(int i = 0;i < edgeList.size();i++){
            Edge edge = edgeList.get(i);

            int len = edge.len;
            int point1Idx = edge.point1;
            int point2Idx = edge.point2;

            if(find(arr,point1Idx) != find(arr,point2Idx)){
                union(arr,point1Idx,point2Idx);
                resultLen += len;
            }
        }

        return resultLen;
    }

    // 传入的是该点在arr中的下标
    public static int find(int[] arr,int x){
        if(x != arr[x]){
            arr[x] = find(arr,arr[x]);
        }

        return arr[x];
    }

    public static void union(int[] arr,int x,int y){
        int rootx = find(arr,x);
        int rooty = find(arr,y);

        if(rootx != rooty){
            arr[rooty] = rootx;
        }
    }

    static class Edge{
        // 边长
        int len;
        int point1;
        int point2;

        public Edge(int len, int point1, int point2) {
            this.len = len;
            this.point1 = point1;
            this.point2 = point2;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "len=" + len +
                    ", point1=" + point1 +
                    ", point2=" + point2 +
                    '}';
        }
    }

    public static int calc(int[] point1,int[] point2){
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    // 尝试贪心，每次只选离这个点最近的点
    public static int minCostConnectPoints1(int[][] points) {
        int nums = points.length;

        int distinct = 0;

        for(int i = 0;i < nums;i++){
            int[] point = points[i];

            int temp = Integer.MAX_VALUE;
            for(int j = 0;j < nums;j++){
                if(i == j){
                    continue;
                }

                int dis = calc(point,points[j]);
                temp = Math.min(dis,temp);
            }
            distinct += temp;
        }

        return distinct;
    }



}
