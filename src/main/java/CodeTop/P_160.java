package CodeTop;

public class P_160 {
    public static void main(String[] args) {

        ListNode A = new ListNode(4);
        ListNode B = new ListNode(5);

        A.next = new ListNode(1);
        ListNode aNext = A.next;

        B.next = new ListNode(0);
        B.next.next = new ListNode(1);
        ListNode bNext = B.next.next;

        ListNode temp = new ListNode(8);
        temp.next = new ListNode(4);
        temp.next.next = new ListNode(5);

        aNext.next = temp;
        bNext.next = temp;

//        print(A);
//        print(B);

        ListNode node = getIntersectionNode(A, B);
        System.out.println(node.val);
    }

    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // 先获取到A，B的链表长度
        int length1 = 0;
        int length2 = 0;

        ListNode tempA = headA;
        ListNode tempB = headB;

        while(tempA != null){
            tempA = tempA.next;
            length1++;
        }

        while (tempB != null){
            tempB = tempB.next;
            length2++;
        }

        // 将最大的记作A
        if(length1 < length2){
            ListNode temp = headA;
            headA = headB;
            headB = temp;
            int tempLength = length1;
            length1 = length2;
            length2 = tempLength;
        }

        while(length1 > length2){
            headA = headA.next;
            length1--;
        }

        ListNode result = null;

        while(headA != null && headB != null){
            if(headA != headB){
                headA = headA.next;
                headB = headB.next;
            }else{
                result = headA;
                break;
            }
        }

        return result;
    }
}
