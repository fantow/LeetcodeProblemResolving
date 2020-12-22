package LCEveryDay;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_103 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        List<List<Integer>> lists = zigzagLevelOrder(root);

        for(List<Integer> list : lists){
            for(Integer num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }

        int head = 0;
        int tail = 0;

        int level = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        tail++;
        int last = tail;

        List<Integer> tempList = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            head++;
            tempList.add(node.val);

            if(node.left != null){
                queue.offer(node.left);
                tail++;
            }

            if(node.right != null){
                queue.offer(node.right);
                tail++;
            }

            if(head == last){
                // 需要翻转tempList
                if(level % 2 == 0){
                    int length = tempList.size();
                    for(int i = 0;i < length / 2;i++){
                        int temp = tempList.get(i);
                        tempList.set(i,tempList.get(length - 1 - i));
                        tempList.set(length - 1 - i,temp);
                    }
                }
                level++;
                resultList.add(tempList);
                tempList = new ArrayList<>();
                last = tail;
            }
        }
        return resultList;
    }
}
