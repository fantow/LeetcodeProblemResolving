package Algo91.Chap01_数组_栈_队列;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


// 输入：root = [1,null,2,3]
// 输出：[1,3,2]
public class P_94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> list = inorderTraversal(root);

        for(Integer num : list){
            System.out.print(num + " ");
        }
    }

    // 非递归版的中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();

        if(root == null){
            return resultList;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while(!stack.isEmpty() || p != null){
            while(p != null){
                stack.add(p);
                p = p.left;
            }

            if(!stack.isEmpty()){
                p = stack.pop();

                resultList.add(p.val);
                p = p.right;
            }
        }

        return resultList;
    }


    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }

        inOrder(root,resultList);

        return resultList;
    }

    public static void inOrder(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }

        inOrder(root.left,list);

        list.add(root.val);

        inOrder(root.right,list);
    }
}
