package Hot100;

import java.util.LinkedList;
import java.util.Queue;

public class P_617 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);

        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        TreeNode treeNode = mergeTrees(root1, root2);
        printTree(treeNode);
    }

    public static void printTree(TreeNode root){
        if(root == null){
            return;
        }

        System.out.print(root.val + " ");

        printTree(root.left);
        printTree(root.right);
    }

    // 使用层次遍历
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        }

        if(t1 == null || t2 == null){
            return t1 == null ? t2 : t1;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(t1);
        queue.offer(t2);

        while(!queue.isEmpty()){
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            leftNode.val += rightNode.val;

            if(leftNode.left != null && rightNode.left != null){
                queue.offer(leftNode.left);
                queue.offer(rightNode.left);
            }

            if(leftNode.right != null && rightNode.right != null){
                queue.offer(leftNode.right);
                queue.offer(rightNode.right);
            }

            if(leftNode.left == null){
                leftNode.left = rightNode.left;
            }

            if(leftNode.right == null){
                leftNode.right = rightNode.right;
            }
        }

        return t1;
    }



}
