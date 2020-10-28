package AcWing_Leetcode.链表专题;


// 旋转链表
public class P_61 {
    // 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
    // 1->2->3->4->5->NULL, k = 2
    // 4->5->1->2->3->NULL
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        int k = 0;

        ListNode temp = head;

        temp.next = new ListNode(2);
        temp = temp.next;

        temp.next = new ListNode(3);
        temp = temp.next;

        temp.next = new ListNode(4);
        temp = temp.next;

        temp.next = new ListNode(5);
        temp = temp.next;

//        while(head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }

        P_61 resolve = new P_61();

        ListNode node = resolve.rotateRight(head, k);

        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }

        // 找到倒数第k+1个节点，这个节点是新的尾节点
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        int length = 0;

        ListNode tailPtr = null;
        while(fastPtr != null){
            if(fastPtr.next == null){
                tailPtr = fastPtr;
            }
            fastPtr = fastPtr.next;
            length++;
        }
        fastPtr = head;

        k  = k % length;

        int step = 0;
        while(step < k + 1){
            fastPtr = fastPtr.next;
            step++;
        }


        while(fastPtr != null){
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }

        // 现在slowPtr指向的是新尾节点的前一个节点
        tailPtr.next = head;

        head = slowPtr.next;
        slowPtr.next = null;

        return head;
    }

}
