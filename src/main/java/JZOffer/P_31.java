package JZOffer;

import java.util.Stack;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_31 {
    public static void main(String[] args) {
//        ----- test1 -----
//        int[] pushed = {1,2,3,4,5};
//        int[] popped = {4,5,3,2,1};

//        ----- test2 -----
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,3,5,1,2};

        boolean flag = validateStackSequences(pushed, popped);
        System.out.println(flag);
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> assistStack = new Stack<>();

        int length = pushed.length;

        if(length == 0 || length == 1){
            return true;
        }

        int pushIdx = 0;
        int popIdx = 0;

        while(popIdx < length) {
            // 获取本轮出栈元素
            int num = popped[popIdx];

            if(!assistStack.isEmpty() && num == assistStack.peek()){
                assistStack.pop();
            }else {
                // 题目保证了所有数字不相等
                while (pushIdx < length && pushed[pushIdx] != num) {
                    assistStack.push(pushed[pushIdx++]);
                }

                if(pushIdx < length) {
                    assistStack.push(pushed[pushIdx++]);
                }else{
                    return false;
                }

                assistStack.pop();
            }
            // 开始进行下一轮
            popIdx++;
        }
        return true;
    }
}
