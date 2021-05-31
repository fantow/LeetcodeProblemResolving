package CodeTop;

import java.util.Stack;

public class P_Offer09 {
    public static void main(String[] args) {
        P_Offer09 queue = new P_Offer09();

//        queue.appendTail(3);
//
//        System.out.println(queue.deleteHead());
//        System.out.println(queue.deleteHead());


        System.out.println(queue.deleteHead());
        queue.appendTail(5);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

    public Stack<Integer> stack1;
    public Stack<Integer> stack2;

    public P_Offer09() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            return -1;
        }

        if(!stack2.isEmpty()){
            return stack2.pop();
        }

        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }
}
