package LCEveryDay;

// 示例 1：
//
// 输入: [[1,2], [1,3], [2,3]]
//输出: [2,3]
//解释: 给定的无向图为:
//  1
// / \
//2 - 3
//

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 示例 2：
//
// 输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
//输出: [1,4]
//解释: 给定的无向图为:
//5 - 1 - 2
//    |   |
//    4 - 3
public class P_684 {
    public static void main(String[] args) {

        int[][] edges = {
                {1,4},
                {3,4},
                {1,3},
                {1,2},
                {4,5}
        };
//
//        int[][] edges = {
//                {1,2},
//                {1,3},
//                {2,3}
//        };


//        int[][] edges = {
//                {1,2},
//                {2,3},
//                {3,4},
//                {1,4},
//                {1,5}
//        };


//        int[][] edges = {
//                {3,4},
//                {1,2},
//                {2,4},
//                {3,5},
//                {2,5}
//        };


        int[] resultList = findRedundantConnection(edges);
        for(int num : resultList){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // 如果两个数字在同一个集合中，直接返回
    // 如果两个数字分别在不同的集合中，合并两个集合
    // 如果一个数字有，另一个数字是新的，将这个数字加入到集合中
    public static int[] findRedundantConnection1(int[][] edges) {
        int num = edges.length;
        if(num == 0){
            return new int[2];
        }

        List<Set<Integer>> list = new ArrayList<>();

        for(int[] edge : edges){
            // 找到这两个数字对应的集合
            int x = -1;
            int y = -2;

            for(int i = 0;i < list.size();i++){
                Set<Integer> set = list.get(i);

                if(set.size() == 0){
                    continue;
                }
                if(set.contains(edge[0])){
                    x = i;
                }

                if(set.contains(edge[1])){
                    y = i;
                }

                if(x != -1 && y != -1){
                    break;
                }
            }

            if(x == -1 && y == -2){
                Set<Integer> set = new HashSet<>();
                set.add(edge[0]);
                set.add(edge[1]);
                list.add(set);
            }else if(x == -1 || y == -2){
                if(x == y){
                    int[] result = new int[2];
                    result[0] = x;
                    result[1] = y;
                    return result;
                }else{
                    // 大的向小的合并
                    if(x < y){
                        Set<Integer> toSet = list.get(x);
                        Set<Integer> fromSet = list.get(y);

                        fromSet.clear();
                        toSet.addAll(fromSet);
                    }else{
                        Set<Integer> toSet = list.get(y);
                        Set<Integer> fromSet = list.get(x);

                        fromSet.clear();
                        toSet.addAll(fromSet);
                    }
                }
            }
        }

        return new int[2];
    }


    public static int[] findRedundantConnection(int[][] edges) {
        int num = edges.length;
        if(num == 0){
            return new int[2];
        }

        // 先找出最大的节点，需要知道new的数组长度
        int max = 0;
        for(int[] edge : edges){
            int temp = Math.max(edge[0],edge[1]);
            max = Math.max(max,temp);
        }

        // 从1开始
        int[] arr = new int[max + 1];

        for(int i = 1;i <= max;i++){
            arr[i] = i;
        }

        for(int n = 0;n < num;n++){
            int[] edge = edges[n];
            int x = edge[0];
            int y = edge[1];

            if(find(arr,x) == find(arr,y)){
                return edge;
            }else{
                union(arr,x,y);
            }
        }

        return new int[2];
    }

    public static int find(int[] nums,int x){
        if(nums[x] != x){
            nums[x] = find(nums,nums[x]);
        }

        return nums[x];
    }

    // 后者合并到前者上
    public static void union(int[] nums,int x,int y){
        if(find(nums,x) != find(nums,y)){
            nums[find(nums,y)] = find(nums,x);
        }
    }


}
