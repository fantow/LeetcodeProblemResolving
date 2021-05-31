package CodeTop;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_128 {
    public static void main(String[] args) {
//        int[] nums = {100,4,200,1,3,2};
        int[] nums = {0,3,7,2,5,8,4,6,0,1};

        int res = longestConsecutive(nums);
        System.out.println(res);
    }

    public static int longestConsecutive(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        // 用类似于并查集的方式
        int[] parent = new int[length];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < length;i++){
            parent[i] = i;
            map.put(nums[i],i);
        }

        for(int i = 0;i < length;i++){
            int target = nums[i];
            // 可以找到比它自己大1的节点
            if(map.containsKey(target + 1)){
                int parentIdx = find(parent,map.get(target + 1));
                union(parent,i,parentIdx);
            }
        }

        int max = 1;

        for(int i = 0;i < length;i++){
            if(parent[i] != i){
                max = Math.max(max,nums[find(parent,i)] - nums[i] + 1);
            }
        }

        return max;
    }

    public static int find(int[] parent,int idx){
        if(parent[idx] != idx){
            parent[idx] = find(parent,parent[idx]);
        }

        return parent[idx];
    }

    public static void union(int[] parent,int from,int to){
        parent[find(parent,from)] = find(parent,to);

        return ;
    }

}
