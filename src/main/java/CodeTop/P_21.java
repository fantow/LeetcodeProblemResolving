package CodeTop;

public class P_21 {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);

        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);


        ListNode head = mergeTwoLists(l1, l2);
        print(head);
    }

    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // 合并有序链表
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }

        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode ptr = newHead;

        while(l1 != null && l2 != null){
            ListNode temp = null;
            if(l1.val <= l2.val){
                temp = l1.next;
                ptr.next = l1;
                l1.next = null;
                l1 = temp;
            }else{
                temp = l2.next;
                ptr.next = l2;
                l2.next = null;
                l2 = temp;
            }

            ptr = ptr.next;
        }

        if (l1 != null){
            ptr.next = l1;
        }

        if(l2 != null){
            ptr.next = l2;
        }

        return newHead.next;
    }
}
