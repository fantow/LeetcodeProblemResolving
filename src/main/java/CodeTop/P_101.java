package CodeTop;

public class P_101 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//
//
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(3);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        boolean flag = isSymmetric(root);

        System.out.println(flag);
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return isSymmetricFunc(root.left,root.right);
    }

    public static boolean isSymmetricFunc(TreeNode leftTree,TreeNode rightTree){
        // 如果其中有一个null一个非null，直接返回false
        if(leftTree == null ^ rightTree == null){
            return false;
        }

        // 如果两个都为null，返回true
        if(leftTree == null && rightTree == null){
            return true;
        }

        if(leftTree.val != rightTree.val){
            return false;
        }

        if(isSymmetricFunc(leftTree.left,rightTree.right) && isSymmetricFunc(leftTree.right, rightTree.left)){
            return true;
        }

        return false;
    }

}
