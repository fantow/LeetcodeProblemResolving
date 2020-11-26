package Hot100;

import java.util.Stack;

public class P_581 {
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
//        int[] nums = {5,4,3,2,1};
//        int[] nums = {1,3,2,4,5};
//        int[] nums = {1,2,3,4};
//        int[] nums = {2,3,3,2,4};

        int result = findUnsortedSubarray(nums);

        System.out.println(result);
    }


    //1.应该可以使用二分法，找到第一个前>后的左边界,再找到第一个前< 后的左边界
    //

    public static int findUnsortedSubarray(int[] nums) {
        int length = nums.length;

        if(length == 0 || length == 1){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int left = length - 1;
        int right = 0;

        for(int i = 0;i < length;i++){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                left = Math.min(left,stack.pop());
            }
            stack.push(i);
        }

        for(int i = length - 1;i >= 0;i--){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                right = Math.max(right,stack.pop());
            }
            stack.push(i);
        }

        return right - left > 0 ? right - left + 1 : 0;
    }



    // 逻辑写的有点乱了，并且跑不过用例[1,3,2,4,5]
    public static int findUnsortedSubarray1(int[] nums) {
        int length = nums.length;
        if(length == 0 || length == 1){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int rightIdx = length - 1;
        int leftIdx = 0;

        boolean hasChanged = false;

        stack.add(length - 1);

        // 先尝试用单调队列逆序做
        for(int i = length - 2;i >= 0;i--){
            if(nums[stack.peek()] < nums[i]){
                while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
//                    System.out.println(stack.peek() + " : " + nums[i]);
                    if (!hasChanged) {
                        rightIdx = stack.peek();
                        hasChanged = true;
                    } else {
                        leftIdx = i;
                    }
                    stack.pop();
                }
            }
            stack.add(i);
        }

        return hasChanged ? rightIdx - leftIdx + 1 : 0;
    }
}
