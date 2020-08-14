package JZOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_32_1 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(9);
        head.right = new TreeNode(20);
        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);

        int[] arrResult = levelOrder(head);
        for(int a : arrResult){
            System.out.println(a);
        }
    }

    // 层次遍历
    public static int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> resultList = new ArrayList<>();

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            resultList.add(node.val);

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }

        int[] arr = new int[resultList.size()];

        for(int i = 0;i < resultList.size();i++){
            arr[i] = resultList.get(i);
        }

        return arr;
    }
}
