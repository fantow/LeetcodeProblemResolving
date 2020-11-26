package Hot100;

import AcWing_Leetcode.链表专题.P_19;

import java.util.*;

public class P_538 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        TreeNode left = root.left;

        root.right = new TreeNode(6);
        TreeNode right = root.right;

        left.left = new TreeNode(0);
        left.right = new TreeNode(2);
        left.right.right = new TreeNode(3);

        right.left = new TreeNode(5);
        right.right = new TreeNode(7);
        right.right.right = new TreeNode(8);

        TreeNode node = convertBST(root);

        printTree(node);

    }

    public static void printTree(TreeNode root){
        if(root == null){
            return ;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if(node.left != null){
                queue.offer(node.left);
            }

            if(node.right != null){
                queue.offer(node.right);
            }
        }

        return ;
    }

    public static List<Integer> number = new ArrayList<>();
    static {
        number.add(0);
    }

    // 使用递归方法
    public static TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }

        convertBST(root.right);

        root.val += number.get(0);
        number.set(0,root.val);

        convertBST(root.left);
        return root;
    }

    // 右 -> 根 -> 左
    // 使用修改后的非递归遍历方式
    public static TreeNode convertBST1(TreeNode root) {
        if(root == null){
            return null;
        }

        number.add(0);

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.add(node);
                node = node.right;
            }

            if(!stack.isEmpty()){
                node = stack.pop();
                // 访问node
                node.val += number.get(0);
                number.set(0,node.val);

                node = node.left;
            }
        }

        return root;
    }


//    public static void func(TreeNode root,int tempSum){
//        if(root == null){
//            return;
//        }
//
//        func(root.right,tempSum);
//
//        tempSum += root.val;
//        System.out.print(tempSum + " ");
//
//        func(root.left,tempSum);
//
//        return;
//    }
}
