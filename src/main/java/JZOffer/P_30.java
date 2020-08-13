package JZOffer;

import java.util.Stack;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_30 {
    public static void main(String[] args) {
        P_30 stack = new P_30();
//        ----- test1 -----
//        stack.push(-2);
//        stack.push(0);
//        stack.push(-3);
//
//        int min = stack.min();
//        System.out.println(min);
//
//        stack.pop();
//
//        int top = stack.top();
//        System.out.println(top);
//
//        min = stack.min();
//        System.out.println(min);

//        ------ test2 -----
        stack.push(0);
        stack.push(1);
        stack.push(0);
        int min = stack.min();
        System.out.println(min);
        stack.pop();
        min = stack.min();
        System.out.println(min);

    }

    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> assistStack = new Stack<>();

    public P_30(){

    }

    public static void push(int x) {
        stack.push(x);
        if(!assistStack.isEmpty()){
            int min = assistStack.peek();
            // 这里需要取min >= x
            // 因为最小值可能被重复存入栈中
            if(min >= x){
                assistStack.push(x);
            }
        }else {
            assistStack.push(x);
        }
    }

    public static void pop() {
        if(!stack.isEmpty()){
            int ele = stack.pop();
            if(assistStack.peek() == ele){
                assistStack.pop();
            }
        }else{
            return ;
        }
    }

    public static int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }else{
            return -1;
        }
    }

    // 难点在于如何使min()的时间复杂度降为O(1)
    // 利用一个辅助栈，保持两个栈在同一时刻都在描述相同的场景
    // 辅助栈只存当前时刻的最小值
    // 如果主栈中pop了最小值，辅助栈也要pop()
    public static int min() {
        if(!assistStack.isEmpty()){
            return assistStack.peek();
        }else{
            return -1;
        }
    }

}
