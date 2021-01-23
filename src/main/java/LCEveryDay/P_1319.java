package LCEveryDay;

import java.util.HashSet;
import java.util.Set;

public class P_1319 {
    public static void main(String[] args) {
//        int[][] connections = {{0,1},{0,2},{1,2}};
//        int n = 4;

//        int[][] connections = {{0,1},{0,2},{0,3},{1,2}};
//        int n = 6;

//        int[][] connections = {{0,1},{0,2},{3,4},{2,3}};
//        int n = 5;

        int[][] connections = {};
        int n = 2;

        int result = makeConnected(n, connections);
        System.out.println();
        System.out.println(result);
    }

    // 应该是使用并查集
    public static int makeConnected(int n, int[][] connections) {
        int nums = connections.length;
        if(nums == 0){
            if(n == 0){
                return 0;
            }else{
                return -1;
            }
        }

        int[] arr = new int[n];
        for(int i = 0;i < arr.length;i++){
            arr[i] = i;
        }

        int dumpConnection = 0;
        for(int i = 0;i < nums;i++){
            int[] edge = connections[i];

            int x = edge[0];
            int y = edge[1];

            if(find(arr,x) == find(arr,y)){
                // 获取有多少条重复连接线
                dumpConnection++;
            }else{
                union(arr,x,y);
            }
        }

        for(int i = 0;i < arr.length;i++){
            arr[i] = find(arr,i);
//            System.out.print(arr[i] + " ");
        }

        // 根据目前的arr计算出有多少个不连通的区域(有多少个不同的祖先)
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < arr.length;i++){
            if(!set.contains(arr[i])){
                set.add(arr[i]);
            }
        }

        if(set.size() - 1 <= dumpConnection){
            return set.size() - 1;
        }

        return -1;
    }

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
        return ;
    }

}
