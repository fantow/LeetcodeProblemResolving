package LCEveryDay;

public class P_148 {
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

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        temp.next = new ListNode(5);
        temp = temp.next;

        temp.next = new ListNode(3);
        temp = temp.next;

        temp.next = new ListNode(4);
        temp = temp.next;

        temp.next = new ListNode(0);

        ListNode node = sortList(head);

        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }

    }

    public static ListNode mergeSort(ListNode head){
        if(head.next == null){
            return head;
        }

        // 通过快慢指针找到链表的中点
        ListNode slowPtr = head;
        ListNode fastPtr = head.next;

        while(fastPtr != null){
            fastPtr = fastPtr.next;
            if(fastPtr != null){
                fastPtr = fastPtr.next;
            }else {
                break;
            }
            slowPtr = slowPtr.next;
        }

        ListNode newRightHead = slowPtr.next;
        // 切断链表
        slowPtr.next = null;

        // 当前slowPtr指向中点
        head = mergeSort(head);
        newRightHead = mergeSort(newRightHead);
        ListNode node = sort(head,newRightHead);

        return node;
    }

    // 开始链表拼接
    public static ListNode sort(ListNode leftHead,ListNode rightHead){

//        System.out.print("左：");
//        ListNode temp = leftHead;
//        while(temp != null){
//            System.out.print(temp.val + " ");
//            temp = temp.next;
//        }
//        System.out.println();
//
//        System.out.print("右：");
//        while (temp != null){
//            System.out.print(temp.val + " ");
//            temp = temp.next;
//        }
//        System.out.println();
//
//        System.out.println("=========");

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(leftHead != null && rightHead != null){
            if(leftHead.val > rightHead.val){
                temp.next = rightHead;
                rightHead = rightHead.next;
            }else{
                temp.next = leftHead;
                leftHead = leftHead.next;
            }
            temp = temp.next;
            temp.next = null;
        }

        if(leftHead !=null){
            temp.next = leftHead;
        }else if(rightHead != null){
            temp.next = rightHead;
        }

        return dummy.next;
    }


    public static ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode node = mergeSort(head);
        return node;
    }

}
