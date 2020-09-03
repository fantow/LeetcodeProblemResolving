package Classify400.Array.基础;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_128 {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        int result = longestConsecutive2(nums);

        System.out.println(result);
    }

    // 看题解才理解，使用HashSet
    public static int longestConsecutive(int[] nums) {
        int length = nums.length;
        if (length == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int maxLen = 0;

        for (int i = 0;i < length;i++){
            int tempNum = nums[i];
            int tempLen = 1;
            while(set.contains(tempNum + tempLen)){
                tempLen++;
            }
            maxLen = Math.max(maxLen,tempLen);
        }

        return maxLen;
    }


    static Map<Integer,Integer> parents = new HashMap<>();
    static Map<Integer,Integer> count = new HashMap<>();

    // 找上司
//    public static int find(int x){
//        int p = parents.get(x);
//        if(p == x){
//            return p;
//        }
//        // 找到t的最上层
//        int t = find(p);
//        // 更新
//        parents.put(x,t);
//        return t;
//    }

    public static int find(int x){
        int p = parents.get(x);
        if(p == x)
            return p;
        // t为x的最终boss
        int t = find(p);
        // 直接将x的上司设置为t，将路径压缩
        parents.put(x, t);

        return t;
    }

//    public static void union(int x,int y){
//        int p1 = find(x);
//        int p2 = find(y);
//
//        if(p1 == p2){
//            return ;
//        }
//        // 若x的上司与y的上司不是同一个人，则将p2置为p1的上司
//        parents.put(p1,p2);
//        // 更新人数
//        count.put(p2,count.get(p1) + count.get(p2));
//    }

    public static void union(int x, int y){
        int p1 = find(x);
        int p2 = find(y);
        if(p1 == p2)
            return;
        // 若x与y的上司不是同一个人，则设置p2为p1的上司
        parents.put(p1, p2);
        // 此时p2手下的人数就为p1手下管理的人数加p2手下的人数
        count.put(p2, count.get(p1) + count.get(p2));
    }

    public static int longestConsecutive2(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        // set去重，同时初始化parents和count
        for(int num : nums){
            parents.put(num, num);
            count.put(num, 1);
            set.add(num);
        }
        for(int num : set){
            if(set.contains(num-1))
                union(num, num-1);
            if(set.contains(num+1))
                union(num, num+1);
            // 查找num的最终boss的管理人数与当前ans相比，留最大
            ans = Math.max(ans, count.get(find(num)));
        }

        for(Map.Entry entry : parents.entrySet()){
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
        }


        return ans;
    }


    // 方法2.使用并查集
    public static int longestConsecutive1(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();

        // 初始化parents和count
        for(int num : nums){
            parents.put(num,num);
            count.put(num,1);
            set.add(num);
        }

        for(int num : set){
            if(set.contains(num - 1)){
                union(num - 1,num);
            }
            if(set.contains(num + 1)){
                union(num,num + 1);
            }
            ans = Math.max(ans,count.get(find(num)));
        }

        for(Map.Entry entry : parents.entrySet()){
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
        }

        return ans;
    }
}
