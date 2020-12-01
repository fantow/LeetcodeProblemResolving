package Hot100;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P_347 {
    public static void main(String[] args) {
//        int[] nums = {1,1,1,2,2,3};
//        int k = 2;

        int[] nums = {1,2,2,3,1,4};
        int k = 4;

//        int[] nums = {1};
//        int k = 1;

        int[] resultArr = topKFrequent(nums, k);
//        for(int i = 0;i < resultArr.length;i++){
//            System.out.print(resultArr[i] + " ");
//        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int length = nums.length;
        int[] resultArr = new int[k];

        if(length == 1){
            resultArr[0] = nums[0];
            return resultArr;
        }

        Map<Integer,Integer> countMap = new HashMap<>();

        // 为其计数
        for(int i = 0;i < length;i++){
            countMap.put(nums[i],countMap.getOrDefault(nums[i],0) + 1);
        }

        // 创建一个优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return countMap.getOrDefault(o2,1) - countMap.getOrDefault(o1,1);
            }
        });

        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
            queue.offer(entry.getKey());
        }

//        while(!queue.isEmpty()){
//            System.out.print(queue.poll() + " ");
//        }
//

        for(int i = 0;i < k;i++){
            resultArr[i] = queue.poll();
        }

        return resultArr;
    }
}
