package Hot100;

public class P_226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        TreeNode left = root.left;
        TreeNode right = root.right;

        left.left = new TreeNode(1);
        left.right = new TreeNode(3);

        right.left = new TreeNode(6);
        right.right = new TreeNode(9);


        TreeNode treeNode = invertTree(root);

        printTree(treeNode);
    }

    public static void printTree(TreeNode root){
        if(root == null){
            return ;
        }

        System.out.println(root.val);

        printTree(root.left);
        printTree(root.right);
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
