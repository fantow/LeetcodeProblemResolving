package CodeTop;

public class P_236 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);

        TreeNode p = root.left;

        root.right = new TreeNode(1);
        TreeNode q = root.right;

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);



        TreeNode node = lowestCommonAncestor(root, p, q);
        System.out.println(node.val);
    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode = lowestCommonAncestor(root.right,p,q);

        if(leftNode == null){
            return rightNode;
        }else if(rightNode == null){
            return leftNode;
        }

        return root;
    }
}
