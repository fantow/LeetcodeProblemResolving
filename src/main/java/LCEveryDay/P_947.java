package LCEveryDay;

import java.util.HashSet;
import java.util.Set;

public class P_947 {
    public static void main(String[] args) {
//        int[][] stones = {
//                {0,0},{0,1},{1,0},{1,2},{2,1},{2,2}
//        };

//        int[][] stones = {
//                {0,0},{0,2},{1,1},{2,0},{2,2}
//        };

        int[][] stones = {{0,0}};

        int result = removeStones(stones);
        System.out.println(result);
    }

    public static int removeStones(int[][] stones) {
        int nums = stones.length;
        if(nums <= 1){
            return 0;
        }

        int[] arr = new int[nums];

        for(int i = 0;i < nums;i++){
            arr[i] = i;
        }

        for(int i = 0;i < nums;i++){
            int[] stoneTo = stones[i];
            for(int j = i + 1;j < nums;j++){
                int[] stoneFrom = stones[j];
                if(stoneFrom[0] == stoneTo[0] || stoneFrom[1] == stoneTo[1]){
                    union(arr,i,j);
                }
            }
        }

        for(int i = 0;i < nums;i++){
            arr[i] = find(arr,i);
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < nums;i++){
            set.add(arr[i]);
        }

        return nums - set.size();
    }

    public static int find(int[] arr,int x){
        if(arr[x] != x){
            arr[x] = find(arr,arr[x]);
        }
        return arr[x];
    }

    public static void union(int[] arr,int to,int from){
        int rootTo = find(arr,to);
        int rootFrom = find(arr,from);

        if(rootTo != rootFrom){
           arr[rootFrom] = rootTo;
        }
    }


}
