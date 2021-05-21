package CodeTop;

import java.util.LinkedList;
import java.util.Queue;

public class P_958 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//
//        root.right.left = new TreeNode(6);

//
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//
//        root.right.right = new TreeNode(7);


//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);

        boolean flag = isCompleteTree(root);
        System.out.println(flag);
    }

    // 对于每个root，要么左右子树都有，要么只有左子树并且只有最右节点有时才为true
    // 应该用层次遍历改
    public static boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node != null){
                queue.offer(node.left);
                queue.offer(node.right);
            }else{
                break;
            }
        }

        // 跳出循环后再去检查当前队列是否含有非null元素
        while(!queue.isEmpty()){
            if(queue.poll() != null){
                return false;
            }
        }

        return true;
    }
}
