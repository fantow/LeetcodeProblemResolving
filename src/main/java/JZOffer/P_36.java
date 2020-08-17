package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_36 {

    static NodeTwo pre,head;

    public static void main(String[] args) {
        NodeTwo head = new NodeTwo(4);
        head.left = new NodeTwo(2);
        head.right = new NodeTwo(5);

        head.left.left = new NodeTwo(1);
        head.left.right = new NodeTwo(3);

        head = treeToDoublyList(head);
        NodeTwo temp = head;

        while(head.right != temp){
            System.out.println(head.val);
            head = head.right;
        }
    }

    // 应该采用中序遍历 --> 左，根，右
    public static NodeTwo treeToDoublyList(NodeTwo root) {
        if(root == null){
            return null;
        }

        inOrderReverse(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    // 采用中序遍历
    public static void inOrderReverse(NodeTwo root){
        if(root == null){
            return;
        }
        inOrderReverse(root.left);

        if(pre != null){
            pre.right = root;
        }else{
            head = root;
        }
        root.left = pre;
        pre = root;

        inOrderReverse(root.right);

    }

}
