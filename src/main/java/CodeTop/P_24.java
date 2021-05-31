package CodeTop;

public class P_24 {
    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        ListNode temp = head;
//
//        int[] arr = {2,3,4};


        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

//        for(int num : arr){
//            temp.next = new ListNode(num);
//            temp = temp.next;
//        }

        head = swapPairs(head);

        print(head);
    }

    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }

        int idx = 0;

        ListNode temp = head;

        ListNode dummyNode = new ListNode(-1);
        ListNode preNode = dummyNode;
        ListNode nextNode = dummyNode;

        // 如果idx % 2 == 0，将node插入list
        // 如果 idx%2 == 1，将node插入前一个node的前面
        while(temp != null){
            ListNode tmp = temp.next;

            if(idx % 2 == 0){
                nextNode.next = temp;
                temp.next = null;
                nextNode = nextNode.next;
            }else{
                temp.next = preNode.next;
                preNode.next = temp;

                preNode = nextNode;
            }

            idx++;
            temp = tmp;
        }

        return dummyNode.next;
    }
}
