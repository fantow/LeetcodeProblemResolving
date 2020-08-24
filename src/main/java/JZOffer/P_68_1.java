package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_68_1 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(6);
        head.left = new TreeNode(2);
        head.right = new TreeNode(8);

        head.left.left = new TreeNode(0);
        head.left.right = new TreeNode(4);
        head.left.right.left = new TreeNode(3);
        head.left.right.right = new TreeNode(5);

        head.right.left = new TreeNode(7);
        head.right.right = new TreeNode(9);

//        ---- test1 ----
//        TreeNode node = lowestCommonAncestor(head, head.left, head.right);


        TreeNode node = lowestCommonAncestor(head,head.left,head.left.right);

        if(node != null){
            System.out.println(node.val);
        }else{
            System.out.println("没有公共祖先");
        }
    }


    // 应该利用该树是二叉搜索树的特点
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(p == null){
            return null;
        }
        if(q == null){
            return null;
        }

        while(root != null){
            int rootVal = root.val;
            int pVal = p.val;
            int qVal = q.val;

            if(rootVal == pVal || rootVal == qVal){
                return rootVal == pVal ? p : q;
            }else if(rootVal < Math.max(pVal,qVal) && rootVal > Math.min(pVal,qVal)){
                // 如果一个大一个小
                return root;
            }else{
                // 如果两个数统一大于rootVal或者小于rootVal
                if(rootVal > pVal){
                    root = root.left;
                }else{
                    root = root.right;
                }
            }
        }

        return null;
    }
}
