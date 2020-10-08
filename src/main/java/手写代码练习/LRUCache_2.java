package 手写代码练习;

import java.util.HashMap;
import java.util.Map;

// 不适用LinkedHashMap，实现一个LRU结构
// 用链表实现吧
public class LRUCache_2 {
    // key:key  value:Node节点
    Map<Integer,Node> map = new HashMap<>();

    // 指向队头队尾的指针
    // 头结点最好先指向一个哑结点
    Node headPtr = new Node(-1,-1);
    Node tailPtr = null;

    int capacity;

    // Node节点
    class Node {
        int key,value;
        Node pre,next;

        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }

    }

    public LRUCache_2(int capacity){
        this.capacity = capacity;
    }

    // 题目应该假设了不会put重复的值
    // 新到来的节点默认插入队尾
    public void put(int key,int value){

        Node node = new Node(key,value);
        // 这是第一个节点
        if(map.size() == 0){
            headPtr.next = node;
            node.pre = headPtr;
            tailPtr = node;
            map.put(key,node);
        }else if(map.size() < capacity){
            // 正常放入
            tailPtr.next = node;
            node.pre = tailPtr;
            tailPtr = node;
            map.put(key,node);
        }else{
            // 删除一个再放入,同一删除头结点
            Node headNode = headPtr.next;
            map.remove(headNode.key);
            headPtr.next = headNode.next;

            tailPtr.next = node;
            node.pre = tailPtr;
            tailPtr = node;
            map.put(key,node);
        }
    }

    public int get(int key) {
        if(map.size() == 0 || !map.containsKey(key)){
            return -1;
        }else if(map.size() > 1){
            Node node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;

            tailPtr.next = node;
            node.pre = tailPtr;
            tailPtr = node;
            return node.value;
        }else{
            return map.get(key).value;
        }
    }

    public static void main(String[] args) {
        LRUCache_2 cache = new LRUCache_2(2);

//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // 返回  1
//        cache.put(3, 3);    // 该操作会使得关键字 2 作废
//        System.out.println(cache.get(2));       // 返回 -1 (未找到)
//        cache.put(4, 4);    // 该操作会使得关键字 1 作废
//        System.out.println(cache.get(1));       // 返回 -1 (未找到)
//        System.out.println(cache.get(3));       // 返回  3
//        System.out.println(cache.get(4));       // 返回  4

        System.out.println(cache.get(2));
        cache.put(2,6);
        System.out.println(cache.get(1));
        cache.put(1,5);
        cache.put(1,2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));


    }

    public void printNodes(Node header){

        while(header != null){
            System.out.println(header.key + " : " + header.value);
            header = header.next;
        }
        System.out.println("---- 打印结束 ----");
    }

}
