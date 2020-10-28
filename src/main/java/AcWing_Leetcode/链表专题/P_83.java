package AcWing_Leetcode.链表专题;

// 删除排序链表中的重复元素
public class P_83 {

    // 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
    // 1->1->2
    // 1->2
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode temp = head;

        temp.next = new ListNode(1);
        temp = temp.next;

        temp.next = new ListNode(2);
        temp = temp.next;

        temp.next = new ListNode(3);
        temp = temp.next;

        temp.next = new ListNode(3);
        temp = temp.next;

//        while(head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }

        P_83 node = new P_83();
        ListNode listNode = node.deleteDuplicates(head);

        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    // 给定的是排序列表
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        dummyNode.next = head;

        ListNode fastPtr = head;
        ListNode prePtr = dummyNode;

        while (fastPtr != null){
            if(prePtr.val != fastPtr.val){
                prePtr.next = fastPtr;
                prePtr = fastPtr;
            }
            fastPtr = fastPtr.next;
        }

        // 这个是解决最后几个节点是重复值
        prePtr.next = null;

        return dummyNode.next;
    }
}
