package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_54 {

    public static int result = -1;
    public static int count = 0;
    public static int localK = -1;
    public static void main(String[] args) {
//        ---- test1 ----
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(1);
        head.right = new TreeNode(4);
        head.left.right = new TreeNode(2);
        int k = 4;

        int result = kthLargest(head, k);
        System.out.println(result);
    }

    public static int kthLargest(TreeNode root, int k) {
        if (root == null){
            return -1;
        }

        count = k;

        dfs(root);
        return result;
    }

    // 还有一种思路就是，递归函数返回的是该root节点是树中的第几个节点，因为采用的中序逆序遍历，所以结果也是第kth大的节点
    public static void dfs(TreeNode root){
        if(root == null){
            return;
        }

        dfs(root.right);

        if(count == 0){
            return ;
        }

        if(--count == 0){
            result = root.val;
        }
        dfs(root.left);

    }

    public static int kthLargest2(TreeNode root, int k) {
        if (root == null){
            return -1;
        }

        localK = k;

        dfs(root);
        return result;
    }

    public static int getNumForRoot(TreeNode root){
        if(root == null){
            return 0;
        }

        // 获得root右子树中节点的总个数
        int rightNum = getNumForRoot(root.right);

        count += rightNum + 1;

        if(count == localK){
            result = root.val;
            System.out.println(result);
            // 这个返回什么？很难确定
            return root.val;
        }

        int leftNum = getNumForRoot(root.left);

        return 1 + leftNum + rightNum;
    }


}
