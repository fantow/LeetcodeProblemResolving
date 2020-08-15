package JZOffer;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P34 {

    public static List<List<Integer>> resultList = new ArrayList<>();

    public static void main(String[] args) {
//        ---- test1 ----
//        TreeNode head = new TreeNode(5);
//        head.left = new TreeNode(4);
//        head.right = new TreeNode(8);
//        head.left.left = new TreeNode(11);
//        head.left.left.left = new TreeNode(7);
//        head.left.left.right = new TreeNode(2);
//
//        head.right.left = new TreeNode(13);
//        head.right.right = new TreeNode(4);
//
//        head.right.right.left = new TreeNode(5);
//        head.right.right.right = new TreeNode(1);
//        int sum = 22;

//        ---- test2 ----
//        TreeNode head = new TreeNode(1);
//        head.left = new TreeNode(2);
//        int sum = 1;

//        ---- test3 -----
//        TreeNode head = new TreeNode(-2);
//        head.right = new TreeNode(-3);
//        int sum = -5;


//        ---- test4 ----
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(-2);
        head.right = new TreeNode(-3);

        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);

        head.right.left = new TreeNode(-2);
        head.left.left.left = new TreeNode(-1);
        int sum = -1;

        List<List<Integer>> lists = pathSum(head, sum);
        System.out.println(lists);
    }

    // 因为给定的树没有规律，所以一定要遍历所有路径
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return new ArrayList<>();
        }

        List<Integer> tempList = new ArrayList<>();
        reverseGetPath(root,sum,tempList);
        return resultList;
    }

    public static void reverseGetPath(TreeNode root,int sum,List<Integer> tempList){
        if(root == null){
            return;
        }

        // 因为树中可能含有负值，且sum也可能为负，不能用这个方法判断递归结束
//        if(sum <= 0){
//            return ;
//        }

        // 获取到当前root指向的值
        int num = root.val;
        tempList.add(num);
        if(num == sum){
            // 题目要求整个路径上的节点和 == sum
            // 所以只有num对应的节点为叶子节点，才行。
            // 但是如果num不是叶子节点，也不能直接返回，因为存在可能后面路径和为0的情况
            if(root.left == null && root.right == null){
                resultList.add(new ArrayList<Integer>(tempList));
            }else{
                reverseGetPath(root.left,sum - num,tempList);
                reverseGetPath(root.right,sum - num,tempList);
            }
        }else{
            reverseGetPath(root.left,sum - num,tempList);
            reverseGetPath(root.right,sum - num,tempList);
        }

        if(tempList.size() > 0){
            tempList.remove(tempList.size() - 1);
        }

        return;
    }

}
