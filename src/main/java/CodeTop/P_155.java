package CodeTop;

import java.util.Stack;

public class P_155 {
    public static void main(String[] args) {

        P_155 minStack = new P_155();

        minStack.push(-2);

        minStack.push(0);

        minStack.push(-3);

        System.out.println(minStack.getMin());

        minStack.pop();

        System.out.println(minStack.top());

        System.out.println(minStack.getMin());


//        while(!minStack.minStack.isEmpty()){
//            System.out.print(minStack.minStack.pop() + " ");
//        }

    }

    // 原始栈
    public Stack<Integer> stack ;

    // 最小栈
    // 用于维护一个单减栈
    public Stack<Integer> minStack;

    // 设计一个最小栈，可以在常数时间内检测到最小元素的栈
    public P_155(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if(minStack.isEmpty()){
            minStack.push(val);
            return;
        }

        // 如果小于等于当前的stack，则入最小栈
        if(minStack.peek() >= val){
            minStack.push(val);
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            int elem =stack.pop();

            // 如果这个值就是当前的最小值，也要将其从最小栈中pop
            if(elem == minStack.peek()){
                minStack.pop();
            }
        }
    }

    // 获取栈顶元素
    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        return -1;
    }

    // 常数时间内获取最小值
    public int getMin() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        }

        return -1;
    }

}
