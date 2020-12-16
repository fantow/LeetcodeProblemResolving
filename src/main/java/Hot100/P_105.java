package Hot100;

import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P_105 {
    public static void main(String[] args) {
//        int[] preorder = {3,9,20,15,7};
//        int[] inorder = {9,3,15,20,7};

//        int[] preorder = {3,9,20};
//        int[] inorder = {9,3,20};

        int[] preorder = {1,2};
        int[] inorder = {2,1};

        TreeNode root = buildTree(preorder, inorder);

        printTree(root);
    }

    public static void printTree(TreeNode root){
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
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if(length == 0){
            return null;
        }

        if(length == 1){
            return new TreeNode(preorder[0]);
        }

        // 使用一个map记录下inorder中各个元素的index
        Map<Integer,Integer> map = new HashMap<>();

        // 数 --> inorder下标
        for(int i = 0;i < length;i++){
            map.put(inorder[i],i);
        }

        TreeNode root = buildTreeFunc(map, preorder, inorder,0,length - 1,0,length - 1);

        return root;
    }

    public static TreeNode buildTreeFunc(Map<Integer,Integer> map,int[] preorder,int[] inorder,
                              int preStart,int preEnd,int inStart,int inEnd){
//        if(preStart > preEnd){
//            return null;
//        }

        if(preStart == preEnd){
            TreeNode node = new TreeNode(preorder[preStart]);
            return node;
        }

        // 获取到当前子树的根节点
        TreeNode root = new TreeNode(preorder[preStart]);

        // 找到这个root在inorder中的索引
        Integer inIdx = map.get(preorder[preStart]);

        // 分别求出左右子树长度
        int leftLength = inIdx - inStart;
        int rightLenghth = inEnd - inIdx;

        if(leftLength > 0){
            root.left = buildTreeFunc(map,preorder,inorder,preStart + 1,preStart + leftLength,inIdx - leftLength,inIdx - 1);
        }

        if(rightLenghth > 0){
            root.right = buildTreeFunc(map,preorder,inorder,preStart + leftLength + 1,preStart + leftLength + rightLenghth,inIdx + 1,inIdx + rightLenghth);
        }

//        System.out.println(root.val);
        return root;
    }

}
