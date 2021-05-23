package CodeTop;

public class P_19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        ListNode temp = head;
//
//        int[] arr = {2,3,4,5};
//
//        for(int num : arr){
//            temp.next = new ListNode(num);
//            temp = temp.next;
//        }

//        int n = 2;
        int n = 1;

        head = removeNthFromEnd(head,n);
        print(head);

    }

    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    // 删除倒数第n个节点
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 两次遍历即可
        int length = 0;

        ListNode temp = head;

        while (temp != null){
            length++;
            temp = temp.next;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        temp = dummyHead;

        int idx = 0;
        while (idx < (length - n)){
            temp = temp.next;
            idx++;
        }

        temp.next = temp.next.next;

        return dummyHead.next;
    }
}
