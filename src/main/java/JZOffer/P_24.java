package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        int[] arr = {2,3,4,5};
        for(int a : arr){
            ListNode node = new ListNode(a);
            temp.next = node;
            temp = node;
        }

        head = reverseList2(head);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    // 头插法,
    public static ListNode reverseList1(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode temp = head;

        while(head != null){
            temp = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = temp;
        }

        return newHead.next;
    }

    // 递归方法
    // 在递归中，返回的temp就是每次的头结点，这个头结点其实不参与链表翻转中的逻辑
    // 真正参与逻辑的是head和head.next；因为在处理一个递归中的head和head.next时，
    public static ListNode reverseList2(ListNode head) {

        ListNode node = reverse(head);
        return node;
    }

    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return temp;
    }

}
