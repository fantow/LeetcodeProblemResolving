package CodeTop;

import java.util.List;

public class P_142 {
    public static void main(String[] args) {
//        ListNode head = new ListNode(3);
//
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(0);
//        head.next.next.next = new ListNode(4);
//
//        head.next.next.next.next = head.next;


//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = head;

        ListNode head = new ListNode(1);

        ListNode node = detectCycle(head);
        System.out.println(node.val);
    }

    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }


    // 要求返回环的第一个节点
    public static ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }

        // 先要判断List中是否存在环
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null){
            slow = slow.next;
            fast = fast.next;

            if(fast != null){
                fast = fast.next;
            }

            if(fast == slow){
                break;
            }
        }

        if(fast == null){
            return null;
        }

        // 如果从while循环中出来，slow，fast一定当前指向的是环中的元素
        fast = head;

        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
