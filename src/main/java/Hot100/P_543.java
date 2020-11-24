package Hot100;

public class P_543 {

    public static int maxDistance = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        TreeNode leftRoot = root.left;

        root.right = new TreeNode(3);

        leftRoot.left = new TreeNode(4);
        leftRoot.right = new TreeNode(5);

        int i = diameterOfBinaryTree(root);

        System.out.println(maxDistance);
    }

    // 对于每个子树的根节点，找到其左边最深节点，再找到右边最深节点，得到的和就是最大路径
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftDept = diameterOfBinaryTree(root.left);
        int rightDept = diameterOfBinaryTree(root.right);

        maxDistance = Math.max(maxDistance,leftDept + rightDept);

        return Math.max(leftDept,rightDept) + 1;
    }
}
