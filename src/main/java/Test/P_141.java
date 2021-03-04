package Test;

public class P_141 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        int[] nums = {2,0,4};

        ListNode temp = head;
        ListNode tail = null;

        for(int i = 0;i < nums.length;i++){
            ListNode node = new ListNode(nums[i]);
            if(i == nums.length - 1){
                tail = node;
            }
            temp.next = node;
            temp = node;
        }

        tail.next = head.next;

        boolean flag = hasCycle(head);
        System.out.println(flag);

//        while(head != null){
//            System.out.print(head.val + " ");
//            head = head.next;
//        }

    }

    // 使用快慢指针
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null){
            slow = slow.next;

            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }

            if(fast == slow){
                return true;
            }
        }

        return false;
    }
}
