package 算法通关40讲;

import java.util.Stack;

public class P_236 {
    public static void main(String[] args) {

    }

    // 采用后续遍历解决
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor1(root.left,p,q);
        TreeNode rightNode = lowestCommonAncestor1(root.right,p,q);

        if(leftNode == null){
            return rightNode;
        }else if(rightNode == null){
            return leftNode;
        }

        return root;
    }

    // 采用两个栈的方式解决
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        getParentNode(root,stack1,p);
        getParentNode(root,stack2,q);

        for(int i = stack1.size() - 1;i >= 0;i--){
            for(int j = stack2.size() - 1;j >= 0;j--){
                if(stack1.get(i) == stack2.get(j)){
                    return stack1.get(i);
                }
            }
        }

        return null;
    }

    public static boolean getParentNode(TreeNode root, Stack<TreeNode> stack,TreeNode p){
        if(root == null){
            return false;
        }

        if(root == p){
            stack.add(p);
            return true;
        }

        stack.add(root);

        if(getParentNode(root.left,stack,p)){
            return true;
        }else if(getParentNode(root.right,stack,p)){
            return true;
        }

        stack.pop();

        return false;
    }
}
