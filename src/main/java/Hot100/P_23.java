package Hot100;

import java.util.ArrayList;
import java.util.List;

public class P_23 {
    public static void main(String[] args) {

        // lists = [[1,4,5],[1,3,4],[2,6]]
        // 输出：[1,1,2,3,4,4,5,6]
//        ListNode[] lists = new ListNode[3];
//
//        int[] l1 = {1,4,5};
//        int[] l2 = {1,3,4};
//        int[] l3 = {2,6};
//
//        List<int[]> list = new ArrayList<>();
//        list.add(l1);
//        list.add(l2);
//        list.add(l3);
//
//        for(int i = 0;i < 3;i++){
//            int[] l = list.get(i);
//
//            int length = l.length;
//            ListNode node = new ListNode(l[0]);
//            ListNode temp = node;
//
//            for(int idx = 1;idx < length;idx++){
//                temp.next = new ListNode(l[idx]);
//                temp = temp.next;
//            }
//            lists[i] = node;
//        }

//        for(int i = 0;i < lists.length;i++){
//            ListNode node = lists[i];
//            while(node != null){
//                System.out.print(node.val + " ");
//                node = node.next;
//            }
//            System.out.println();
//        }

        ListNode[] lists = new ListNode[1];

        ListNode node = mergeKLists(lists);
        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();

    }

    // 多路归并排序
    public static ListNode mergeKLists(ListNode[] lists) {
        // 有几个链表
        int nums = lists.length;

        // 声明一个List维护各个ListNode的当前指向位置
        List<ListNode> headList = new ArrayList<>();
        for(ListNode node : lists){
            if(node != null){
                headList.add(node);
            }
        }

        ListNode newHead = new ListNode(Integer.MIN_VALUE);

        func(headList,newHead);

        return newHead.next;
    }

    // node为当前链表的最后一个节点
    public static void func(List<ListNode> headList,ListNode node){
        if(headList.size() == 0){
            return;
        }

        int nums = headList.size();
        ListNode temp = headList.get(0);
        int min = headList.get(0).val;
        int idx = 0;

        for(int i = 1;i < nums;i++){
            if(min > headList.get(i).val){
                temp = headList.get(i);
                min = temp.val;
                idx = i;
            }
        }

        ListNode nextTemp = temp.next;

        node.next = temp;
        node = node.next;
        temp.next = null;

        if(nextTemp == null){
            headList.remove(idx);
        }else{
            headList.set(idx,nextTemp);
        }

        func(headList, node);
        return ;
    }

}
