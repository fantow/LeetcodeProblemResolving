package CodeTop;

public class P_Offer22 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode temp = head;

        int[] arr = {2,3,4,5};

        for(int num : arr){
            temp.next = new ListNode(num);
            temp = temp.next;
        }

        int k = 2;

        head = getKthFromEnd(head, k);
        print(head);
    }

    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    // 让一个ptr多跑k步，再同步跑
    public static ListNode getKthFromEnd(ListNode head, int k) {

        ListNode fastPtr = head;
        ListNode slowPtr = head;

        int count = 0;

        while(count < k){
            fastPtr = fastPtr.next;
            count++;
        }

        while(fastPtr != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        return slowPtr;
    }
}
