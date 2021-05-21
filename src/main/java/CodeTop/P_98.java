package CodeTop;

public class P_98 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        boolean flag = isValidBST(root);
        System.out.println(flag);
    }

    public static long pre = Long.MIN_VALUE;

    // root.left < root && root < root.right
    public static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        if(!isValidBST(root.left)){
            return false;
        }

        if(root.val <= pre){
            return false;
        }

        pre = root.val;

        if(!isValidBST(root.right)){
            return false;
        }

        return true;
    }
}
