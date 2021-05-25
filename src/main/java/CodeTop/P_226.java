package CodeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        root = invertTree(root);

        print(root);
    }

    // 通过层次遍历打印
    public static void print(TreeNode root){
        if(root == null){
            return ;
        }

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        int head = 0;
        int rear  = 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        rear++;

        int last = rear;

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
                res.add(new ArrayList<>(list));
                list = new ArrayList<>();

                last = rear;
            }
        }


        for(List<Integer> li : res){
            System.out.println(li);
        }
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }

        preOrder(root);

        return root;
    }

    public static void preOrder(TreeNode root){
        if(root == null){
            return ;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        preOrder(root.left);
        preOrder(root.right);

        return ;
    }
}
