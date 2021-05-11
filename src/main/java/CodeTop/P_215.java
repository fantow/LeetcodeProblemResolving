package CodeTop;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_215 {
    public static void main(String[] args) {

//        int[] nums = {3,2,1,5,6,4};
//        int k = 2;

        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        int result = findKthLargest(nums, k);
        System.out.println(result);
    }

    // 典型的TopK问题，维护一个容量为K的大根堆即可
    public static int findKthLargest(int[] nums, int k) {
        int length = nums.length;

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int num : nums){
            queue.offer(num);
        }

        for(int i = 0;i < k - 1;i++){
            queue.poll();
        }

        return queue.peek();
    }
}
