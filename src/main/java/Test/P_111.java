package Test;

import java.util.LinkedList;
import java.util.Queue;

public class P_111 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = minDepth(root);
        System.out.println(result);
    }

    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int depth = 1;

        TreeNode front = root;
        TreeNode rear = root;
        TreeNode last = root;

        while (!queue.isEmpty()){
            front = queue.peek();
            TreeNode node = queue.poll();

            if(node.left == null && node.right == null){
                return depth;
            }

            if(node.left != null){
                queue.offer(node.left);
                rear = node.left;
            }

            if(node.right != null){
                queue.offer(node.right);
                rear = node.right;
            }

            if(front == last){
                depth++;
                last = rear;
            }
        }

        return depth;
    }
}
