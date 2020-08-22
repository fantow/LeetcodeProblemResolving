package JZOffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_59_2 {
    public static void main(String[] args) {

        MaxQueue queue = new MaxQueue();
        queue.push_back(1);
        queue.push_back(2);
        int value = queue.max_value();
        System.out.println(value);  // --> 2
        value = queue.pop_front();
        System.out.println(value);  // --> 1
        value = queue.max_value();  // --> 2
        System.out.println(value);
    }

    static class MaxQueue {

        public static Queue<Integer> queue = new LinkedList<>();
        public static Deque<Integer> maxQueue = new LinkedList<>();

        public MaxQueue() {

        }

        public static int max_value() {
            if(!maxQueue.isEmpty()){
                int elem = maxQueue.peekFirst();
                return elem;
            }
            return -1;
        }

        // 因为是队列，如果后进来的数比前面的数都要大，那就不用再保存前面的值
        // 因为到了这个最大值出队时，前面的数已经出队了。
        public static void push_back(int value) {
            queue.offer(value);
            while(!maxQueue.isEmpty() && maxQueue.peekLast() < value){
                maxQueue.removeLast();
            }
            maxQueue.addLast(value);
        }

        public static int pop_front() {
            if(!queue.isEmpty()) {
                int elem = queue.poll();
                if (elem == maxQueue.peekFirst()) {
                    maxQueue.pollFirst();
                }
                return elem;
            }
            return -1;
        }
    }
}
