package JZOffer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
// 从数据流中找出中位数
// 利用两个堆，一个大根堆，一个小根堆
public class P_41 {
    public static void main(String[] args) {

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        double median = medianFinder.findMedian();
        System.out.println(median);
        medianFinder.addNum(3);
        median = medianFinder.findMedian();
        System.out.println(median);

    }
    static class MedianFinder {

        public Queue<Integer> maxStack = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        public Queue<Integer> minStack = new PriorityQueue<>();
        int size = 0;

        public MedianFinder() {

        }

        // 按照顺序分别进入大根堆，小根堆
        // 并且每次进入大根堆时，要返回一个max给小根堆
        // 进入小根堆时，要返回一个min给大根堆
        // 这样可以保证，在小根堆的堆顶拿到中位数(奇数个元素时)
        // 在(大根堆顶+小根堆顶)/2 中拿到中位数(偶数个元素时)
        public void addNum(int num) {
            if(size % 2 == 0){
                maxStack.offer(num);
                minStack.offer(maxStack.poll());
            }else{
                minStack.offer(num);
                maxStack.offer(minStack.poll());
            }
            size++;
        }

        public double findMedian() {
            if(size % 2 != 0){
                return minStack.peek();
            }

            return (maxStack.peek() + minStack.peek()) / 2.0;
        }
    }
}
