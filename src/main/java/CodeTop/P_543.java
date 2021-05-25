package CodeTop;

public class P_543 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int res = diameterOfBinaryTree(root);
        System.out.println(res);
    }

    public static int depth = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        dfs(root);

        return depth - 1;
    }

    public static int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        depth = Math.max(depth,(left+ right + 1));

        return Math.max(left,right) + 1;
    }

}
