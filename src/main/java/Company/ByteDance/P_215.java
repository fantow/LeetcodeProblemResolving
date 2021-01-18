package Company.ByteDance;

import java.util.Comparator;
import java.util.LinkedList;
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


//    static int result = 0;
    // 快排
    public static int findKthLargest(int[] nums, int k) {
        int length = nums.length;

        quickSort(nums,0,length - 1,k);

        return nums[k - 1];
    }

    // partition
    public static int partition(int[] nums,int start,int end,int k){
        int temp = nums[start];

        while(start < end){
            while(start < end && nums[end] <= temp){
                end --;
            }
            nums[start] = nums[end];

            while(start < end && nums[start] >= temp){
                start ++;
            }
            nums[end] = nums[start];
        }
        nums[start] = temp;
//        if(start == k){
//            result = start;
//            System.out.println("result: " + result);
//        }

        return start;
    }

    public static void quickSort(int[] nums,int start,int end,int target){
        if(start < end){
            int partition = partition(nums, start, end, target);

            if(partition == target - 1){
//                System.out.println("partition : " + partition + " num: " + nums[partition]);
                return ;
            }

            quickSort(nums,start,partition - 1,target);
            quickSort(nums,partition + 1,end,target);
        }
        return ;
    }


    // 优先队列
    public static int findKthLargest1(int[] nums, int k) {
        int length = nums.length;

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i = 0;i < length;i++){
//            if(!queue.contains(nums[i])){
//                queue.offer(nums[i]);
//            }
            queue.offer(nums[i]);
        }


        int result = 0;
        for(int i = 0;i < k;i++){
            result = queue.poll();
        }

        return result;
    }
}
