package CodeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_103 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> lists = zigzagLevelOrder(root);

        for(List<Integer> list : lists){
            System.out.println(list);
        }
    }

    // 类似于层次遍历，然后对偶数层进行reverse即可
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();

        if(root == null){
            return resList;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        int head = 0;
        int rear = 0;

        queue.offer(root);
        rear++;
        int last = rear;

        int levelNum = 0;

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
                if(levelNum % 2 != 0){
                    List<Integer> revList = new ArrayList<>();
                    for(int i = 0;i < curList.size();i++){
                        revList.add(curList.get(curList.size() - 1 - i));
                    }
                    resList.add(revList);
                }else {
                    resList.add(curList);
                }

                curList = new ArrayList<>();

                last = rear;
                levelNum++;
            }
        }

        return resList;
    }
}
