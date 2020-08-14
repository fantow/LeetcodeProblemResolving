package JZOffer;

import java.util.*;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_32_3 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(9);
        head.right = new TreeNode(20);
        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);

        List<List<Integer>> resultList = levelOrder(head);
        System.out.println(resultList);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        int front = -1;
        int rear = -1;
        int last = 0;
        boolean isNewLevel = true;
        boolean isReverseOrder = false;
        List<Integer> list = null;
        List<List<Integer>> resultList = new ArrayList<>();
        TreeNode[] arr = new TreeNode[2000];

        arr[++rear] = root;

        while(front < rear){
            if(isNewLevel) {
                list = new ArrayList<>();
                isNewLevel = false;
            }
            TreeNode node = arr[++front];
            list.add(node.val);

            if(node.left != null){
                arr[++rear] = node.left;
            }
            if(node.right != null){
                arr[++rear] = node.right;
            }

            if(front == last){
                if(isReverseOrder){
                    Collections.reverse(list);
                }
                isReverseOrder = !isReverseOrder;
                resultList.add(list);
                isNewLevel = true;
                last = rear;
            }
        }

        return resultList;
    }
}
