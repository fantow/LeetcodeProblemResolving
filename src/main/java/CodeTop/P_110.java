package CodeTop;

public class P_110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        boolean flag = isBalanced(root);
        System.out.println(flag);
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        return func(root) == -1 ? false : true;
    }

    public static int func(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = func(root.left);
        if(left == -1){
            return -1;
        }

        int right = func(root.right);
        if(right == -1){
            return -1;
        }

        return Math.abs(left - right) < 2 ? Math.max(left,right) + 1 : -1;
    }
}
