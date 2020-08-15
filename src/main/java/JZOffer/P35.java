package JZOffer;

import javax.lang.model.type.ArrayType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P35 {
    public static void main(String[] args) {
//        ---- test1 ----
        Node head = new Node(7);
        Node temp = head;
        List<Node> list = new ArrayList<>();
        list.add(head);
        int[] arr = {13,11,10,1};
        for(int a : arr){
            Node node = new Node(a);
            list.add(node);
            temp.next = node;
            temp = temp.next;
        }

        int[] randomList = {5,0,4,2,0};

        for(int i = 0;i < randomList.length;i++){
            if(randomList[i] >= randomList.length){
                list.get(i).random = null;
            }else {
                list.get(i).random = list.get(randomList[i]);
            }
        }
        temp = head;
        System.out.println("----- right answer -----");
        while(temp != null){
            System.out.println(temp.val + " --> " + (temp.random == null ? "null" : temp.random.val));
            temp = temp.next;
        }

        head = copyRandomList(head);
        System.out.println("----- solve answer -----");
        while(head != null){
            System.out.println(head.val + " --> " + (head.random == null ? "null" : head.random.val));
            head = head.next;
        }


    }

    // 方法1:用空间换时间，使用一个容器存储链表中各个节点。
    // 方法2:还有一种写法就是对所有节点在其后面复制一份，同样，时间复杂度是O(N)，空间复杂度O(N)

    // 这个代码使用的容器比较多，其实只需一个就行Map<Node,Node>
    //                                      --> <旧节点i，新节点i>,做两次遍历就行了
    public static Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        // 用来记录老List中 idx = i时，对应Random的Node
        List<Node> oldNodeList = new ArrayList<>();
        // 用来记录老List中 Node 对应是第几个
        Map<Node,Integer> oldNodeMap = new HashMap<>();

        // 用来记录新List的顺序
        List<Node> newNodeList = new ArrayList<>();

        Node newHead = new Node(head.val);
        Node newTemp = newHead;

        int idx = 0;
        oldNodeList.add(head.random == null ? null : head.random);
        oldNodeMap.put(head,idx++);
        oldNodeMap.put(null,null);
        newNodeList.add(newHead);

        head = head.next;
        while(head != null){
            Node node = new Node(head.val);
            newTemp.next = node;
            newTemp = newTemp.next;

            oldNodeList.add((head.random == null) ? null : head.random);
            oldNodeMap.put(head,idx++);
            newNodeList.add(node);

            head = head.next;
        }


        for(int i = 0;i < oldNodeList.size();i++){
            // 第i个新Node的random应该指向第?个新Node
            if(oldNodeList.get(i) != null){
                int index = oldNodeMap.get(oldNodeList.get(i));
                newNodeList.get(i).random = index == -1 ? null : newNodeList.get(index);
            }else{
                newNodeList.get(i).random = null;
            }
        }
        return newHead;
    }


}
