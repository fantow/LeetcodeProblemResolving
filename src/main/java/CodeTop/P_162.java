package CodeTop;

import java.util.Stack;

public class P_162 {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};
        int[] nums = {1,2,1,3,5,6,4};

        int res = findPeakElement(nums);
        System.out.println(res);
    }

    // 返回峰值，如果有多个峰值时，只返回其中一个的下标即可
    public static int findPeakElement(int[] nums) {
        int length = nums.length;

        // 维护一个单增的单调栈
        // 需要考虑最开始和结尾，所以提前放个-无穷
        Stack<Integer> minStack = new Stack<>();

        minStack.push(Integer.MIN_VALUE);

        for(int i = 0;i < length;i++){
            if(minStack.peek() == Integer.MIN_VALUE || nums[i] > nums[minStack.peek()]){
                minStack.push(i);
            }else{
                return minStack.peek();
            }
        }

        // 如果到最后都没有返回一个结果，那就返回最后一个即可
        if(minStack.peek() != Integer.MIN_VALUE){
            return length - 1;
        }

        return -1;
    }
}
