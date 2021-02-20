package LCEveryDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_697 {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 2, 3, 1};
//        int[] nums = {1,2,2,3,1,4,2};
        int[] nums = {1};
        int result = findShortestSubArray(nums);

        System.out.println(result);
    }


    // 找出nums数组中，出现度数最高的子数组的最小长度
    public static int findShortestSubArray(int[] nums) {
        int length = nums.length;

        Map<Integer,Pair> map = new HashMap<>();
        // 用来记录每个数字的度数
        Map<Integer,Integer> countMap = new HashMap<>();

        // 这样算不好，因为可能有相同的多组最大度数
        int maxNum = -1;

        for(int i = 0;i < length;i++){
            countMap.put(nums[i],countMap.getOrDefault(nums[i],0) + 1);
            maxNum = countMap.get(nums[i]) > maxNum ? countMap.get(nums[i]) : maxNum;
            if(map.containsKey(nums[i])){
                Pair pair = map.get(nums[i]);

                // 修改右边界即可
                pair.setRight(i);
            }else{
                Pair pair = new Pair(i,i);
                map.put(nums[i],pair);
            }
        }

//        用一个List，记录所有最大度数
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
            if(entry.getValue() == maxNum){
                list.add(entry.getKey());
            }
        }

        int minLength = Integer.MAX_VALUE;

        for(int i = 0;i < list.size();i++){
            Pair pair = map.get(list.get(i));
            int tempLength = pair.getRight() - pair.getLeft() + 1;
            minLength = tempLength < minLength ? tempLength : minLength;
        }

        return minLength;
    }

    static class Pair{
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }
    }
}
