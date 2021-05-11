package CodeTop;

// 链表翻转
public class P_206 {
    // 1 -> 2 -> 3 -> 4 -> 5
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        int[] arr = {2,3,4,5};

        ListNode temp = head;

        for(int num : arr){
            ListNode node = new ListNode(num);
            temp.next = node;
            temp = node;
        }

        ListNode node = reverseList(head);

        printNode(node);
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return temp;
    }


    public static void printNode(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
