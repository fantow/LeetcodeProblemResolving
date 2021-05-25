package CodeTop;

import java.util.*;

public class P_124 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);

//        TreeNode root = new TreeNode(0);

        int res = maxPathSum(root);
        System.out.println(res);
    }

    public static int max = Integer.MIN_VALUE;

    // 试试可不可以用543题的方法做
    public static int maxPathSum(TreeNode root){
        if(root == null){
            return 0;
        }

        dfs(root);

        return max;
    }

    public static int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(left >= 0 && right >= 0){
            max = Math.max(max,(left + right + root.val));
        }else if(left < 0 && right < 0){
            max = Math.max(max,root.val);
        }else{
            max = Math.max(max,left < 0 ? root.val + right : root.val + left);
        }

        int res = root.val;

        if(left > right){
            if(left > 0){
                res += left;
            }
        }else{
            if(right > 0){
                res += right;
            }
        }

        return res;
    }


    // 应该采用后序遍历方法，一个root的值应该为max(max(left,right),max(left,right) + root)
//    public static int maxPathSum(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//
//        Map<TreeNode,int[]> map = new HashMap<>();
//
//        postOrder(root,map);
//
//        int res = Integer.MIN_VALUE;
//
//        for(Map.Entry<TreeNode,int[]> entry : map.entrySet()){
//            res = Math.max(res,entry.getValue()[0]);
//        }
//
//        return res;
//    }


    public static void print(TreeNode root){
        if(root == null){
            return ;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        int head = 0;
        int rear = 0;

        queue.offer(root);
        rear++;

        int last = rear;

        List<List<Integer>> res = new ArrayList<>();

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
                res.add(new ArrayList<>(list));
                list = new ArrayList<>();

                last = rear;
            }
        }

        for(List<Integer> li : res){
            System.out.println(li);
        }
    }

    // 通过后序遍历修改root表示的值
//    public static void postOrder(TreeNode root,Map<TreeNode,int[]> map){
//        if(root == null){
//            return ;
//        }
//
//        postOrder(root.left,map);
//        postOrder(root.right,map);
//
//        int res = root.val;
//
//        int leftVal = Integer.MIN_VALUE;
//        int rightVal = Integer.MIN_VALUE;
//
//        // int[]
//        // 0 当前节点的最大路径，只包含左右子树的一边
//        // 1 当前节点 + 左子树最大路径
//        // 2 当前节点 + 右子树最大路径
//        int[] arr = new int[3];
//
//        if(root.left != null){
//            leftVal = Math.max(map.get(root.left)[1],map.get(root.left)[2]);
//        }
//
//        if(root.right != null){
//            rightVal = Math.max(map.get(root.right)[1],map.get(root.right)[2]);
//        }
//
//        if(res < 0){
//            if(leftVal > 0 && rightVal > 0){
//                res = res + leftVal + rightVal;
//            }else{
//                if(leftVal == Integer.MIN_VALUE || rightVal == Integer.MIN_VALUE){
//                    res = Math.max(leftVal,res);
//                    res = Math.max(rightVal,res);
//                }else {
//                    res = Math.max(leftVal,rightVal);
//                }
//            }
//        }else {
//            if(leftVal > 0){
//                res += leftVal;
//            }
//
//            if(rightVal > 0){
//                res += rightVal;
//            }
//        }
//
//        arr[0] = res;
//        arr[1] = leftVal >= 0 ? leftVal + root.val : root.val;
//        arr[2] = rightVal >= 0 ? rightVal + root.val : root.val;
//
//        map.put(root,arr);
//        return ;
//    }

}
