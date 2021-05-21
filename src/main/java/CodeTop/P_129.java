package CodeTop;

import java.util.LinkedList;
import java.util.Queue;

public class P_129 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);


        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        int res = sumNumbers(root);

        System.out.println(res);
    }

    // 应该是用层次遍历
    public static int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        // 记录结果
        int res = 0;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            // 如果是叶子节点，则参与计算
            if(node.left == null && node.right == null){
                res += node.val;
                continue;
            }

            if(node.left != null){
                node.left.val += node.val * 10;
                queue.offer(node.left);
            }

            if(node.right != null){
                node.right.val += node.val * 10;
                queue.offer(node.right);
            }
        }

        return res;
    }
}
