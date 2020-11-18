package Hot100;

public class P_21 {
    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        ListNode temp = head1;

        temp.next = new ListNode(2);
        temp = temp.next;

        temp.next = new ListNode(4);


        ListNode head2 = new ListNode(1);
        temp = head2;

        temp.next = new ListNode(3);
        temp = temp.next;

        temp.next = new ListNode(4);


        ListNode node = mergeTwoLists(head1, head2);

        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }

        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        ListNode temp = dummyNode;

        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                temp.next = l2;
                l2 = l2.next;
            }else{
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }

        while(l1 != null){
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }


        while(l2 != null){
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }

        return dummyNode.next;
    }
}
