package 算法通关40讲;

import java.util.*;

public class P_102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> lists = levelOrder(root);

        for(List<Integer> list : lists){
            System.out.println(list);
        }
    }

    // 层次遍历需要使用队列
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();

        if(root == null){
            return resultList;
        }

        Deque<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        TreeNode last = root;

        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            list.add(node.val);

            if(node.left != null){
                queue.offer(node.left);
            }

            if(node.right != null){
                queue.offer(node.right);
            }

            // 到达本层最后
            if(last == node){
                resultList.add(list);
                list = new ArrayList<>();
                last = queue.peekLast();
            }
        }

        return resultList;
    }
}
