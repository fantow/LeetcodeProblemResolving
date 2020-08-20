package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_52 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode headB = new ListNode(5);

        headA.next = new ListNode(1);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);

        ListNode interNode = new ListNode(8);

        headA.next.next = interNode;
        headB.next.next.next = interNode;

        interNode.next = new ListNode(4);
        interNode.next.next = new ListNode(5);

        ListNode node = getIntersectionNode1(headA, headB);

        System.out.println(node.val);
    }

    // 这道题最大的坑是要求出相交的节点，而不是两个链表中值相同的节点。
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 先得到headA，headB的总长度
        // 再利用快慢指针即可
        ListNode tempA = headA;
        ListNode tempB = headB;

        int lengthA = 0;
        int lengthB = 0;

        while(tempA != null){
            lengthA++;
            tempA = tempA.next;
        }

        while(tempB != null){
            lengthB++;
            tempB = tempB.next;
        }

        tempA = headA;
        tempB = headB;

        int diff = (lengthA > lengthB) ? (lengthA - lengthB) : (lengthB - lengthA);

        while(diff > 0){
            if(lengthA > lengthB){
                tempA = tempA.next;
            }else{
                tempB = tempB.next;
            }
            diff--;
        }

        while(tempA != null && tempB != null){
            if(tempA == tempB){
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null;
    }


    // 方法2 headA遍历到结尾时，指向headB的头节点接着遍历
    //      headB遍历到结尾时，指向headA的头结点接着遍历
    //因为 若存在相交节点，相交后两个指针走的路径相同，
    // 再去遍历对方的节点，相遇时两个指针走的总路程一定一样长
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;

        // 如果没有交点，两边走完都会同时为null退出
        while(l1 != l2){
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }

        return l1;
    }

}
