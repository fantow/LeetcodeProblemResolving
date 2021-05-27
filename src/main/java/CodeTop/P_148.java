package CodeTop;

public class P_148 {
    public static void main(String[] args) {
//        ListNode head = new ListNode(4);
//        ListNode temp = head;
//
//        int[] arr = {2,1,3};

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        int[] arr = {5,3,4,0};

        for(int num : arr){
            temp.next = new ListNode(num);
            temp = temp.next;
        }

        head = sortList(head);

        print(head);

    }

    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    // 应该是用归并排序做
    public static ListNode sortList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode node = mergeSort(head);

        return node;
    }

    public static ListNode mergeSort(ListNode head){
        if(head.next == null){
            return head;
        }


        // 用快慢指针，将head链表截断
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }else{
                break;
            }
            slow = slow.next;
        }

        // 将链表截断
        ListNode rightHead = slow.next;
        slow.next = null;

        head = mergeSort(head);
        rightHead = mergeSort(rightHead);

        ListNode node = merge(head,rightHead);

        return node;
    }

    public static ListNode merge(ListNode left,ListNode right){
        if(left == null || right == null){
            return left == null ? right : left;
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        ListNode leftPtr = left;
        ListNode leftTmp = leftPtr;

        ListNode rightPtr = right;
        ListNode rightTmp = rightPtr;

        while(leftPtr != null && rightPtr != null){
            if(leftPtr.val <= rightPtr.val){
                leftTmp = leftPtr.next;

                temp.next = leftPtr;
                temp = temp.next;
                temp.next = null;

                leftPtr = leftTmp;
            }else{
                rightTmp = rightPtr.next;

                temp.next = rightPtr;
                temp = temp.next;
                temp.next = null;

                rightPtr = rightTmp;
            }
        }

        while(leftPtr != null){
            leftTmp = leftPtr.next;

            temp.next = leftPtr;
            temp = temp.next;
            temp.next = null;

            leftPtr = leftTmp;
        }

        while(rightPtr != null){
            rightTmp = rightPtr.next;

            temp.next = rightPtr;
            temp = temp.next;
            temp.next = null;

            rightPtr = rightTmp;
        }

        return dummy.next;
    }
}
