package LCEveryDay;

import java.util.PriorityQueue;

public class P_703 {
    // 要求返回第K大的数，那就需要维护一个容量为K大小的优先队列
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};

        P_703 kThLargest = new P_703(k,nums);

        System.out.println(kThLargest.add(3));
        System.out.println(kThLargest.add(5));
        System.out.println(kThLargest.add(10));
        System.out.println(kThLargest.add(9));
        System.out.println(kThLargest.add(4));
        System.out.println("--- end ---");
    }

    // 小根堆
    public PriorityQueue<Integer> queue = new PriorityQueue<>();
    public int capacity = 0;
    public int size = 0;

    public P_703 (int k, int[] nums) {
        this.capacity = k;
        for(int num : nums){
            if(size < capacity){
                queue.offer(num);
                size++;
            }else{
                if(num > queue.peek()){
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
    }

    public int add(int val) {
        if(size < capacity){
            queue.offer(val);
            size++;
        }else{
            if(val > queue.peek()){
                queue.poll();
                queue.offer(val);
            }
        }

        return queue.peek();
    }
}
