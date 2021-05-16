package CodeTop;

public class P_141 {
    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);

        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;

        boolean flag = hasCycle(head);
        System.out.println(flag);
    }


    public static boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        // 采用快慢指针
        ListNode slowPtr = head;
        ListNode fastPtr = head.next;

        while(fastPtr != null){
            if(slowPtr == fastPtr){
                return true;
            }
            slowPtr = slowPtr.next;

            fastPtr = fastPtr.next;
            if(fastPtr != null){
                fastPtr = fastPtr.next;
            }
        }

        return false;
    }
}
