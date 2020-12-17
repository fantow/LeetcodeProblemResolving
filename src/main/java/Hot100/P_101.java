package Hot100;

import java.util.LinkedList;
import java.util.Queue;

public class P_101 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(3);


//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//
//        root.left.right = new TreeNode(3);
//
//        root.right.right = new TreeNode(3);


        TreeNode root = new TreeNode(9);

        root.left = new TreeNode(-42);
        root.right = new TreeNode(-42);

        root.left.right = new TreeNode(76);
        root.right.left = new TreeNode(76);

        root.left.right.right = new TreeNode(13);
        root.right.left.right = new TreeNode(13);

        boolean flag = isSymmetric(root);
        System.out.println(flag);
    }


    // 非递归实现
    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        int head = 0;
        int tail = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        tail++;

        int last = tail;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            head++;
            if(node != null){
                queue.offer(node.left);
                tail++;

                queue.offer(node.right);
                tail++;
            }

            // 一层遍历结束
            if(head == last){
                // 需要判断Queue中的节点是否对称
                int length = queue.size();
                if(length % 2 == 1){
                    return false;
                }

                int left = 0;
                int right = length - 1;
                TreeNode[] integers = queue.toArray(new TreeNode[length]);
                for(TreeNode node1 : integers){
                    if(node1 == null){
                        System.out.print("null ");
                    }else{
                        System.out.print(node1.val + " ");
                    }
                }
                System.out.println();
                while(left < right){
                    if(integers[left] == null && integers[right] == null){
                        left++;
                        right--;
                        continue;
                    }else if(integers[left] == null || integers[right] == null){
                        return false;
                    }else if(integers[left].val != integers[right].val){
                        return false;
                    }

                    left++;
                    right--;
                }

                last = tail;
            }
        }

        return true;
    }

    // 递归实现
    public static boolean isSymmetric1(TreeNode root) {
        if(root == null){
            return true;
        }

        return func(root,root);
    }

    public static boolean func(TreeNode leftNode,TreeNode rightNode){
        if(leftNode == null && rightNode == null){
            return true;
        }

        if(leftNode == null || rightNode == null){
            return false;
        }

        return leftNode.val == rightNode.val && func(leftNode.left,rightNode.right) && func(leftNode.right,rightNode.left);
    }
}
