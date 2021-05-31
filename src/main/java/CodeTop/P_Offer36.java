package CodeTop;

import java.util.Stack;

public class P_Offer36 {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root = treeToDoublyList(root);

        print(root);
    }

    public static void print(Node head){
        Node temp = head;
        boolean flag = true;

        while(temp == null || temp != head || flag){
            flag = false;
            System.out.print(head.val + " ");
            head = head.right;
        }
    }

    // 将二叉搜索树改为双向链表
    public static Node treeToDoublyList(Node root) {
        if(root == null){
            return root;
        }

        Node dummyHead = new Node(-1);
        Node temp = dummyHead;

        Stack<Node> stack = new Stack<>();

        // 采用中序遍历
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()){
                root = stack.pop();

                // XX操作
                temp.right = root;
                root.left = temp;

                temp = temp.right;

                root = root.right;
            }
        }

        // 此时temp指向队尾
        temp.right = dummyHead.right;
        dummyHead.right.left = temp;

        return dummyHead.right;
    }
}
