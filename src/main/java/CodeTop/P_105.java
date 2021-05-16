package CodeTop;

import java.util.HashMap;
import java.util.Map;

public class P_105 {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode treeNode = buildTree(preorder, inorder);

        preOrder(treeNode);
    }

    // 前序遍历，打印一下树结构
    public static void preOrder(TreeNode root){
        if(root != null){
            System.out.print(root.val + " ");

            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;

        // 用来记录Node的各个inorder位置
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < length;i++){
            map.put(inorder[i],i);
        }

        TreeNode root = buildTreeFunc(map, preorder, inorder, 0, length - 1, 0, length - 1);

        return root;
    }

    public static TreeNode buildTreeFunc(Map<Integer,Integer> map, int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart == preEnd){
            TreeNode node = new TreeNode(preorder[preStart]);
            return node;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int idx = map.get(preorder[preStart]);

        int leftLength = idx - inStart;
        int rightLength = inEnd - idx;

        if(leftLength > 0){
            root.left = buildTreeFunc(map,preorder,inorder,preStart + 1,preStart + leftLength, idx - leftLength,idx - 1);
        }

        if(rightLength > 0){
            root.right = buildTreeFunc(map,preorder,inorder,preStart + leftLength + 1,preStart + leftLength + rightLength,idx + 1,idx + rightLength);
        }

        return root;
    }
}
