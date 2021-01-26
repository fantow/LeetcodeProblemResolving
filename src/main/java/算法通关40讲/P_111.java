package 算法通关40讲;

public class P_111 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
//        int result = minDepth(root);

        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        int result = minDepth(root);

        System.out.println(result);
    }

    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if(leftDepth == 0 && rightDepth == 0){
            return 1;
        }else if(leftDepth == 0 || rightDepth == 0){
            // 有一个等于0
            return leftDepth == 0 ? rightDepth + 1 : leftDepth + 1;
        }else{
            // 都不为0
            return leftDepth > rightDepth ? rightDepth + 1 : leftDepth + 1;
        }
    }
}
