package 算法通关40讲;


// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
public class P_235 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        TreeNode node = lowestCommonAncestor(root, root.right, root.left);

        System.out.println(node.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(p.val > q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        TreeNode node = getRootNode(root, p, q);

        return node;
    }

    // 应该采用前序遍历的方式
    public static TreeNode getRootNode(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return null;
        }

        int rootVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if (pVal == rootVal || qVal == rootVal){
            return pVal == rootVal ? p : q;
        }

        if(rootVal < pVal){
            return getRootNode(root.right,p,q);
        }else if(rootVal > qVal){
            return getRootNode(root.left,p,q);
        }else {
            return root;
        }
    }

}
