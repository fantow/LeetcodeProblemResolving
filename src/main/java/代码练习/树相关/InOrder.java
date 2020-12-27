package 代码练习.树相关;

import java.util.Stack;

public class InOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        InOrder inOrder = new InOrder();
        inOrder.inOrder2(root);
    }

    // 递归方式
    public void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    // 非递归方式
    public void inOrder2(TreeNode root){
        if(root != null) {

            Stack<TreeNode> stack = new Stack<>();

            TreeNode node = root;

            while(!stack.isEmpty() || node != null){
                while(node != null){
                    stack.add(node);
                    node = node.left;
                }

                if(!stack.isEmpty()){
                    node = stack.pop();

                    System.out.print(node.val + " ");
                    node = node.right;
                }
            }
        }
    }

}
