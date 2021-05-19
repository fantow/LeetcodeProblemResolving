package CodeTop;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P_94 {
    public static void main(String[] args) {

//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//
//        root.left.right.left = new TreeNode(6);
//        root.left.right.right = new TreeNode(7);

        TreeNode root = new TreeNode(1);

        List<Integer> res = inorderTraversal(root);

        System.out.println(res);

    }

    // 采用非递归方式实现中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null){
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null){
            // while循环地将left存入stack中
            while(root != null){
                stack.add(root);
                root = root.left;
            }

            TreeNode node = stack.pop();

            list.add(node.val);

            if(node.right != null){
                root = node.right;
            }
        }

        return list;
    }

}
