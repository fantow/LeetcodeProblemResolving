package CodeTop;

import java.util.Stack;

public class P_234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;

        int[] arr = {2,2,1};

        for(int num : arr){
            temp.next = new ListNode(num);
            temp = temp.next;
        }

//        print(head);

        boolean flag = isPalindrome(head);
        System.out.println(flag);
    }

    public static void print(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    // 用一个栈去判断
    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }

        Stack<Integer> stack = new Stack<>();

        ListNode temp = head;
        int length = 0;

        while(temp != null){
            length ++;
            temp = temp.next;
        }

        temp = head;

        int idx = 0;

        while(idx < length / 2){
            stack.add(temp.val);
            temp = temp.next;
            idx++;
        }

        if(length % 2 == 1){
            temp = temp.next;
        }

        while(temp != null){
            if(stack.pop() != temp.val){
                return false;
            }

            temp = temp.next;
        }

        return true;
    }
}
