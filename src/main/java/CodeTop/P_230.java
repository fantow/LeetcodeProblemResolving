package CodeTop;

import java.util.Stack;

public class P_230 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(4);
//
//        root.left.right = new TreeNode(2);

//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(6);
//
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//
//        root.left.left.left = new TreeNode(1);


//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);


        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(1);


//        int k = 1;

//        int k = 3;

//        int k = 2;

        int k = 3;

        int res = kthSmallest(root, k);
        System.out.println(res);
    }

    // 因为给定的是二叉搜索树，所以可以通过中序遍历得到顺序的结果
    public static int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }

        int count = 0;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.add(node);
                node = node.left;
            }

            if(!stack.isEmpty()){
                node = stack.pop();

                System.out.println(node.val);

                if(count == k - 1){
                    return node.val;
                }

                node = node.right;

                count++;
            }

        }

        return -1;
    }
}
