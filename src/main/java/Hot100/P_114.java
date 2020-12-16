package Hot100;

public class P_114 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
//
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        flatten(root);
        while(root != null){
            System.out.println(root.val);
            root = root.right;
        }
    }

    public static void flatten(TreeNode root) {
        if(root == null){
            return ;
        }

        func(root);

        return;
    }

    // 返回的是这个子树的链表最后一个节点
    public static TreeNode func(TreeNode root){
        if(root == null){
            return null;
        }

        // 右 --> 左 --> 根
        TreeNode leftNode = func(root.left);

        TreeNode rightNode = func(root.right);

        // 这个root的左右节点为空
        if(leftNode == null && rightNode == null){
            return root;
        }else if(leftNode == null){
            // 左节点为空，右节点不为空，直接返回即可
            return rightNode;
        }else if(rightNode == null){
            root.right = root.left;
            root.left = null;
            return leftNode;
        }

        // 如果左右节点都不为空时：

        leftNode.right = root.right;

        // 处理根节点
        root.right = root.left;
        root.left = null;

        return rightNode;
    }

}
