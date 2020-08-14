package JZOffer;

import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
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
public class P_32_2 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(9);
        head.right = new TreeNode(20);
        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);

        List<List<Integer>> lists = levelOrder(head);
        System.out.println(lists);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> resultList = new ArrayList<>();
        // 题目上说节点总数 <= 1000 ，但是如果通过测试，需要写到2000
        TreeNode[] arr = new TreeNode[2000];
        boolean isNewLevel = true;
        int front = -1;
        int rear = -1;
        int last = 0;
        List<Integer> list = null;

        arr[++rear] = root;

        while(front < rear){
            if(isNewLevel){
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
                resultList.add(list);
                last = rear;
                isNewLevel = true;
            }
        }

        return resultList;
    }
}
