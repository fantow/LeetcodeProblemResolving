package LCEveryDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_86 {
    public static void main(String[] args) {
        int[] nums = {1,4,3,2,5,2};

        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }

        ListNode head = new ListNode(list.get(0));
        ListNode temp = head;
        for(int i = 1;i < nums.length;i++){
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }

        int x = 1;

        ListNode node = partition(head, x);

        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    // 目前的想法是：将链表拆分为两个，最后合并
    public static ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }

        ListNode smallHead = new ListNode(-1);
        ListNode otherHead = new ListNode(-1);

        ListNode smallTemp = smallHead;
        ListNode otherTemp = otherHead;

        while(head != null){
            ListNode temp = head.next;
//            System.out.print(head.val + " ");
            if(head.val < x){
                smallTemp.next = head;
                smallTemp = smallTemp.next;
            }else {
                otherTemp.next = head;
                otherTemp = otherTemp.next;
            }
            head.next = null;
            head = temp;
        }

        // 需要考虑两个链表分别为空的场景
        if(smallHead.next == null){
            return otherHead.next;
        }

        while(smallTemp.next != null){
            smallTemp = smallTemp.next;
        }

        smallTemp.next = otherHead.next;

        return smallHead.next;
    }
}
