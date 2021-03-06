package AcWing_Leetcode.链表专题;

// 两两交换链表中的节点
public class P_24 {

    // 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    public static void main(String[] args) {
        P_24 resolve = new P_24();

        ListNode head = new ListNode(1);
        ListNode temp = head;

        temp.next = new ListNode(2);
        temp = temp.next;

        temp.next = new ListNode(3);
        temp = temp.next;

        temp.next = new ListNode(4);
        temp = temp.next;

//        temp.next = new ListNode(5);
//        temp = temp.next;

//        while(head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }

        ListNode node = resolve.swapPairs(head);

        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }

    public ListNode swapPairs1(ListNode head) {

        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);

        dummyNode.next = head;

        if(head == null){
            return head;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head.next;

        ListNode temp = dummyNode;

        while(fastPtr != null){
            temp.next = fastPtr;
            ListNode tempPtr = fastPtr.next;

            fastPtr.next = slowPtr;
            slowPtr.next = tempPtr;
            temp = slowPtr;

            slowPtr = tempPtr;
            if(slowPtr == null){
                break;
            }

            fastPtr = slowPtr.next;
        }

        return dummyNode.next;
    }

    static int COUNT = 2;
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode newHead = new ListNode();
        newHead.next = head;

        // 需要将链表整体分为三个部分：
        // 已经翻转，本次翻转，未翻转
        ListNode pre = newHead;
        ListNode next = newHead;

        int count = 0;
        while(pre.next != null){
            ListNode startPtr = pre.next;

            ListNode tempPtr = startPtr;
            for(int i = 0;i < COUNT - 1 && tempPtr != null;i++){
                tempPtr = tempPtr.next;
            }

            if(tempPtr == null){
                break;
            }

            ListNode endPtr = tempPtr;

            next = endPtr.next;

            endPtr.next = null;

            reverseFunc(startPtr);

            pre.next = endPtr;
            startPtr.next = next;

            pre = startPtr;

        }


        return newHead.next;
    }

    public ListNode reverseFunc(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode();

        ListNode temp = head;
        ListNode next = null;
        // 采用头插法
        while (temp != null) {
            next = temp.next;
            temp.next = newHead.next;
            newHead.next = temp;

            temp = next;
        }

        return newHead.next;
    }
}
