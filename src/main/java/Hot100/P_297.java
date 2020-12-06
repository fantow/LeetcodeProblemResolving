package Hot100;

import java.util.*;

public class P_297 {
    public static void main(String[] args) {

        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialize = codec.serialize2(root);
        System.out.println(serialize);
        TreeNode treeNode = codec.deserialize2(serialize);
        printTree(treeNode);
    }

    // 打印
    public static void printTree(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

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


    static class Codec{
        // 使用非递归的前序遍历
        public static String serialize2(TreeNode root) {
            if(root == null){
                return "null";
            }

            Stack<TreeNode> stack = new Stack<>();

            stack.add(root);

            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                if(node != null){
                    sb.append(node.val + ",");
                }else{
                    sb.append("null,");
                    continue;
                }

                stack.push(node.right);
                stack.push(node.left);

            }
            return sb.deleteCharAt(sb.length() - 1).toString();
        }


        public static TreeNode deserialize2(String data) {
            String[] strs = data.split(",");

            if(strs[0].equals("null")){
                return null;
            }

            List<String> list = new ArrayList<>(Arrays.asList(strs));

            TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
            list.remove(0);

            root.left = func(list);
            root.right = func(list);

            return root;
        }

        public static TreeNode func(List<String> list){
            TreeNode node = null;
            if(list.get(0).equals("null")){
                list.remove(0);
                return null;
            }else{
                node = new TreeNode(Integer.parseInt(list.get(0)));
                list.remove(0);

                node.left = func(list);
                node.right = func(list);
            }

            return node;
        }


        // BFS
        public static String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();

            // 使用层次遍历序列化树结构
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node != null){
                    sb.append(node.val + ",");
                }else{
                    sb.append("null,");
                    continue;
                }

                queue.offer(node.left);

                queue.offer(node.right);
            }

            return sb.deleteCharAt(sb.length() - 1).toString();
        }

        // 按层次遍历
        public static TreeNode deserialize(String data) {
            String[] strings = data.split(",");
            if(strings.length == 0){
                return null;
            }else if(strings.length == 1){
                if(strings[0] == "null"){
                    return null;
                }else {
                    return new TreeNode(Integer.parseInt(strings[0]));
                }
            }

            Queue<TreeNode> queue = new LinkedList<>();

            // 先创建根节点
            TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
            queue.offer(root);

            for(int i = 1;i < strings.length - 1;i += 2){
                String leftVal = strings[i];
                String rightVal = strings[i + 1];

                TreeNode node = queue.poll();
                TreeNode leftNode = null;
                if(!leftVal.equals("null")){
                    leftNode = new TreeNode(Integer.parseInt(leftVal));
                    node.left = leftNode;
                    queue.offer(leftNode);
                }


                TreeNode rightNode = null;
                if(!rightVal.equals("null")){
                    rightNode = new TreeNode(Integer.parseInt(rightVal));
                    node.right = rightNode;
                    queue.offer(rightNode);
                }
            }

            return root;
        }

//        public static TreeNode createTree(String string){
//            if(string == "null"){
//                return null;
//            }else{
//                TreeNode root = new TreeNode(Integer.parseInt(string));
//
//                root.left = createTree();
//                root.right = createTree();
//            }
//
//
//            return root;
//        }
    }
}
