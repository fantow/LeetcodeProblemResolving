package CodeTop;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class P_146 {
    public static void main(String[] args) {

        P_146 cache = new P_146(2);

        // put(1,1)
        cache.put(1,0);

        // put(2,2)
        cache.put(2,2);

        // get()
        System.out.println(cache.get(1));

        // put(3,3)
        cache.put(3,3);

        // get()
        System.out.println(cache.get(2));

        // put(4,4)
        cache.put(4,4);

        // get()
        System.out.println(cache.get(1));

        // get
        System.out.println(cache.get(3));

        // get
        System.out.println(cache.get(4));
    }

    // 最大容量
    private int capacity;

    // 目前大小
    private int size;

    // 方便定位Node节点
    public Map<Integer,Node> cacheMap = new HashMap<>();

    // 存储实体
    // dummy头节点
    Node head = new Node(-1,-1);

    // dummy尾节点
    Node tail = new Node(-1,-1);

    public P_146(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        head.next = tail;
        tail.pre = head;
    }

    // 什么情况下才会改变Node节点的位置？
    // get，或put相同key的Node节点时
    public int get(int key) {
        // 如果当前不存在key，直接返回-1
        if(!cacheMap.containsKey(key)){
            return -1;
        }else{
            // 如果存在，则需要将Node的位置更新到tail部位
            updateNodeToTail(cacheMap.get(key));
        }
        return cacheMap.get(key).value;
    }

    // put涉及到新元素进入节点或者是对已有节点更新值
    public void put(int key, int value) {
        if(!cacheMap.containsKey(key)){
            // 容量不足
            if(size >= capacity) {
                deleteHeadNode();
                size--;
            }

            Node node = new Node(key,value);
            cacheMap.put(key,node);
            addNodeToTail(node);
            size++;
        }else{
            // 更新位置+更新值
            updateNodeToTail(cacheMap.get(key));
            cacheMap.get(key).value = value;
        }
    }

    // 双向链表节点
    class Node {
        public int key;
        public int value;

        public Node pre;
        public Node next;

        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    // 将node加入到链表尾部
    public void addNodeToTail(Node node){
        tail.pre.next = node;
        node.pre = tail.pre;

        node.next = tail;
        tail.pre = node;
    }


    // 将node更新到链表尾部
    public void updateNodeToTail(Node node){

        // 先将node从原链表分割出来，再恢复这部分链表，再更新到头部
//        System.out.println("node: " + node.value + " pre: " + node.pre.value + " next: " + node.next.value);
        node.pre.next = node.next;
        node.next.pre = node.pre;

        node.next = null;
        node.pre = null;
        addNodeToTail(node);
    }

    public void deleteHeadNode(){
        cacheMap.remove(head.next.key);
        head.next.next.pre = head;
        head.next = head.next.next;

//        head.next.pre = null;
//        head.next.next = null;

    }
}
