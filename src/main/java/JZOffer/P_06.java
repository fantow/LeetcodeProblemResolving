package JZOffer;

import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_06 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = null;

        int[] nodeList = {3,2};
        ListNode tempNode = head;
        for(int node : nodeList){
            ListNode no = new ListNode(node);
            no.next = tempNode.next;
            tempNode.next = no;
            tempNode = no;
        }

        int[] array = reversePrint3(head);
        for(int i : array){
            System.out.println(i);
        }

    }

    // 方法1.利用头插法
    public static int[] reversePrint(ListNode head) {

        if(head == null){
            return new int[]{};
        }

        ListNode newHead = new ListNode(-1);

        ListNode tempPtr = head;
        ListNode temp = head;

        List<Integer> result = new ArrayList<Integer>();

        while(temp != null){
            temp = tempPtr.next;
            tempPtr.next = newHead.next;
            newHead.next = tempPtr;

            tempPtr = temp;
        }

        while(newHead != null){
            result.add(newHead.val);
            newHead = newHead.next;
        }

        int[] resultArray = new int[result.size() - 1];

        for(int i = 0;i < result.size() - 1;i++){
            resultArray[i] = result.get(i + 1);
        }

        return resultArray;
    }

    // 方法2.利用栈.因为方法返回的是int[]，所以无论如何都要占用o(n)的空间复杂度.
    public static int[] reversePrint2(ListNode head){
        if(head == null){
            return new int[]{};
        }

        Stack<Integer> stack = new Stack<Integer>();
        while(head != null){
            stack.add(head.val);
            head = head.next;
        }

        int[] resultArray = new int[stack.size()];
        int i = 0;

        while(!stack.isEmpty()){
            resultArray[i++] = stack.pop();
        }

        return resultArray;
    }

    public static List<Integer> list = new ArrayList<Integer>();
    // 方法3.利用递归
    public static int[] reversePrint3(ListNode head){
        List<Integer> resultList = reverseFun(head);
        int size = resultList.size();
        int[] resultArray = new int[size];

        for(int i = 0;i < size;i++){
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }

    public static List<Integer> reverseFun(ListNode head){
        if(head != null){
            if(head.next != null){
                reverseFun(head.next);
            }
            list.add(head.val);
        }
        return list;
    }


    // 递归翻转链表
    public ListNode reverseFunction(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode nextNode = head.next;
        head.next = null;
        ListNode returnValue = reverseFunction(nextNode);
        nextNode.next = head;

        return returnValue;
    }


}
