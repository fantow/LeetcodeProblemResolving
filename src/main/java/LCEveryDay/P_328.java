package LCEveryDay;

public class P_328 {
    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        ListNode temp = head;
//
//        temp.next = new ListNode(2);
//        temp = temp.next;
//
//        temp.next = new ListNode(3);
//        temp = temp.next;
//
//        temp.next = new ListNode(4);
//        temp = temp.next;
//
//        temp.next = new ListNode(5);
//        temp.next = null;

//        2->1->3->5->6->4->7
        ListNode head = new ListNode(2);
        ListNode temp = head;

        temp.next = new ListNode(1);
        temp = temp.next;
//
        temp.next = new ListNode(3);
        temp = temp.next;

//        temp.next = new ListNode(5);
//        temp = temp.next;
//
//        temp.next = new ListNode(6);
//        temp = temp.next;
//
//        temp.next = new ListNode(4);
//        temp = temp.next;
//
//        temp.next = new ListNode(7);
//        temp = temp.next;


        ListNode node = oddEvenList(head);

        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }

    // 需要保持奇偶节点间的相对顺序
    public static ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }

        // 添加哑结点
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        // 奇数head
        ListNode oddHead = new ListNode(-1);
        ListNode oddTemp = oddHead;

        // 偶数head
        ListNode evenHead = new ListNode(-1);
        ListNode evenTemp = evenHead;

        int index = 1;

        while(head != null){
            if(index % 2 == 1){
                oddTemp.next = head;
                oddTemp = oddTemp.next;
            }else{
                evenTemp.next = head;
                evenTemp = evenTemp.next;
            }
            head = head.next;
            index++;
        }
        newHead.next = oddHead.next;
        oddTemp.next = evenHead.next;
        evenTemp.next = null;

        return newHead.next;
    }
}
