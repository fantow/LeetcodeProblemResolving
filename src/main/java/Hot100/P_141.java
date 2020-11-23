package Hot100;

public class P_141 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode temp = head;

        temp.next = new ListNode(2);
        ListNode t1 = temp.next;
        temp = temp.next;

        temp.next = new ListNode(0);
        temp = temp.next;

        temp.next = new ListNode(4);
        temp = temp.next;

        temp.next = t1;

//        ListNode head = new ListNode(1);
//        head.next = head;

        boolean flag = hasCycle(head);
        System.out.println(flag);
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        if(head.next == null){
            return false;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head.next;

        while(slowPtr != fastPtr){
            if(fastPtr == null){
                return false;
            }

            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;

            if(fastPtr != null){
                fastPtr = fastPtr.next;
            }else{
                return false;
            }
        }

        return true;
    }
}
