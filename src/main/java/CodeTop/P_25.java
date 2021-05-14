package CodeTop;

public class P_25 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode temp = head;

        int[] arr = {2,3,4,5};
        for(int i = 0;i < arr.length;i++){
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }

//        int k = 2;
//        int k = 3;
        int k = 1;

        head = reverseKGroup(head, k);
        print(head);

    }

    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }

        // 先加一个dummy头结点
        ListNode newHead = new ListNode(-1);

        ListNode temp = head;
        ListNode curHead = newHead;
        ListNode nextHead = newHead;
        boolean isEnough = true;

        // 其实可以这样考虑，当成是部分结点的头插法
        while(temp != null){
            // 判断是否够k个节点
            ListNode curPtr = temp;
            for(int i = 0;i < k ;i++){
                if(curPtr != null){
                    curPtr = curPtr.next;
                }else{
                    isEnough = false;
                    break;
                }
            }

            if(!isEnough){
                break;
            }else{
                for(int i = 0;i < k ;i++){
                    // 更新curHead节点
                    if(i == 0){
                        nextHead = temp;
                    }

                    ListNode cur = temp.next;
                    addNodeToHead(curHead,temp);
                    temp = cur;
                }
            }

            curHead = nextHead;

        }

        if(!isEnough){
            curHead.next = temp;
        }

        return newHead.next;
    }

    // 将node结点插入到head中
    public static void addNodeToHead(ListNode head,ListNode node){
        if(head == null || node == null){
            return ;
        }

        node.next = head.next;
        head.next = node;
    }

}
