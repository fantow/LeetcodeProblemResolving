package CodeTop;

import java.util.Stack;

public class P_232 {
    public static void main(String[] args) {
        P_232 queue = new P_232();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

    // 题目要求使用两个栈，实现队列的功能
    public Stack<Integer> stack1 = null;
    public Stack<Integer> stack2 = null;

    public P_232(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // 入队
    /** Push element x to the back of queue. */
    public void push(int x) {
//        if(!stack2.isEmpty()){
//            while(!stack1.isEmpty()){
//                stack2.add(stack1.pop());
//            }
//        }

        stack1.add(x);
    }


    // 出队
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                return -1;
            }

            while(!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
        }

        return stack2.pop();
    }

    // 返回队首元素
    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                return -1;
            }

            while(!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
        }

        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
