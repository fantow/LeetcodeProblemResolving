package JZOffer;


/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_27 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(7);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);

        TreeNode node = mirrorTree(head);

        printTreeFunc(node);

    }

    public static TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }

    public static void printTreeFunc(TreeNode head){
        if(head != null){
            System.out.println(head.val);

            printTreeFunc(head.left);
            printTreeFunc(head.right);
        }
        return ;
    }

}
