package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_25 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        int[] arr1 = {2,4};
        int[] arr2 = {3,4,6,7,9};

        for(int a1 : arr1){
            ListNode node = new ListNode(a1);
            temp1.next = node;
            temp1 = temp1.next;
        }

        for(int a2 : arr2){
            ListNode node = new ListNode(a2);
            temp2.next = node;
            temp2 = temp2.next;
        }

        ListNode head = mergeTwoLists(head1, head2);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    // 归并操作
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }

        if(l1 == null || l2 == null){
            return l1 != null ? l1 : l2;
        }

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if(l1 != null){
            temp.next = l1;
        }else{
            temp.next = l2;
        }

        return head.next;
    }
}
