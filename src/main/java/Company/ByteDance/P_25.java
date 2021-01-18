package Company.ByteDance;

import Hot100.P_4;

public class P_25 {
    public static void main(String[] args) {
        ListNode node = new ListNode();

        int[] arr = {1,2,3,4,5};
        int k = 2;

        ListNode temp = node;
        for(int i = 0;i < arr.length;i++){
            ListNode n1 = new ListNode(arr[i]);
            temp.next = n1;

            temp = temp.next;
        }

        node = node.next;

        node = reverseKGroup1(node, k);
//        node = reverseListNode(node);

        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();

    }

    static ListNode nHead = null;

    // 试试最简单的头插法
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return head;
        }

        ListNode newHead = new ListNode();

        newHead.next = head;

        ListNode pre = newHead;
        ListNode end = newHead;

        while(end.next != null){
            for(int i = 0;i < k && end != null;i++){
                end = end.next;
            }

            if(end == null){
                break;
            }

            // 反转的开始
            ListNode start = pre.next;

            // 反转部分之后的next
            ListNode next = end.next;

            end.next = null;

            pre.next = reverseFunc(start);
            start.next = next;

            pre = start;
            end = pre;
        }

        return newHead.next;
    }

//    public static ListNode reverseKGroup(ListNode head, int k) {
//        if(head == null){
//            return null;
//        }
//
//        ListNode newHead = new ListNode();
//        newHead.next = head;
//
//        count = k - 1;
//
//        reverseFunc(head);
//
//        return newHead.next;
//    }


    // reverse这里用的是头插法
    public static ListNode reverseFunc(ListNode head){
        ListNode newHead = new ListNode();

        while(head != null){
            ListNode temp = head.next;
            head.next = newHead.next;

            newHead.next = head;
            head = temp;
        }

        return newHead.next;
    }


    public static ListNode reverseKGroup1(ListNode head, int k) {
        if(head == null){
            return null;
        }

        ListNode newHead = new ListNode();

        newHead.next = head;

        ListNode pre = newHead;
        ListNode end = newHead;

        while(end != null){
            for(int i = 0;i < k && end != null;i++){
                end = end.next;
            }

            if(end == null){
                break;
            }

            ListNode start = pre.next;
            ListNode next = end.next;

            end.next = null;

            pre.next = reverseFunc(start);

            start.next = next;

            pre = start;
            end = pre;
        }

        return newHead.next;
    }



}
