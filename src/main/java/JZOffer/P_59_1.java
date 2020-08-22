package JZOffer;

import java.util.*;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_59_1 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int[] arr = maxSlidingWindow(nums, k);

        for (int a : arr){
            System.out.print(a + " ");
        }

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0){
            return new int[]{};
        }

        Deque<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for(int j = 0,i = 1 - k;j < nums.length;j++,i++){
            // 如果本轮出去的元素就是之前的最大值
            if(i > 0 && queue.peekFirst() == nums[i - 1]){
                queue.removeFirst();
            }
            while(!queue.isEmpty() && queue.peekLast() < nums[j]){
                queue.removeLast();
            }
            queue.addLast(nums[j]);

            if(i >= 0){
                result[i] = queue.peekFirst();
            }
        }

        return result;
    }
}
