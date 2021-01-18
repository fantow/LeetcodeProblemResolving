package Company.ByteDance;

public class P_206 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode head = node;
        int[] arr = {2,3,4,5};

        for(int i = 0;i < arr.length;i++){
            ListNode temp = new ListNode(arr[i]);
            node.next = temp;
            node = temp;
        }

        head = reverseList2(head);

        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    static ListNode staticHead = null;
    // 递归法1
    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        reverseFunc(head);

        return staticHead;
    }

    // 递归法2
    public static ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode cur = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return cur;
    }


    public static ListNode reverseFunc(ListNode node){
        if(node.next == null){
            staticHead = node;
            return node;
        }

        ListNode n = reverseFunc(node.next);
        n.next = node;
        node.next = null;

        return node;
    }


    // 头插法
    public static ListNode reverseList1(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode newHead = new ListNode();

        while(head != null){
            ListNode next = head.next;

            head.next = newHead.next;
            newHead.next = head;

            head = next;
        }

        return newHead.next;
    }
}
