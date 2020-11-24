package LCEveryDay;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P_222 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode left = root.left;
        TreeNode right = root.right;

        left.left = new TreeNode(4);
        left.right = new TreeNode(6);

        right.left = new TreeNode(6);

        levelOrder(root);

//        int count = countNodes1(root);
//        System.out.println(count);
    }

    public static void levelOrder(TreeNode root){
        if(root == null){
            return;
        }

        int head = 0;
        int rear = 0;
        int level = 0;


        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        rear = 1;
        int last = rear;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            head++;

            System.out.println(node.val);

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
                level++;
            }
        }
        System.out.println("level: " + level);
    }



    // 采用递归方法
    public static int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftCount = countNodes1(root.left);
        int rightCount = countNodes1(root.right);

        return 1 + leftCount + rightCount;
    }

    // 采用层次遍历
    public static int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode[] queue = new TreeNode[100];
        int head = 0;
        int rear = 0;

        queue[rear++] = root;
        int count = 1;
        while(head < rear){
            TreeNode node = queue[head++];
            if(node.left != null){
                queue[rear++] = node.left;
                count++;
            }

            if(node.right != null){
                queue[rear++] = node.right;
                count++;
            }

        }

        return count;
    }
}
