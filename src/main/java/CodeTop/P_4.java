package CodeTop;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_4 {
    public static void main(String[] args) {
//        int[] nums1 = {1,3};
//        int[] nums2 = {2};

        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

//        int[] nums1 = {0,0};
//        int[] nums2 = {0,0};

//        int[] nums1 = {};
//        int[] nums2 = {1};

//        int[] nums1 = {2};
//        int[] nums2 = {};

        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

    // 和剑指Offer上一道讲两个输入流求中位数的题目一样
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        if(length1 + length2 == 0){
            return 0.0;
        }else if(length1 + length2 == 1){
            return (double)length1 == 0 ? nums2[0] : nums1[0];
        }

        // 大根堆
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 小根堆
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        int count = 0;

        int ptr1 = 0;
        int ptr2 = 0;

        while((ptr1 < length1 || ptr2 < length2) && count < (length1 + length2) / 2 + 1){

            int temp = -1;

            if(ptr1 < length1 && ptr2 < length2){
                if(nums1[ptr1] <= nums2[ptr2]){
                    temp = nums1[ptr1++];
                }else{
                    temp = nums2[ptr2++];
                }
            }else{
                if(ptr1 < length1){
                    temp = nums1[ptr1++];
                }else {
                    temp = nums2[ptr2++];
                }
            }

//            System.out.println("temp: " + temp);

            if(count % 2 == 1){
                maxQueue.offer(temp);
                minQueue.offer(maxQueue.poll());
            }else{
                minQueue.offer(temp);
                maxQueue.offer(minQueue.poll());
            }

            count++;
        }

        // 打印queue
//        while(!maxQueue.isEmpty()){
//            System.out.print(maxQueue.poll() + " ");
//        }
//        System.out.println();
//
//        System.out.println("====");
//
//        while(!minQueue.isEmpty()){
//            System.out.println(minQueue.poll() + " ");
//        }
//
//        System.out.println("ptr1: " + ptr1 + " ptr2: " + ptr2);

        if((length1 + length2) % 2 == 0){
            double res = maxQueue.poll();
            res += minQueue.poll();

            return res / 2.0;
        }else{
            return (double) minQueue.poll();
        }

    }
}
