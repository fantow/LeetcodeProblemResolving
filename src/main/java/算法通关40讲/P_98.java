package 算法通关40讲;

public class P_98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        boolean flag = isValidBST(root);
        System.out.println(flag);
    }

    static long pre = Long.MIN_VALUE;

    // 应该采用中序遍历
    public static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        if(!isValidBST(root.left)){
            return false;
        }

        System.out.println("pre: " + pre + "  --> val: " + root.val);

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
