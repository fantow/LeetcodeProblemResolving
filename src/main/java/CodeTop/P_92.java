package CodeTop;

public class P_92 {
    public static void main(String[] args) {

//        ListNode head = new ListNode(1);
//        ListNode temp = head;
//
//        int[] arr = {2,3,4,5};
//
//        for(int num : arr){
//            temp.next = new ListNode(num);
//            temp = temp.next;
//        }
//
//        int left = 2;
//        int right = 4;


        ListNode head = new ListNode(5);

        int left = 1;
        int right = 1;

        head = reverseBetween(head,left,right);

        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }

    }

    // 将left~right部分的节点进行reverse
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null){
            return head;
        }

        // 添加dummy节点
        ListNode dummyHead = new ListNode(-1);

        dummyHead.next = head;

        // 如果想要将部分链表翻转，再将其拼接回去，那么需要
        // 1.翻转部分的前一个节点preNode
        // 2.翻转部分最后节点的next节点，nextNode
        // 3.开始翻转的节点 startNode
        // 4.结束翻转的节点 endNode
        ListNode preNode = null;
        ListNode nextNode = null;
        ListNode startNode = null;
        ListNode endNode = null;

        int idx = 0;
        ListNode temp = dummyHead;

        while(temp != null){
            if(idx == left - 1){
                preNode = temp;
            }

            if(idx == left){
                startNode = temp;
            }

            if(idx == right){
                endNode = temp;
                nextNode = endNode.next;
            }

            temp = temp.next;
            idx++;
        }

//        System.out.println("preNode： " + preNode.val);
//        System.out.println("nextNode： " + nextNode.val);
//        System.out.println("startNode： " + startNode.val);
//        System.out.println("endNode： " + endNode.val);

        // 采用头插法对start~end部分进行翻转
        ListNode dummyHead2 = new ListNode(-1);
        ListNode tmpPtr = startNode;
        ListNode nextPtr = startNode;

        // 翻转
        while(tmpPtr != nextNode){
            nextPtr = tmpPtr.next;
            tmpPtr.next = dummyHead2.next;
            dummyHead2.next = tmpPtr;

            tmpPtr = nextPtr;
        }


        // 拼接
        preNode.next = dummyHead2.next;
        startNode.next = nextNode;

        return dummyHead.next;
    }
}
