package JZOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_55_2 {

    // <节点，该节点高度>
    public static Map<TreeNode,Integer> map = new HashMap<>();

    public static void main(String[] args) {
//        ---- test1 ----
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

//        ---- test2 ----
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(3);
//
//        root.left.left.left = new TreeNode(4);
//        root.left.left.right = new TreeNode(4);

        boolean flag = isBalanced2(root);
        System.out.println(flag);
    }

    // 方法1.从上到下递归判断
    // 缺点在于需要重复计算高度，可以通过缓存优化
    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        // 使用的是先序遍历，还是从上到下判断的

        int leftDepth = 0;
        int rightDepth = 0;

        // 其实求树高的操作是重复的，可以使用一个Map优化一下

        if(map.containsKey(root.left)){
            leftDepth = map.get(root.left);
        }else{
            leftDepth = getDepth(root.left);
            if(root.left != null){
                map.put(root.left,leftDepth);
            }
        }

        if(map.containsKey(root.right)){
            rightDepth = map.get(root.right);
        }else{
            rightDepth = getDepth(root.right);
            if(root.left != null){
                map.put(root.right,rightDepth);
            }
        }

        if(Math.abs(leftDepth - rightDepth) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        return 1 + Math.max(leftDepth,rightDepth);
    }

    // 方法2.从下到上判断
    // 利用后序遍历
    public static boolean isBalanced2(TreeNode root) {
        if(root == null){
            return true;
        }

        int result = recur(root);

        return result == -1 ? false : true;
    }

    public static int recur(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = recur(root.left);
        if(left == -1){
            return -1;
        }

        int right = recur(root.right);
        if(right == -1){
            return -1;
        }

        return Math.abs(left - right) < 2 ? Math.max(left,right) + 1: -1;
    }

}
