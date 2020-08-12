package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_26 {
    public static void main(String[] args) {

        // test1
//        TreeNode A = new TreeNode(1);
//        A.left = new TreeNode(2);
//        A.right = new TreeNode(3);
//
//        TreeNode B = new TreeNode(3);
//        B.left = new TreeNode(1);

        // test2
//        TreeNode head = new TreeNode(4);
//        head.right = new TreeNode(3);
//        TreeNode A = new TreeNode(2);
//        head.left = A;
//        A.left = new TreeNode(4);
//        A.right = new TreeNode(5);
//        TreeNode temp = A.left;
//        temp.left = new TreeNode(8);
//        temp.right = new TreeNode(9);
//
//        TreeNode B = new TreeNode(4);
//        B.left = new TreeNode(8);
//        B.right = new TreeNode(9);
//
//        boolean flag = isSubStructure(A, B);
//        System.out.println(flag);
        // test3
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        TreeNode left2 = head.left;
        TreeNode right2 = head.right;

        left2.left = new TreeNode(4);
        left2.right = new TreeNode(5);

        right2.left = new TreeNode(6);
        right2.right = new TreeNode(7);

        TreeNode left3 = left2.left;
        left3.left = new TreeNode(8);
        left3.right = new TreeNode(9);

        TreeNode B = new TreeNode(4);
        B.left = new TreeNode(8);
        B.right = new TreeNode(9);

        boolean flag = isSubStructure(head, B);
        System.out.println(flag);
    }

    // 应该是使用前序遍历
    // 采用双递归的方式
    // 先找到A中与B相同的根节点
    // 再去递归判断是否各个节点都相等
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A != null && B != null){
            return reverseSearch(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
        }
        return false;
    }

    public static boolean reverseSearch(TreeNode A,TreeNode B){
        if(B == null){
            return true;
        }

        if(A == null || A.val != B.val){
            return false;
        }

        return reverseSearch(A.left,B.left) || reverseSearch(A.right,B.right);
    }
}
