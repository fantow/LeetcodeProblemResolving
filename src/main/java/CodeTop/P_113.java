package CodeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_113 {
    public static void main(String[] args) {

//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(1);

//        int targetSum = 22;

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int targetSum = 5;

//        printTree(root);

        List<List<Integer>> res = pathSum(root, targetSum);

        for(List<Integer> list : res){
            System.out.println(list);
        }
    }

    // 采用层次遍历遍历树
    public static void printTree(TreeNode root){
        List<List<Integer>> lists = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        int head = 0;
        int rear = 0;

        queue.offer(root);
        rear++;
        int last = rear;

        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            head++;

            list.add(node.val);

            if(node.left != null){
                queue.offer(node.left);
                rear++;
            }

            if(node.right != null){
                queue.offer(node.right);
                rear++;
            }

            if(head == last){
                lists.add(new ArrayList<>(list));
                list = new ArrayList<>();

                last = rear;
            }
        }

        for(List<Integer> li : lists){
            System.out.println(li);
        }
    }

    // 看来只能用bfs
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        bfs(root,targetSum,root.val,res,list);

        return res;
    }

    // bfs + 回溯
    public static void bfs(TreeNode root,int targetSum,int curSum,List<List<Integer>> res,List<Integer> list){
        if(root == null){
            return ;
        }

        // 必须是叶子节点
        if(targetSum == curSum && root.left == null && root.right == null){
            res.add(new ArrayList<>(list));
            return;
        }

        // 加入左节点
        if(root.left != null){
            list.add(root.left.val);
            bfs(root.left,targetSum,curSum + root.left.val,res,list);
            list.remove(list.size() - 1);
        }

        // 加入右节点
        if(root.right != null){
            list.add(root.right.val);
            bfs(root.right,targetSum,curSum + root.right.val,res,list);
            list.remove(list.size() - 1);
        }

        return ;
    }
}
