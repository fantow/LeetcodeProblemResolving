package JZOffer;

import sun.java2d.pipe.SpanShapeRenderer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
// 需要考虑的一个场景是，从头删，所以需要一个冗余结点
public class P_18 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode tempHead = head;
        int[] arr = {5,1,9};
        for(int a : arr){
            ListNode node = new ListNode(a);
            tempHead.next = node;
            tempHead = node;
        }

        int val = 9;
        head = deleteNode(head, val);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return head;
        }

        ListNode newHeader = new ListNode(-1);
        newHeader.next = head;

        ListNode fastPointer = newHeader.next;
        ListNode slowPointer = newHeader;

        while(fastPointer != null) {
            if (fastPointer.val == val) {
                break;
            } else {
                fastPointer = fastPointer.next;
                slowPointer = slowPointer.next;
            }
        }

        // 没找到
        if(fastPointer == null){
            return null;
        }else{
            slowPointer.next = fastPointer.next;

        }
        return newHeader.next;
    }
}
