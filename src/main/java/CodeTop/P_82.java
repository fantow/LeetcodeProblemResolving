package CodeTop;

public class P_82 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;

//        int[] arr = {2,3,3,4,4,5};
//        int[] arr = {1,1,2,3};
        int[] arr = {2,2};

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

    // 要求删除所有重复出现的元素
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tailPtr = dummy;

        ListNode prePtr = null;
        ListNode temp = head;

        while(temp != null){
//            System.out.println(temp.val);
            if(prePtr == null){
                prePtr = temp;
            }else{
                if(prePtr.val != temp.val){
                    // 将其入链表
                    tailPtr.next = prePtr;
                    tailPtr = tailPtr.next;

                    tailPtr.next = null;

                    prePtr = temp;
                }else{
//                    System.out.println("pre: " + prePtr.val + " temp: " + temp.val);
                    // 发生重复，应该将prePtr和temp指向下一个不重复节点
                    while(temp != null && temp.val == prePtr.val) {
                        temp = temp.next;
                    }

                    prePtr = temp;
//                    System.out.println("pre: " + prePtr.val + " temp: " + temp.val);
//                    System.out.println("-----");
                }
            }
            if(temp != null){
                temp = temp.next;
            }
        }

        if(prePtr != null){
            tailPtr.next = prePtr;
        }

        return dummy.next;
    }
}
