package Hot100;

public class P_142 {
    public static void main(String[] args) {

//        ListNode head = new ListNode(3);
//        ListNode temp = head;
//
//        temp.next = new ListNode(2);
//        temp = temp.next;
//        ListNode t1 = temp;
//
//        temp.next = new ListNode(0);
//        temp = temp.next;
//
//        temp.next = new ListNode(-4);
//        temp = temp.next;
//
//        temp.next = t1;

//        ListNode head = new ListNode(1);
//        ListNode temp = head;
//
//        temp.next = new ListNode(2);
//        temp = temp.next;
//
//        temp.next = head;

//        ListNode head = new ListNode(1);


        ListNode head = new ListNode(1);
        ListNode temp = head;
        ListNode t1 = head;

        temp.next = new ListNode(2);
//        temp = temp.next;
//        temp.next = t1;

        ListNode listNode = detectCycle(head);

        if(listNode == null){
            System.out.println("null");
        }else{
            System.out.println(listNode.val);
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head.next;


        // 得到的结果只是有环，但不一定在环的开始停止
        while(slowPtr != fastPtr){
            if(fastPtr == null){
                return null;
            }

            slowPtr = slowPtr.next;

            fastPtr = fastPtr.next;
            if(fastPtr != null){
                fastPtr = fastPtr.next;
            }
        }

        int len = 1;
        fastPtr = fastPtr.next;

        // 可以获取到环的长度
        while(fastPtr != slowPtr){
            fastPtr = fastPtr.next;
            len++;
        }

        slowPtr = head;
        fastPtr = head;

        for(int i = 0;i < len - 1;i++){
            fastPtr = fastPtr.next;
        }

        while(fastPtr.next != slowPtr){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        return slowPtr;
    }
}
