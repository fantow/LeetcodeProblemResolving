package CodeTop;

public class P_83 {
    public static void main(String[] args) {

//        ListNode head = new ListNode(1);
//        ListNode temp = head;
//
//        int[] arr = {1,2};

        ListNode head = new ListNode(1);
        ListNode temp = head;

        int[] arr = {1,2,3,3};

        for(int num : arr){
            temp.next = new ListNode(num);
            temp = temp.next;
        }

        head = deleteDuplicates(head);

        print(head);
    }

    public static void print(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        ListNode tempPtr = head;

        int lastNum = -1;

        while(tempPtr != null){
            ListNode tmp = tempPtr.next;

            if(tempPtr == head || lastNum != tempPtr.val){
                lastNum = tempPtr.val;
                temp.next = tempPtr;
                temp = temp.next;
                temp.next = null;
            }

            tempPtr = tmp;
        }

        return dummyNode.next;
    }
}
