package LCEveryDay;

import java.util.*;

public class P_330 {
    public static void main(String[] args) {
        int[] nums = {1,3};
        int n = 6;

//        int[] nums = {1,5,10};
//        int n = 20;

        int result = minPatches(nums, n);
        System.out.println(result);
    }

    static int addCount = 0;


    // 其实是贪心的题目
    public static int minPatches(int[] nums, int n) {
        int i = 0;
        int count = 0;

        // add表示的是当前可以到达的最远num
        long add = 1;

        while(add <= n){
            if(i < nums.length && nums[i] <= add){
                add += nums[i++];
            }else{
                add += add;
                count++;
            }
        }

        return count;
    }

    // 做到后面感觉这道题像DFS
//    public static int minPatches(int[] nums, int n) {
//        int length = nums.length;
//        if(length == 0){
//            return n;
//        }
//
//        boolean[] isArrived = new boolean[n + 1];
//        isArrived[0] = true;
//
//        Map<Integer,Integer> map = new HashMap<>();
//        List<Integer> list = new ArrayList<>();
//
//        for(int num : nums){
//            isArrived[num] = true;
//            map.put(num,map.getOrDefault(num,0) + 1);
////            list.add(num);
//        }
//
//        for(int i = 1;i <= n;i++){
//            dfs(i,isArrived,map);
//        }
//
//        return addCount;
//    }


    // list中存放的是当前可用的元素值
//    public static void dfs(int num,boolean[] isVisited,Map<Integer,Integer> map){
//        if(num > isVisited.length){
//            return;
//        }
//
//        if(isVisited[num] != true){
//            addCount++;
//            map.put(num,1);
//        }
//
//        // 删掉这个元素，防止它与自己组合
//        map.put(num,map.get(num) - 1);
//
//        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
//            if(entry.getValue() <= 0){
//                continue;
//            }
//            if(entry.getKey() + num > isVisited.length){
//                continue;
//            }
//            if(isVisited[entry.getKey() + num] == true){
//                continue;
//            }else{
//                isVisited[entry.getKey() + num] = true;
//                map.put(entry.getKey() + num,1);
//                map.put(entry.getKey(),entry.getValue() - 1);
//                dfs(entry.getKey() + num,isVisited,map);
//                map.put(entry.getKey(),entry.getValue() + 1);
//            }
//        }
//        map.put(num,map.get(num) + 1);
//    }
}
