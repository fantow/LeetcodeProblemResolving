package Hot100;

import com.sun.xml.internal.bind.v2.util.StackRecorder;

import java.lang.reflect.Array;
import java.util.*;

public class P_437 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right.right = new TreeNode(1);

        root.right.right = new TreeNode(11);

//        printTree(root);

        int sum = 8;
        P_437 solution = new P_437();

        int result = solution.pathSum(root, sum);
        System.out.println(result);
    }


    // 还是使用前缀和 + 回溯，如何回溯没想到
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }

        int result = recursionFunc(root, map, sum, 0);

        return result;
    }

    // Map用来记录出现这个和的次数
    Map<Integer,Integer> map = new HashMap<>();

    // 自己想的是如何区分左右子树计算出来的前缀和，这部分没想出来，其实只需要回溯时减去就行了
    public int recursionFunc(TreeNode root,Map<Integer,Integer> countMap,int target,int curSum){
        if(root == null){
            return 0;
        }

        curSum += root.val;

        int res = 0;

        res += countMap.getOrDefault(curSum - target,0);

        countMap.put(curSum,countMap.getOrDefault(curSum,0) + 1);

        res += recursionFunc(root.left, countMap, target, curSum);
        res += recursionFunc(root.right, countMap, target, curSum);

        countMap.put(curSum,countMap.get(curSum) - 1);

        return res;
    }




    public static List<List<Integer>> resultList = new ArrayList<>();

    public static void printTree(TreeNode root){
        if(root == null){
            return ;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            System.out.print(node.val + " ");

            if(node.left != null){
                queue.offer(node.left);
            }

            if(node.right != null){
                queue.offer(node.right);
            }
        }

        return;
    }

    // 因为不是二叉搜索树，所以只能遍历全部的路径
    // 可以做一个二叉树的前缀和？？？ 用回溯+前缀和
    public int pathSum1(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }

        // 将树变为累加和树
        addSumTree(root,0);

        List<Integer> tempList = new ArrayList<>();

        // 将所有结果存入一个List中
        dfs(root,tempList);

        int count = 0;
        for(List<Integer> list : resultList){
            for(int i = 0;i < list.size();i++){
                for(int j = i;j < list.size();j++){
                    if(list.get(j) - list.get(i) == sum){
                        System.out.println(i + " : " + j + " --> " + list);
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public void addSumTree(TreeNode root,int lastLevelSum){
        if(root == null){
            return;
        }

        root.val += lastLevelSum;

        addSumTree(root.left,root.val);
        addSumTree(root.right,root.val);

        return;
    }


    public void dfs(TreeNode root,List<Integer> tempList){
        if(root == null) {
            return ;
        }

        tempList.add(root.val);

        if(root.left == null && root.right == null){
            resultList.add(new ArrayList<>(tempList));
//            System.out.println("存入: " + tempList);
            tempList.remove(tempList.size() - 1);
            return;
        }else{
            dfs(root.left,tempList);
            dfs(root.right,tempList);
        }

        tempList.remove(tempList.size() - 1);

        return ;
    }


}
