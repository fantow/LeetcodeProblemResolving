package CodeTop;

public class P_143 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(2);

//        int[] arr = {2,3,4};
//        int[] arr = {2,3,4,5};
//        for(int num : arr){
//            temp.next = new ListNode(num);
//            temp = temp.next;
//        }

        reorderList(head);

        print(head);
    }

    public static void print(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    // 尝试用数组记录下每个Node的引用，然后从最后开始遍历
    // 倒数第一个插到第一个后面，倒数第二个插到第二个后面
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return ;
        }

        // 先遍历一次ListNode，获取到链表的总长度
        int length = 0;
        ListNode temp = head;

        while (temp != null){
            length++;
            temp = temp.next;
        }

        ListNode[] arr = new ListNode[length];

        int idx = 0;

        temp = head;

        while(temp != null){
            arr[idx++] = temp;
            temp = temp.next;
        }

        ListNode tail = null;

        // 从后向前插节点
        for(int i = length - 1;i >= length / 2;i--){
            // 将第i个Node插入到第length - 1 - i个Node后面
            arr[i].next = arr[length - 1 - i].next;
            arr[length - 1 - i].next = arr[i];

            if(i == length / 2){
                tail = arr[length - 1 - i].next;
            }
        }

        tail.next = null;

        return ;
    }
}
