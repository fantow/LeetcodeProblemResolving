package Algo91.Chap01_数组_栈_队列;

import java.util.Stack;

public class P_1381 {
    public static void main(String[] args) {
        P_1381 customStack = new P_1381(3);
        customStack.push(1);
        customStack.push(2);

        System.out.println(customStack.pop());

        customStack.push(2);
        customStack.push(3);
        customStack.push(4);

        customStack.increment(5,100);
        customStack.increment(2,100);

        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());

    }

    public int[] arr;
    public Stack<Integer> stack = new Stack<>();
    // ptr指向当前栈顶
    int ptr = -1;
    int maxSize;

    public P_1381(int maxSize){
        this.arr = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if(ptr >= maxSize - 1){
            return;
        }

        stack.push(++ ptr);
        arr[ptr] = x;
    }

    public int pop() {
        if(stack.isEmpty()){
            return -1;
        }
        int elem = stack.pop();
        ptr--;

        return arr[elem];
    }

    public void increment(int k, int val) {
        if(k >= ptr + 1){
            k = ptr + 1;
        }

        for(int i = 0;i < k;i++){
            arr[i] = arr[i] + val;
        }
    }

}
