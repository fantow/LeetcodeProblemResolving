package CodeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_102 {
    public static void main(String[] args) {

        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(9);
        head.right = new TreeNode(20);

        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);

        List<List<Integer>> lists = levelOrder(head);

        for(List<Integer> li : lists){
            System.out.println(li);
        }
    }

    // 层次遍历记录
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();

        if(root == null){
            return resultList;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        int head = 0;
        int rear = 0;

        // 将root进队
        queue.offer(root);
        rear++;
        int last = rear;

        List<Integer> curList = new ArrayList<>();

        while(!queue.isEmpty()){

            TreeNode node = queue.poll();

            curList.add(node.val);
            head++;

            if(node.left != null){
                queue.offer(node.left);
                rear++;
            }

            if(node.right != null){
                queue.offer(node.right);
                rear++;
            }

            if(head == last) {
                last = rear;
                resultList.add(curList);

                // 清空数组
                curList = new ArrayList<>();
            }
        }

        return resultList;
    }
}
