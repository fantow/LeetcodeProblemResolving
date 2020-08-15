package JZOffer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_33 {
    public static void main(String[] args) {
        int[] postorder = {1,3,2,6,5};
//        int[] postorder = {1,6,3,2,5};
        boolean flag = verifyPostorder2(postorder);

        System.out.println(flag);
    }

    public static boolean verifyPostorder(int[] postorder) {
        int length = postorder.length;
        if(length == 0 || length == 1){
            return true;
        }

        return isPostOrder(postorder,0,length - 1);
    }

    // 递归方式
    public static boolean isPostOrder(int[] postOrder,int start,int end){
        if(start >= end){
            return true;
        }

        // 获得当前区间的根节点
        int root = postOrder[end];

        // 通过在start~end部分遍历，找到第一个大于根节点的位置，从这个位置~end就是右子树
        int rightIdx = end;
        boolean firstChange = true;

        // 如果没有找到比根节点大的节点，说明没有右子树
        // 同时下面开始进行判断:
        // start~rightIdx-1 要小于 root
        // rightIdx~end 要大于root
        // 否则return false;
        for(int i = start;i < end;i++){
            if(postOrder[i] < root && !firstChange){
                return false;
            }

            // 进入这个if，表示开始进行右子树的判断
            if(postOrder[i] > root){
                if(firstChange){
                    rightIdx = i;
                    firstChange = false;
                }
            }
        }
        return isPostOrder(postOrder,start,rightIdx - 1)
                && isPostOrder(postOrder,rightIdx,end - 1);
    }


    // 方法二，使用逆序的后序遍历结果判断，非递归方法
    // 逆置的后序遍历结果将结果分为三部分 --> 【(根) (右) (左)】
    // 其中【根，右】不会出现逆序情况，只有【右，左】才会出现逆置
    public static boolean verifyPostorder2(int[] postorder) {
        int length = postorder.length;
        if(length == 0 || length == 1){
            return true;
        }

        int root = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();

        for(int i = length - 1;i >= 0;i--){
            if(postorder[i] > root){
                return false;
            }
            while(!stack.isEmpty() && stack.peek() > postorder[i]){
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }
}
