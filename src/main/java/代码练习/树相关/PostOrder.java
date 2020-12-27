package 代码练习.树相关;

import java.util.Stack;

public class PostOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        PostOrder postOrder = new PostOrder();
        postOrder.postOrder2(root);
    }

    // 非递归方式
    public void postOrder(TreeNode root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);

            System.out.print(root.val + " ");
        }
    }


    // 递归方式
    public void postOrder2(TreeNode root){
        if(root != null){
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> revStack = new Stack<>();

            stack1.add(root);

            while(!stack1.isEmpty()){
                TreeNode node = stack1.pop();
                revStack.add(node);

                if(node.left != null){
                    stack1.add(node.left);
                }

                if(node.right != null){
                    stack1.add(node.right);
                }
            }

            while(!revStack.isEmpty()){
                TreeNode node = revStack.pop();
                System.out.print(node.val + " ");
            }
        }
    }

}
