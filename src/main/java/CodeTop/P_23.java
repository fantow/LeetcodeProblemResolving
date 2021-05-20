package CodeTop;

import java.util.List;

public class P_23 {
    public static void main(String[] args) {

        ListNode[] lists = new ListNode[3];

//        ListNode node1 = new ListNode(1);
//        node1.next = new ListNode(4);
//        node1.next.next = new ListNode(5);
//
//
//        ListNode node2 = new ListNode(1);
//        node2.next = new ListNode(3);
//        node2.next.next = new ListNode(4);
//
//
//        ListNode node3 = new ListNode(2);
//        node3.next = new ListNode(6);
//
//        lists[0] = node1;
//        lists[1] = node2;
//        lists[2] = node3;


        lists[0] = null;

        ListNode node = mergeKLists(lists);

        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    // 应该是链表的合并问题
    public static ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;

        // 哑结点
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);

        // 指向当前List最后一个元素
        ListNode tempNode = dummyNode;

        // 步骤:每轮选出最小的ListNode，插入新List中，修改ListNode[]中的指针
        while(true){
            int count = 0;
            // 如果所有节点都为null了，归并结束
            for(ListNode node : lists){
                if(node == null){
                    count++;
                }
            }

            if(count == size){
                return dummyNode.next;
            }

            // 选出每一轮的最小Node，插入新的List中
            ListNode tmp = null;
            int idx = -1;

            for(int i = 0;i < size;i++){
                // 如果是本轮第一次赋值
                if(lists[i] != null && tmp == null){
                    tmp = lists[i];
                    idx = i;
                    continue;
                }

                if(lists[i] != null && tmp.val > lists[i].val){
                    tmp = lists[i];
                    idx = i;
                }
            }

            if(tmp == null && idx == -1){
                return dummyNode.next;
            }

            lists[idx] = tmp.next;
            tempNode.next = tmp;

            tempNode = tempNode.next;
        }
    }
}
