package Hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();

        if(root == null){
            return lists;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        int head = 0;
        int tail = 0;

        queue.offer(root);
        tail++;
        int last = tail;

        List<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            head++;

            list.add(node.val);

            if(node.left != null){
                queue.offer(node.left);
                tail++;
            }

            if(node.right != null){
                queue.offer(node.right);
                tail++;
            }

            if(head == last){
                lists.add(list);
                list = new ArrayList<>();

                last = tail;
            }
        }

        return lists;
    }
}
