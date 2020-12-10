package Hot100;

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

        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }


    // 还可以使用归并排序做
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        // 因为给定的是两个有序数组，所以可以直接使用归并排序
        int idx = 0;
        int result = 0;

        int left = 0;
        int right = 0;

        // 是否需要两个值
        boolean flag = false;
        if((length1 + length2) % 2 == 0){
            flag = true;
        }

        while(left < length1 || right < length2){
            if(left < length1 && right < length2) {
                if (nums1[left] < nums2[right]) {
                    left++;
                } else {
                    right++;
                }

                idx++;
            }else{

            }
        }

        return flag ? result / 2.0 : result;
    }

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        // 应该是使用两个堆相互转换
        int idx = 0;

        PriorityQueue<Integer> minQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i = 0;i < length1;i++){
            // 奇数次放放大根堆，偶数次放放小根堆
            if(idx % 2 == 0){
                maxQueue.offer(nums1[i]);
                Integer num = maxQueue.poll();
                minQueue.offer(num);
            }else{
                minQueue.offer(nums1[i]);
                Integer num = minQueue.poll();
                maxQueue.offer(num);
            }
            idx++;
        }

        for(int i = 0;i < length2;i++){
            // 奇数次放放大根堆，偶数次放放小根堆
            if(idx % 2 == 0){
                maxQueue.offer(nums2[i]);
                Integer num = maxQueue.poll();
                minQueue.offer(num);
            }else{
                minQueue.offer(nums2[i]);
                Integer num = minQueue.poll();
                maxQueue.offer(num);
            }
            idx++;
        }

//        System.out.println(maxQueue);
//        System.out.println(minQueue);

        if((length1 + length2) % 2 == 1){
            return minQueue.poll();
        }else{
            return (minQueue.poll() + maxQueue.poll()) / 2.0;
        }
    }
}
