package Hot100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P_239 {
    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int k = 3;

//        int[] nums = {1};
//        int k = 1;


        int[] nums = {1,-1};
        int k = 1;

        int[] window = maxSlidingWindow(nums, k);

        for(int num : window){
            System.out.print(num + " ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if(k <= 0 || length < k){
            return null;
        }

        int[] resultArr = new int[length - k + 1];

        int fast = 0;
        int idx = 0;

        // 还不是比较标准的滑动窗口，应该还要维护一个单调队列
        // 维护一个单减队列，遇到大的会弹出所有小的
        Deque<Integer> queue = new LinkedList<>();
//        queue.add(nums[fast++]);

        while(fast < length){
            // 如果当前的最大值超过了窗口大小，则弹出
            if(fast - k >= 0 && nums[fast - k] == queue.peekFirst()){
                queue.pollFirst();
            }

            while(!queue.isEmpty() && queue.peekLast() < nums[fast]){
                queue.pollLast();
            }

            queue.offerLast(nums[fast]);

            if(fast + 1 >= k){
                resultArr[idx++] = queue.peekFirst();
            }

            fast++;
        }

        return resultArr;
    }
}
