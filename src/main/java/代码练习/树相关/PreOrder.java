package 代码练习.树相关;


import java.util.Stack;

public class PreOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        PreOrder preOrder = new PreOrder();
        preOrder.preOrder2(root);
    }

    // 递归方式
    public void preOrder(TreeNode root){
        if(root != null){
            System.out.print(root.val + " ");

            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // 非递归方式
    public void preOrder2(TreeNode root){
        if(root != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);

            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                System.out.print(node.val + " ");

                if(node.right != null){
                    stack.add(node.right);
                }

                if(node.left != null){
                    stack.add(node.left);
                }
            }
        }
    }

}
