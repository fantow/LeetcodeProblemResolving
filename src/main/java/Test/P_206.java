package Test;

public class P_206 {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5};

        ListNode head = new ListNode(1);
        ListNode temp = head;

        for(int i = 0;i < nums.length;i++){
            ListNode node = new ListNode(nums[i]);
            temp.next = node;
            temp = node;
        }

//        while(head != null){
//            System.out.print(head.val + " ");
//            head = head.next;
//        }

        ListNode list = reverseList1(head);

        while(list != null){
            System.out.print(list.val + " ");
            list = list.next;
        }
    }

    // 先采用头插法
    public static ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode();

        while(head != null){
            ListNode tempNode = head.next;

            head.next = newHead.next;
            newHead.next = head;

            head = tempNode;
        }

        return newHead.next;
    }

    // 再采用递归方法
    public static ListNode reverseList1(ListNode head) {
        if(head.next == null){
            return head;
        }

        ListNode newHead = reverseList1(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
