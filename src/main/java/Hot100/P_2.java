package Hot100;

public class P_2 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(3);
        ListNode temp = list1;
        temp.next = new ListNode(7);
//        temp = temp.next;
//        temp.next = new ListNode(9);

        ListNode list2 = new ListNode(9);
        temp = list2;
        temp.next = new ListNode(2);
//        temp = temp.next;
//        temp.next = new ListNode(7);

        ListNode node = addTwoNumbers(list1, list2);

        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 一定会遍历这个链表，所以可以获取它的长度
        int length1 = 0;
        int length2 = 0;

        ListNode temp = l1;
        while(temp != null){
            length1++;
            temp = temp.next;
        }

        temp = l2;
        while(temp != null){
            length2++;
            temp = temp.next;
        }

        // 保证l1一定是最长的
        if(length1 < length2){
            temp = l2;
            l2 = l1;
            l1 = temp;
        }

        int digit = 0;
        temp = l1;


        while(l2 != null){
            int sum = 0;

            sum = l2.val + temp.val + digit;
            if(sum / 10 > 0){
                digit = sum / 10;
                temp.val = sum % 10;
            }else{
                temp.val = sum;
                digit = 0;
            }
            l2 = l2.next;
            temp = temp.next;
        }


        while(temp != null && digit != 0){
            if(temp.val + digit >= 10){
                digit = (temp.val + digit) / 10;
                temp.val = (temp.val + digit) % 10;
            }else{
                temp.val = temp.val + digit;
                digit = 0;
            }
            temp = temp.next;
        }


        if(temp == null && digit != 0){
            temp = l1;
            while(temp.next != null){
                temp = temp.next;
            }

            temp.next = new ListNode(digit);

//            if(temp.val + digit >= 10){
//                temp.val = (temp.val + digit) % 10;
//                temp.next = new ListNode((temp.val + digit) / 10);
//            }else{
//                temp.val = temp.val + digit;
//            }
        }


        return l1;
    }
}
