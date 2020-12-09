package Hot100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P_236 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

//        printTree(root);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(3);

        TreeNode node = lowestCommonAncestor1(root, p, q);

        System.out.println("result: " + node.val);
    }

    public static void printTree(TreeNode root){
        if(root == null){
            return;
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


        return;
    }


    // 另一个更好的方法
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val){
            return root;
        }

        // 是否可以在左找到p或q
        TreeNode left = getNodeVal(root.left,p,q);

        // 是否可以在右找到p或q
        TreeNode right = getNodeVal(root.right,p,q);

        // 如果没有在左侧找到，说明p,q在右子树，否则在左子树，否则在两个不同的子树
        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }

        return root;
    }

    // 这个函数的用途在于使用后序遍历找到p或q节点
    public static TreeNode getNodeVal(TreeNode root,TreeNode p,TreeNode q){
        if(root == null || root.val == p.val || root.val == q.val){
            return root;
        }

        TreeNode left = getNodeVal(root.left,p,q);
        TreeNode right = getNodeVal(root.right,p,q);

        // p,q对于root来说，在不同的子树
        if(left != null && right != null){
            return root;
        }else if(left == null){
            return right;
        }else if(right == null){
            return left;
        }

        return null;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();

        preOrder(root,stackP,p);
        preOrder(root,stackQ,q);

//        for(TreeNode node : stackP){
//            System.out.print(node.val + " ");
//        }
//
//        System.out.println();
//
//        for(TreeNode node : stackQ){
//            System.out.print(node.val + " ");
//        }

//        if(stackP.size() < stackQ.size()){
//            Stack temp = stackP;
//            stackP = stackQ;
//            stackQ = temp;
//        }
//
        for(int i = stackP.size() - 1;i >= 0;i--){
            for(int j = stackQ.size() - 1;j >= 0;j--){
                if(stackP.get(i) == stackQ.get(j)){
                    return stackP.get(i);
                }
            }
        }

        return null;
    }

    // 其中stack中记录着所有p的父节点
    public static boolean preOrder(TreeNode root, Stack<TreeNode> stack,TreeNode p){
        if(root == null){
            return false;
        }

        // 如果找到立即返回即可
        if(root.val == p.val){
            stack.add(root);
            return true;
        }

        stack.add(root);

        if(preOrder(root.left,stack,p)){
            return true;
        }else if(preOrder(root.right,stack,p)){
            return true;
        }

        stack.pop();

        return false;
    }

}
