package Hot100;

import java.util.List;

public class P_160 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode temp = headA;

        temp.next = new ListNode(1);
        temp = temp.next;

        ListNode t1 = temp;

        temp.next = new ListNode(8);
        temp = temp.next;

        temp.next = new ListNode(4);
        temp = temp.next;

        temp.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        temp = headB;

        temp.next = new ListNode(0);
        temp = temp.next;

        temp.next = new ListNode(1);
        temp = temp.next;

        temp.next = t1.next;

        ListNode node = getIntersectionNode(headA, headB);

        System.out.println(node.val);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode head1 = headA;
        ListNode head2 = headB;

        int length1 = 0;
        int length2 = 0;

        while (head1 != null){
            head1 = head1.next;
            length1++;
        }

        while(head2 != null){
            head2 = head2.next;
            length2++;
        }

        if(length1 < length2){
            ListNode temp = headB;
            headB = headA;
            headA = temp;
        }

        int diff = Math.abs(length1 - length2);

        for(int i = 0;i < diff;i++){
            headA = headA.next;
        }

        while(headA != null && headB != null){
            if(headA != headB){
                headA = headA.next;
                headB = headB.next;
            }else {
                break;
            }
        }

        if(headA != null && headB != null){
            return headA;
        }else{
            return null;
        }
    }
}
