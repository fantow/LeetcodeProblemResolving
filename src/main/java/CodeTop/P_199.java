package CodeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_199 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(4);

        List<Integer> list = rightSideView(root);
        System.out.println(list);
    }

    // 要求返回二叉树的右视图，可以先得到层次遍历结果，再取每层的最右节点
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> resList = new ArrayList<>();

        if(root == null){
            return resList;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        int head = 0;
        int rear = 0;

        queue.offer(root);
        rear++;
        int last = rear;

        List<Integer> curList = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            head++;

            curList.add(node.val);

            if(node.left != null){
                queue.offer(node.left);
                rear++;
            }

            if(node.right != null){
                queue.offer(node.right);
                rear++;
            }

            if(head == last){
                last = rear;
                resList.add(curList.get(curList.size() - 1));
                curList =  new ArrayList<>();
            }
        }

        return resList;
    }
}
