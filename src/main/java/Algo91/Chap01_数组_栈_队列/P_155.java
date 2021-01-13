package Algo91.Chap01_数组_栈_队列;

import java.util.Stack;

//在常数时间内检索到最小元素的栈
public class P_155 {
    public static void main(String[] args) {
        P_155 stack = new P_155();
        //minStack.push(-2);
        //minStack.push(0);
        //minStack.push(-3);
        //minStack.getMin();   --> 返回 -3.
        //minStack.pop();
        //minStack.top();      --> 返回 0.
        //minStack.getMin();   --> 返回 -2.

        stack.push(-2);
        stack.push(0);
        stack.push(-3);

        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public P_155(){
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        if(minStack.isEmpty() || minStack.peek() >= x){
            minStack.push(x);
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            int val = stack.peek();
            if(minStack.peek() == val){
                minStack.pop();
            }
            stack.pop();
        }
        return ;
    }

    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        return -1;
    }

    public int getMin() {
        if(!stack.isEmpty()){
            return minStack.peek();
        }

        return -1;
    }
}
