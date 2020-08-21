package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_55_1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = maxDepth1(root);
        System.out.println(result);
    }

    // 方法1.递归方法
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth,rightDepth);
    }

    // 方法2.非递归方法，用层次遍历的代码改
    public static int maxDepth1(TreeNode root){
        if(root == null){
            return 0;
        }

        TreeNode[] queue = new TreeNode[10000];
        int level = 0;
        int front = -1;
        int rear = -1;
        int last = 0;

        // 首节点入队
        queue[++rear] = root;

        while(front < rear){
            TreeNode node = queue[++front];

            if(node.left != null){
                queue[++rear] = node.left;
            }

            if(node.right != null){
                queue[++rear] = node.right;
            }

            if(front == last){
                last = rear;
                level++;
            }
        }

        return level;
    }



}
