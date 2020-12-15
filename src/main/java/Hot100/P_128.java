package Hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_128 {
    public static void main(String[] args) {
//        int[] nums = {100,4,200,1,3,2};
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};
//        int[] nums = {0,0,-1};
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};

        int result = longestConsecutive(nums);

        System.out.println(result);
    }

    public static int longestConsecutive(int[] nums) {
        int length = nums.length;
        if(length <= 1){
            return length;
        }


        Map<Integer,Integer> parent = new HashMap<>();
        // 初始化parent
        for(int num : nums){
            parent.put(num,num);
        }

        for(int num : nums){
            union(num,num + 1,parent);
            union(num - 1,num,parent);
        }

        int max = 1;
        for(int num : nums){
            max = Math.max(max,find(num,parent) - num + 1);
        }

        return max;
    }


    public static Integer find(int x,Map<Integer,Integer> parent){
        if(!parent.containsKey(x)){
            return null;
        }
        if(parent.get(x) != x){
            parent.put(x,find(parent.get(x),parent));
        }
        return parent.get(x);
    }

    public static void union(int x,int y,Map<Integer,Integer> parent){
        Integer rootX = find(x,parent);
        Integer rootY = find(y,parent);
//
        if(rootX == null || rootY == null){
            return;
        }
//
//        if(rootX == rootY){
//            return;
//        }
//
//        // 合并
        parent.put(rootX,rootY);

        return;
    }

    // 感觉像是并查集
//    public static int longestConsecutive1(int[] nums) {
//        int length = nums.length;
//        if(length <= 1){
//            return length;
//        }
//
//        HashSet<Integer> set = new HashSet<>();
//        // 值 -> 下标
//        Map<Integer,Integer> map = new HashMap<>();
//
//        for(int i = 0;i < length;i++){
//            set.add(nums[i]);
//        }
//
//        int[] parent = new int[set.size()];
//
//        // 现在最大的问题是num中存在重复元素
//        int[] newNum = new int[set.size()];
//        int idx = 0;
//
//        for(int num : set){
////            System.out.println("插入：" + num + " idx:" + idx);
//            newNum[idx] = num;
//            map.put(num,idx);
//            parent[idx] = idx;
//            idx++;
//        }
//
//        for(int i = 0;i < set.size();i++){
//            System.out.println("i:" + i + " num:" + newNum[i] + " --> " + map.get(newNum[i]) + " parent:" + i);
//        }
//
//
//
//        for(int i = 0;i < newNum.length;i++){
////            if(map.containsKey(newNum[i] - 1)){
//////                union(map.get(newNum[i] - 1),i,parent);
////                // 把小的合到大的上
////                parent[find(map.get(newNum[i] - 1),parent)] = find(map.get(newNum[i]),parent);
////            }
//            if(map.containsKey(newNum[i] + 1)){
////                union(i,map.get(newNum[i] + 1),parent);
//                parent[find(map.get(newNum[i]),parent)] = parent[find(map.get(newNum[i] + 1),parent)];
//            }
//        }
//
//        // 从一个parent中，找出出现次数最多的下标
//        int maxCount = 0;
//        Map<Integer,Integer> countMap = new HashMap<>();
//        for(int i = 0;i < set.size();i++){
//            countMap.put(parent[i],countMap.getOrDefault(parent[i],0) + 1);
//            if(countMap.get(parent[i]) > maxCount){
//                maxCount = countMap.get(parent[i]);
//            }
//        }
//
//        for(int i : parent){
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//        return maxCount;
//    }



}
