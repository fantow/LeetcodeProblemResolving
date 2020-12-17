package Hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P_94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> integers = inorderTraversal(root);

        System.out.println(integers);
    }

    // 非递归的中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();

        if(root == null){
            return resultList;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;

        while(!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.add(p);
                p = p.left;
            }

            if(!stack.isEmpty()){
                p = stack.pop();
                resultList.add(p.val);
                p = p.right;
            }
        }

        return resultList;
    }

    // 递归中序遍历
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }

        inOrder(root,resultList);

        return resultList;
    }

    public static void inOrder(TreeNode root,List<Integer> list){
        if(root != null){
            inOrder(root.left,list);

            list.add(root.val);

            inOrder(root.right,list);
        }

        return;
    }

}
