package Algo91.Chap01_数组_栈_队列;

import java.util.PriorityQueue;

public class P_703 {

    // 维护一个大小为K的小根堆
    PriorityQueue<Integer> queue = null;
    int size = 0;
    int capacity = 0;

    public P_703(int k, int[] nums){
        queue = new PriorityQueue<Integer>();
        this.capacity = k;

        for(int i = 0;i < nums.length;i++){
            add(nums[i]);
        }
    }

    public int add(int val) {
        // 只有新加入的val 比当前的第k大的数大，才会导致堆的改变
        if(queue.size() < capacity){
            queue.offer(val);
        }else{
            int min = queue.peek();
            if(min < val){
                queue.poll();
                queue.offer(val);
            }
        }
        return queue.peek();
    }
}
