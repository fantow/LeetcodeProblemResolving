package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_22 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        int[] arr = {2,3,4,5};
        int k = 1;
        for(int a : arr){
            ListNode node = new ListNode(a);
            temp.next = node;
            temp = node;
        }

        head = getKthFromEnd(head,k);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    // 利用快慢指针
    // 因为需要考虑首节点被删除，所以引入冗余头结点
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null){
            return null;
        }

        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode slowPtr = newHead;
        ListNode fastPtr = newHead.next;

        int count = 1;

        while(fastPtr != null && count < k){
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
