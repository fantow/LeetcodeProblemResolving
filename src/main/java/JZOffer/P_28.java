package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_28 {
    public static void main(String[] args) {
//        TreeNode head = new TreeNode(1);
//        head.left = new TreeNode(2);
//        head.right = new TreeNode(2);
//        head.left.left = new TreeNode(3);
//        head.left.right = new TreeNode(4);
//
//        head.right.left = new TreeNode(4);
//        head.right.right = new TreeNode(3);

//        TreeNode head = new TreeNode(1);
//        head.left = new TreeNode(0);


        TreeNode head = new TreeNode(2);
        head.left = new TreeNode(3);
        head.right = new TreeNode(3);

        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);

        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(4);

        head.left.left.left = null;
        head.left.left.right = null;

        head.left.right.left = new TreeNode(8);
        head.left.right.right = new TreeNode(9);

        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(4);

        head.right.left.left = new TreeNode(9);
        head.right.left.right = new TreeNode(8);

        boolean flag = isSymmetric(head);
        System.out.println(flag);

//        TreeNode mirrorTree = getMirrorTree(head.right);
//        printFunc(head.left);
//        System.out.println("----");
//        printFunc(mirrorTree);
//
//        boolean flag = preOrderJudge(head.left, mirrorTree);
//        System.out.println(flag);
    }

    // 比较方便的方式就是先对一半的树镜像翻转，再去判断和另一半是否相等
    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        if((root.left != null) ^ (root.right != null)){
            return false;
        }

        if(root.left.val != root.right.val){
            return false;
        }

        // 获取到镜像树
        TreeNode mirrorTree = getMirrorTree(root.right);

        boolean result = preOrderJudge(root.left, mirrorTree);

        return result;
    }

    public static TreeNode getMirrorTree(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        getMirrorTree(root.left);
        getMirrorTree(root.right);

        return root;
    }


    public static boolean preOrderJudge(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 != null && t2 != null){
            if(t1.val != t2.val){
                return false;
            }

            return preOrderJudge(t1.left,t2.left) && preOrderJudge(t1.right,t2.right);
        }

        return false;
    }

    public static void printFunc(TreeNode t1){
        if(t1 != null){
            System.out.println(t1.val);

            printFunc(t1.left);
            printFunc(t1.right);
        }
        return ;
    }
}
