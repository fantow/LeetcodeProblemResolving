package CodeTop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P_144 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> list = preorderTraversal(root);

        System.out.println(list);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null){
            return list;
        }

//        preOrder1(root,list);
        preOrder2(root,list);

        return list;
    }

//    // 采用递归方法
//    public static void preOrder1(TreeNode root,List<Integer> list){
//        if(root == null){
//            return ;
//        }
//
//        list.add(root.val);
//
//        preOrder1(root.left,list);
//        preOrder1(root.right,list);
//
//        return;
//    }

    // 采用非递归方式
    public static void preOrder2(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();

            list.add(node.val);

            if(node.right != null){
                stack.add(node.right);
            }

            if(node.left != null){
                stack.add(node.left);
            }
        }

        return ;
    }

}
