package JZOffer;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_37 {
    public static void main(String[] args) {
//        ---- test1 ----
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);


//        ---- test2 ----
//        TreeNode root = new TreeNode(1);

//        ---- test1 ----
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        String serialize = serialize(root);
        System.out.println(serialize);
        TreeNode node = deserialize(serialize);


    }

    // Encodes a tree to a single string.
    // 应该采用层次遍历解决
    public static String serialize(TreeNode root) {
        if(root == null){
            return "[]";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder sb = new StringBuilder("[");

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                sb.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }else{
                sb.append("null,");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data == "[]"){
            return null;
        }
        data = data.substring(1, data.length() - 1);

        String[] treeNodes = data.split(",");
        if(treeNodes.length == 0){
            return null;
        }
        if(treeNodes.length == 1){
            return new TreeNode(Integer.valueOf(treeNodes[0]));
        }

        TreeNode root = new TreeNode(Integer.valueOf(treeNodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!treeNodes[i].equals("null")){
                node.left = new TreeNode(Integer.valueOf(treeNodes[i]));
                queue.add(node.left);
            }
            i++;
            if(!treeNodes[i].equals("null")){
                node.right = new TreeNode(Integer.valueOf(treeNodes[i]));
                queue.add(node.right);
            }
            i++;
        }

        return root;
    }
}
