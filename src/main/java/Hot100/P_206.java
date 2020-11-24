package Hot100;

public class P_206 {

    public static ListNode newHead = null;

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;

        temp.next = new ListNode(2);
        temp = temp.next;

        temp.next = new ListNode(3);
        temp = temp.next;

        temp.next = new ListNode(4);
        temp = temp.next;

        temp.next = new ListNode(5);
        temp = temp.next;

        ListNode node = reverseList1(head);

        while(newHead != null){
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }

    }


    public static ListNode reverseList1(ListNode head) {
        if(head.next == null){
            newHead = head;
            return head;
        }

        ListNode node = reverseList1(head.next);
        node.next = head;
        head.next = null;

        return head;
    }


    // 迭代
    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = head;
        while(head != null){
            temp = head.next;

            head.next = dummy.next;
            dummy.next = head;

            head = temp;
        }

        return dummy.next;
    }
}
