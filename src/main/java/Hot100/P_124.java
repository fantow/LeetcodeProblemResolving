package Hot100;

import java.util.HashMap;
import java.util.Map;

public class P_124 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//
//        TreeNode root = new TreeNode(-10);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);


//        TreeNode root = new TreeNode(-3);


//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(-2);
//        root.right = new TreeNode(-3);
//
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//
//        root.left.left.left = new TreeNode(-1);
//
//        root.right.left = new TreeNode(-2);



        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);

        root.left.right = new TreeNode(-9);

        root.right.left = new TreeNode(0);

        root.right.left.left = new TreeNode(-3);

        root.right.left.left.right = new TreeNode(-9);

        root.right.left.left.right.right = new TreeNode(2);




        int result = maxPathSum(root);
        System.out.println(result);
    }

    public static int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }

        // TreeNode --> {当前节点的最大路径,左子树最大路径和，右子树最大路径和}
        Map<TreeNode,int[]> map = new HashMap<>();

        func(root,map);

        int result = Integer.MIN_VALUE;
        for(Map.Entry<TreeNode,int[]> entry : map.entrySet()){
            int[] arr = entry.getValue();
            result = Math.max(result,arr[0]);
        }

        for(Map.Entry<TreeNode,int[]> entry : map.entrySet()){
            System.out.println(entry.getKey().val + " --> " + entry.getValue()[0] + " " + entry.getValue()[1] + " " + entry.getValue()[2]);
        }

        return result;
    }

    // 应该采用树形DP来做
    public static void func(TreeNode root, Map<TreeNode,int[]> map){
        if(root == null){
            return;
        }

        func(root.left,map);
        func(root.right,map);

        // 开始操作
        int result = root.val;

        int leftVal = Integer.MIN_VALUE;
        int rightVal = Integer.MIN_VALUE;

        // arr[0] 为当前节点的最大路径和，不参与上一层计算
        // arr[1] 为当前节点+左子树的最大路径和，参与上层计算
        // arr[2]          +右子树的最大路径和，参与上层计算
        int[] arr = new int[3];

        if(root.left != null){
            leftVal = Math.max(map.get(root.left)[1],map.get(root.left)[2]);
        }

        if(root.right != null){
            rightVal = Math.max(map.get(root.right)[1],map.get(root.right)[2]);
        }

        if(result < 0){
            if(leftVal > 0 && rightVal > 0){
                result = result + leftVal + rightVal;
            }else{
                if(leftVal == Integer.MIN_VALUE || rightVal == Integer.MIN_VALUE){
                    result = Math.max(leftVal,result);
                    result = Math.max(result,rightVal);
                }else{
                    result = Math.max(leftVal,rightVal);
                }
            }
        }else{
            if(leftVal > 0){
                result += leftVal;
            }

            if(rightVal > 0){
                result += rightVal;
            }
        }

        arr[0] = result;
        arr[1] = leftVal >= 0 ? root.val + leftVal : root.val;
        arr[2] = rightVal >= 0 ? root.val + rightVal : root.val;

        map.put(root,arr);

        return;
    }

}
