package Hot100;

public class P_337 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        int result = rob(root);
        System.out.println(result);
    }

    public static int rob(TreeNode root) {
        if(root == null){
            return 0;
        }

        int[] result = dfsFunc(root);
        return Math.max(result[0],result[1]);
    }

    // 采用后序遍历
    public static int[] dfsFunc(TreeNode root){
        int[] dpArr = new int[2];
        if(root == null){
            dpArr[0] = 0;
            dpArr[1] = 0;
            return dpArr;
        }

        int[] leftResult =  dfsFunc(root.left);
        int[] rightResult =  dfsFunc(root.right);


        // 不选当前的节点
        dpArr[0] = Math.max(leftResult[0],leftResult[1]) + Math.max(rightResult[0],rightResult[1]);

        // 选当前的节点
        dpArr[1] = root.val + leftResult[0] + rightResult[0];

        return dpArr;
    }

}
