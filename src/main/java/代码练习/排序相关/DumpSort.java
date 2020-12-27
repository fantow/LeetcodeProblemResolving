package 代码练习.排序相关;

import java.util.PriorityQueue;

public class DumpSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};

        DumpSort dumpSort = new DumpSort();
        dumpSort.dumpSort(nums);

        for(int num : nums){
            System.out.print(num + " ");
        }
    }

    // 堆排序可以使用PriorityQueue实现
    public void dumpSort(int[] nums){
        int length = nums.length;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int num : nums){
            priorityQueue.offer(num);
        }

        int idx = 0;
        while(!priorityQueue.isEmpty()){
            nums[idx++] = priorityQueue.poll();
        }
    }

    public void dumpSort1(int[] nums){



    }

}
