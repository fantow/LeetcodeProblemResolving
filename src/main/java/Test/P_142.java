package Test;

public class P_142 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        int[] nums = {2,0,-4};

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

        ListNode node = detectCycle(head);
        System.out.println(node.val);

//        while(head != null){
//            System.out.print(head.val + " ");
//            head = head.next;
//        }

    }

    // 题目应该假设了存在环
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        // 先让fast,slow指针进入环内
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null){
            slow = slow.next;
            fast = fast.next;

            if(fast != null){
                fast = fast.next;
            }

            if(fast == slow){
                break;
            }
        }

        if(fast == null){
            return null;
        }

        fast = head;

        while(fast != slow){
//            System.out.println(fast.val + " -> " + slow.val);
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
