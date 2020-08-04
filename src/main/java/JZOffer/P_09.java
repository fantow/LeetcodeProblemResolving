package JZOffer;

import java.util.Stack;

public class P_09 {
    public static void main(String[] args) {

        CQueue queue = new CQueue();
        queue.appendTail(5);
        queue.appendTail(2);
    }

    static class CQueue{
        public Stack<Integer> stack1 = new Stack<Integer>();
        public Stack<Integer> stack2 = new Stack<Integer>();

        // 在队尾插入整数
        public void appendTail(int value){
            stack1.add(value);
        }

        // 在队列头部删除整数
        public int deleteHead(){
            // 如果stack2不为空，直接从stack2中pop
            if(!stack2.isEmpty()){
                return stack2.pop();
            }else if(!stack1.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.add(stack1.pop());
                }
                return stack2.pop();
            }else{
                return -1;
            }
        }

    }

}
