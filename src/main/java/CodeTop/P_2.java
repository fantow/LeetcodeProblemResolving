package CodeTop;

public class P_2 {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        ListNode t1 = l1;

        ListNode l2 = new ListNode(5);
        ListNode t2 = l2;

        int[] arr1 = {4,3};
        int[] arr2 = {6,4};

//        ListNode l1 = new ListNode(9);
//        ListNode t1 = l1;
//
//        ListNode l2 = new ListNode(9);
//        ListNode t2 = l2;
//
//        int[] arr1 = {9,9,9,9,9,9};
//        int[] arr2 = {9,9,9};

        for(int num : arr1){
            t1.next = new ListNode(num);
            t1 = t1.next;
        }

        for(int num : arr2){
            t2.next = new ListNode(num);
            t2 = t2.next;
        }


//        ListNode l1 = new ListNode(5);
//        ListNode l2 = new ListNode(5);

        ListNode node = addTwoNumbers(l1, l2);
        print(node);
    }

    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


    // 其实很像是大数相加的问题
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }

        int len1 = 0;
        int len2 = 0;

        ListNode t1 = l1;
        ListNode t2 = l2;

        while(t1 != null){
            len1++;
            t1 = t1.next;
        }

        while(t2 != null){
            len2++;
            t2 = t2.next;
        }

        // 统一将长的设置为l1
        if(len1 < len2){
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }

        // 表示上一轮的进位
        int digital = 0;

        ListNode head = l1;
        ListNode lastNode = null;

        while(l1 != null && l2 != null){
            if(l1.next == null){
                lastNode = l1;
            }

            int temp = l1.val + l2.val + digital;
            digital = temp / 10;

            l1.val = temp % 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            if(l1.next == null){
                lastNode = l1;
            }
            int temp = l1.val + digital;
            digital = temp / 10;

            l1.val = temp % 10;

            l1 = l1.next;
        }

        if(digital != 0){
            lastNode.next = new ListNode(digital);
        }

        return head;
    }
}
