package Algo91.Chap01_数组_栈_队列;

import java.util.Stack;

// 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
// 输出：true
public class P_946 {
    public static void main(String[] args) {
//        int[] pushed = {1,2,3,4,5};
//        int[] poped = {4,5,3,2,1};

        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,3,5,1,2};

        boolean flag = validateStackSequences(pushed, popped);
        System.out.println(flag);
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int length = pushed.length;
        if(length <= 1){
            return true;
        }

        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        for(int i = 0;i < popped.length;i++){

            int val = popped[i];

            if(stack.isEmpty()){
                while(idx < length && pushed[idx] != val){
                    stack.add(pushed[idx++]);
                }
                idx++;
            }else{
                if(stack.peek() == val){
                    stack.pop();
                }else{
                    while(idx < length && pushed[idx] != val){
                        stack.add(pushed[idx++]);
                    }
                    idx++;
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }

        return false;
    }
}
