package Hot100;

import java.util.HashMap;
import java.util.Map;

public class P_146 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1,1);
        lruCache.put(2,2);
        int result = lruCache.get(1);
        System.out.println(result);
        lruCache.put(3,3);

        result = lruCache.get(2);
        System.out.println(result);
        lruCache.put(4,4);

        result = lruCache.get(1);
        System.out.println(result);

        result = lruCache.get(3);
        System.out.println(result);

        result = lruCache.get(4);
        System.out.println(result);



//        LRUCache lruCache = new LRUCache(1);
//        lruCache.put(2,1);
//        int result = lruCache.get(2);
//        System.out.println(result);


//        LRUCache lruCache = new LRUCache(2);
//
//        int result = lruCache.get(2);
//        System.out.println(result);
//
//        lruCache.put(2,6);
//        result = lruCache.get(1);
//        System.out.println(result);
//        lruCache.put(1,5);
//        lruCache.put(1,2);
//        result = lruCache.get(1);
//        System.out.println(result);
//
//        result = lruCache.get(2);
//        System.out.println(result);



//        LRUCache lruCache = new LRUCache(1);
//        lruCache.put(2,1);
//        int result = lruCache.get(2);
//        System.out.println(result);
//
//        lruCache.put(3,2);
//        result = lruCache.get(2);
//        System.out.println(result);
//
//        result = lruCache.get(3);
//        System.out.println(result);


//        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(2,1);
//        lruCache.put(1,1);
//
//        lruCache.put(2,3);
//        lruCache.put(4,1);
////        printList(lruCache);
////
//        int result = lruCache.get(1);
//        System.out.println(result);
//
//        result = lruCache.get(2);
//        System.out.println(result);



//        LRUCache lruCache = new LRUCache(10);
//
//        lruCache.put(10,13);
//        lruCache.put(3,17);
//        lruCache.put(6,11);
//        lruCache.put(10,5);
//        lruCache.put(9,10);
//        int result = lruCache.get(13);
//        System.out.println(result);
//
//        lruCache.put(2,19);
//        result = lruCache.get(2);
//        System.out.println(result);
//        result = lruCache.get(3);
//        System.out.println(result);
//
//        lruCache.put(5,25);
//        result = lruCache.get(8);
//        System.out.println(result);
//
//        lruCache.put(9,22);
//        lruCache.put(5,5);
//        lruCache.put(1,30);
//        result = lruCache.get(11);
//        System.out.println(result);

    }

    public static void printList(LRUCache cache){
        LRUCache.Node head = cache.head;
        while(head != null){
            System.out.print(head.key + " --> ");
            head = head.next;
        }
        System.out.println();
    }


    static class LRUCache{
        Node head;
        Node tail;
        int size;
        int capacity;

        Map<Integer,Node> map = new HashMap<>();

        // 维护一个双向链表
        class Node{
            int key;
            int value;

            Node pre;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public LRUCache(int capacity){
            // 哑结点
            this.head = new Node(-1,-1);
            this.tail = head;
            this.size = 0;
            this.capacity = capacity;
        }

        // get会更新位置，但不会导致节点被淘汰
        public int get(int key){
            if(!map.containsKey(key)){
                return -1;
            }else{
                Node node = map.get(key);

                // 还要更新这个Node的位置
                // 如果自己当前就是tail，就不用更新
                if(tail.key == key){
                    return node.value;
                }else{
                    node.pre.next = node.next;
                    node.next.pre = node.pre;

                    node.next = null;

                    node.pre = tail;
                    tail.next = node;

                    tail = node;
                }

                return node.value;
            }
        }

        // put会导致节点更新位置或者被淘汰
        public void put(int key,int value){
            // 如果包含，就不会有元素淘汰
            if(map.containsKey(key)){
                Node node = map.get(key);

                // 更新值
                node.value = value;

                // 更新节点位置
                if(key != tail.key){
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                    node.next = null;
                    node.pre = tail;
                    tail.next = node;

                    tail = node;
                }
                return;
            }else{
                // 先加入队尾，再考虑删除的问题
                Node node = new Node(key,value);
                tail.next = node;
                node.pre = tail;
                tail = node;

                size++;

                map.put(key,node);

                // 大也只会大一个，所以只需要淘汰一个
                // 从头删
                if(size > capacity){
                    map.remove(head.next.key);
                    head.next = head.next.next;
                    head.next.pre = head;
                    size--;
                }

                return;
            }
        }
    }
}
