package AcWing_Leetcode.链表专题;


// 删除链表的倒数第N个节点
public class P_19 {

    // 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    // 给定一个链表: 1->2->3->4->5, 和 n = 2.
    //当删除了倒数第二个节点后，链表变为 1->2->3->5.
    public static void main(String[] args) {

        P_19 node = new P_19();

        ListNode head = new ListNode(1);
        ListNode temp = head;

        temp.next = new ListNode(2);
        temp = temp.next;

        temp.next = new ListNode(3);
        temp = temp.next;

        temp.next = new ListNode(4);
        temp = temp.next;

        temp.next = new ListNode(5);


        ListNode listNode = node.removeNthFromEnd(head, 2);

        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    // 处理链表的最佳方式：添加哑结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;

        ListNode tempNode = head;

        // 注掉对n的合法值判断，时间复杂度可以达到满分
        while(tempNode != null){
            length++;
            tempNode = tempNode.next;
        }

        tempNode = head;

        // 如果长度小于需要删除的节点，操作失败
        if(length < n){
            return head;
        }

        ListNode dumpNode = new ListNode(-1);
        dumpNode.next = head;
        head = dumpNode;

        ListNode fastPtr = head;
        ListNode slowPtr = head;
        int step = 0;

        while(fastPtr != null && step < n + 1){
            fastPtr = fastPtr.next;
            step++;
        }

        while(slowPtr != null && fastPtr != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        // 进行节点的删除
        slowPtr.next = slowPtr.next.next;


        return head.next;
    }

}
