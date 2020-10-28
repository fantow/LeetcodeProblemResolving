package AcWing_Leetcode.链表专题;


// 删除链表中的节点
public class P_237 {

    // 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。
    // 传入函数的唯一参数为 要被删除的节点 。
    // head = [4,5,1,9], node = 5
    // [4,1,9]

    static ListNode head ;
    public static void main(String[] args) {

        P_237 resolve = new P_237();

        head = new ListNode(4);
        ListNode temp = head;

        temp.next = new ListNode(5);
        temp = temp.next;

        temp.next = new ListNode(1);
        temp = temp.next;

        temp.next = new ListNode(9);
        temp = temp.next;

//        while(node != null){
//            System.out.println(node.val);
//            node = node.next;
//        }

//        ListNode node = new ListNode(5);
        ListNode node = new ListNode(1);

        resolve.deleteNode(node);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    // 这样写有个前提: 给了链表头结点
    public void deleteNode(ListNode node) {
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        dummyNode.next = head;

        int val = node.val;

        ListNode tempPtr = dummyNode;

        while(tempPtr.next != null){
            if(tempPtr.next.val == val){
                tempPtr.next = tempPtr.next.next;
            }
            tempPtr = tempPtr.next;
        }

        head = dummyNode.next;
    }
}
