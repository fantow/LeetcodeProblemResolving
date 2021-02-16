package LCEveryDay;

import java.util.Stack;

public class P_485 {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int ones = findMaxConsecutiveOnes(nums);
        System.out.println(ones);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;

        Stack<Integer> stack = new Stack<>();

        int[] tempArr = new int[length + 2];

        tempArr[0] = 0;
        tempArr[length + 1] = 0;

        // 对原数组两端都加上0，方便算
        for(int i = 1;i < length + 1;i++){
            tempArr[i] = nums[i - 1];
        }

        for(int i = 0;i < length + 2;i++){
            if(tempArr[i] == 0){
                stack.push(i);
            }
        }

//        System.out.println(stack);

        int last = length + 1;
        int pre = 0;
        int max = 0;

        while(!stack.isEmpty()){
            pre = stack.pop();
            max = Math.max(max,(last - pre));
            last = pre - 1;
        }

        // 这一步不需要，因为在原数组前加了0了
//        max = Math.max(max,last - 0);

        return max;
    }
}
