package CodeTop;

public class P_112 {
    public static void main(String[] args) {

//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.right = new TreeNode(1);
//
//        int targetSum = 22;

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int targetSum = 5;

        boolean flag = hasPathSum(root, targetSum);
        System.out.println(flag);
    }

    // 因为这个二叉树不是排序树，所以没有左右树数据的相关性
    // 应该是用bfs去解
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        boolean flag = bfs(root, targetSum);

        return flag;
    }

    // 路径总和是根节点到叶子节点
    public static boolean bfs(TreeNode root,int target){
        if(root == null){
            return false;
        }

        // 是叶子节点
        if(root.left == null && root.right == null){
            if(root.val == target){
                return true;
            }else{
                return false;
            }
        }

        // 尝试从左子树找
        boolean leftFlag = bfs(root.left,target - root.val);

        // 尝试从右子树找
        boolean rightFlag = bfs(root.right,target - root.val);

        return leftFlag || rightFlag;
    }
}
