package Hot100;

import java.util.LinkedList;
import java.util.List;

public class P_98 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);


//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(4);
//
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);


        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        boolean flag = isValidBST(root);
        System.out.println(flag);
    }

    // 采用中序遍历判断
    public static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        List<TreeNode> list = new LinkedList<>();
        boolean flag = func(root,list);

        return flag;
    }

    public static boolean func(TreeNode root,List<TreeNode> list){
        if(root == null){
            return true;
        }

        boolean leftFlag = func(root.left,list);

        if(list.size() > 0){
            int val = list.get(list.size() - 1).val;
//            System.out.println("root: " + root.val + " val: " + val);
            if(val >= root.val){
                return false;
            }
        }

        list.add(root);

        boolean rightFlag = func(root.right,list);

        return leftFlag && rightFlag;
    }



    // 这样写是有问题的，因为只能简单判断root> left && root < right
    // 无法判断这个节点是否应该在这个子树上
    public static boolean isValidBST1(TreeNode root) {
        if(root == null){
            return true;
        }

        if(root.left != null && root.val <= root.left.val){
            return false;
        }

        if(root.right != null && root.val >= root.right.val){
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }
}
