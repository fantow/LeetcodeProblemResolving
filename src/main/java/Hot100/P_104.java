package Hot100;

import sun.reflect.generics.tree.Tree;

public class P_104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        TreeNode temp = root.right;
        temp.left = new TreeNode(15);
        temp.right = new TreeNode(7);

        int depth = maxDepth1(root);
        System.out.println(depth);
    }

    // 使用递归
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftLength = maxDepth(root.left);
        int rightLength = maxDepth(root.right);

        return Math.max(leftLength,rightLength) + 1;
    }


    // 使用非递归
    public static int maxDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }

        // 需要采用层次遍历
        TreeNode[] queue = new TreeNode[1000000];
        int head = 0;
        int tail = 0;

        // root入队
        queue[tail++] = root;
        int last = tail;

        int dept = 0;

        while(head < tail){

            // 节点出队
            TreeNode node = queue[head++];
            System.out.println(node);
            if(node.left != null){
                queue[tail++] = node.left;
            }

            if(node.right != null){
                queue[tail++] = node.right;
            }

            if(head == last){
                last = tail;
                dept++;
            }
        }

        return dept;
    }
}
