package Hot100;

public class P_234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;

        temp.next = new ListNode(2);
        temp = temp.next;

        temp.next = new ListNode(2);
        temp = temp.next;

        temp.next = new ListNode(1);
        temp = temp.next;

        boolean flag = isPalindrome(head);
        System.out.println(flag);
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        int length = 0;

        while(fast != null){
            slow = slow.next;

            fast = fast.next;
            length += 1;
            if(fast != null){
                fast = fast.next;
                length += 1;
            }
        }

        // 对后半段进行翻转
        ListNode dummy = new ListNode(-1);
        while(slow != null){
            ListNode nextPtr = slow.next;

            slow.next = dummy.next;
            dummy.next = slow;
            slow = nextPtr;
        }
        ListNode newHead = dummy.next;

        while(newHead != null){
            if(newHead.val != head.val){
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }

        return true;
    }
}
