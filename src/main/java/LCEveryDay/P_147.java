package LCEveryDay;

public class P_147 {
    public static void main(String[] args) {
//        ListNode head = new ListNode(4);
//        ListNode temp = head;
//
//        temp.next = new ListNode(2);
//        temp = temp.next;
//
//        temp.next = new ListNode(1);
//        temp = temp.next;
//
//        temp.next = new ListNode(3);

//        ListNode head = new ListNode(-1);
//        ListNode temp = head;
//
//        temp.next = new ListNode(5);
//        temp = temp.next;
//
//        temp.next = new ListNode(3);
//        temp = temp.next;
//
//        temp.next = new ListNode(4);
//        temp = temp.next;
//
//        temp.next = new ListNode(0);
//        temp = temp.next;

        ListNode head = new ListNode(-2147483647);
        ListNode temp = head;

        temp.next = new ListNode(-2147483648);


        ListNode list = insertionSortList(head);


        while (list != null){
            System.out.print(list.val + " ");
            list = list.next;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);

        if(head.next == null){
            return head;
        }

        dummy.next = head;
        ListNode temp = head;
        ListNode preTemp = dummy;

        while(temp != null){
            ListNode slowPtr = dummy;
            ListNode fastPtr = dummy.next;


            if(temp.val >= preTemp.val){
                temp = temp.next;
                preTemp = preTemp.next;
                continue;
            }

            while(fastPtr != null && fastPtr != temp){
                if(slowPtr.val <= temp.val && fastPtr.val > temp.val){
                    // 找到合适的位置，跳出循环
                    break;
                }
                fastPtr = fastPtr.next;
                slowPtr = slowPtr.next;
            }

//            System.out.println("num: " + temp.val + " fast: " + fastPtr.val + " slow: " + slowPtr.val);

            if(fastPtr != temp) {
                preTemp.next = temp.next;

                // 将temp独立出来
                temp.next = null;

                slowPtr.next = temp;
                temp.next = fastPtr;

                temp = preTemp.next;
            }else{
                temp = temp.next;
                preTemp = preTemp.next;
            }
        }

        return dummy.next;
    }
}
