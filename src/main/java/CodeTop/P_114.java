package CodeTop;

import java.util.Stack;

public class P_114 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(5);
//
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//
//        root.right.right = new TreeNode(6);

        TreeNode root = new TreeNode(0);

        flatten(root);

        print(root);
    }

    public static void print(TreeNode root){
        while(root != null){
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    // 要求结果和先序遍历结果相同
    public static void flatten(TreeNode root) {
        if(root == null){
            return ;
        }

        TreeNode dummy = new TreeNode(-1);
        TreeNode temp = dummy;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();

            temp.right = node;
            temp = temp.right;

            if(node.right != null){
                stack.push(node.right);
            }

            if(node.left != null){
                stack.push(node.left);
            }

            node.left = null;
            node.right = null;
        }

        root = dummy.right;
        return ;
    }
}
