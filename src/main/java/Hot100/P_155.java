package Hot100;

import java.util.Stack;

public class P_155 {
    public static void main(String[] args) {
        MinStack stack = new MinStack();

        System.out.println(stack.getMin());
        stack.push(-2);
        stack.push(0);
        stack.push(-3);

        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }

    static class MinStack{

        private Stack<Integer> stack = new Stack<>();

        // 需要维护的单调栈
        private Stack<Integer> tempStack = new Stack<>();

        public MinStack(){

        }

        public void push(int x){
            stack.push(x);
            if(tempStack.isEmpty()){
                tempStack.push(x);
                return;
            }

            if(x <= tempStack.peek()){
                tempStack.add(x);
            }
        }

        public void pop(){
            int ele = stack.peek();
            if(ele == tempStack.peek()){
                tempStack.pop();
            }
            stack.pop();
        }

        public int top(){
            return stack.peek();
        }

        public int getMin(){
            if(!stack.isEmpty()){
                return tempStack.peek();
            }else{
                return -1;
            }
        }

    }
}
