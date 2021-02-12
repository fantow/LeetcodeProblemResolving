package NK题霸;

import java.util.HashMap;
import java.util.Map;

// 牛课上这道题有点麻烦，直接写LC上的这道吧
public class NC93 {
    public int capacity = 0;
    public int size = 0;

    // 需要自己构建一个双向链表
    class DuListNode{
        int key;
        int val;

        public DuListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        // 前置指针
        DuListNode pre;

        // 后置指针
        DuListNode next;
    }

    // 使用一个DummyNode作为队头
    DuListNode fakeHead = new DuListNode(-1,-1);

    // 再加一个DummyNode作为队尾
    DuListNode fakeTail = new DuListNode(-1,-1);


    // 使用一个Map来记录某个Key的DuListNode
    public Map<Integer,DuListNode> cacheMap = new HashMap<>();

    public static void main(String[] args) {

        NC93 lRUCache = new NC93(2);

        DuListNode head = lRUCache.fakeHead;
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);

        DuListNode temp = head;

//        System.out.println("打印:");
//        while(temp != null){
//            System.out.print(temp.key + " --> ");
//            temp = temp.next;
//        }
//        System.out.println();
//
//        lRUCache.get(1);        // --> 1
        System.out.println(lRUCache.get(1));    // --> 1

        temp = head;

//        System.out.println("打印:");
//        while(temp != null){
//            System.out.print(temp.key + " --> ");
//            temp = temp.next;
//        }
//        System.out.println();

//        System.out.println("tail: " + lRUCache.fakeTail.pre.key);

        lRUCache.put(3, 3);

        temp = head;
//        System.out.println("打印:");
//        while(temp != null){
//            System.out.print(temp.key + " --> ");
//            temp = temp.next;
//        }
//        System.out.println();

//        lRUCache.get(2);     // --> -1
        System.out.println(lRUCache.get(2));    // --> -1

        lRUCache.put(4, 4);

        System.out.println(lRUCache.get(1));    // --> -1
        System.out.println(lRUCache.get(3));    // --> 3
        System.out.println(lRUCache.get(4));    // --> 4



    }

    public NC93(int capacity){
        this.capacity = capacity;
        fakeHead.next = fakeTail;
        fakeTail.pre = fakeHead;
    }

    public int get(int key) {
        if(!cacheMap.containsKey(key)){
            return -1;
        }else {
            // 对位置进行更新
            DuListNode tempNode = cacheMap.get(key);

            tempNode.pre.next = tempNode.next;
            tempNode.next.pre = tempNode.pre;

            tempNode.pre = null;
            tempNode.next = null;

            tempNode.next = fakeHead.next;
            fakeHead.next.pre = tempNode;

            fakeHead.next = tempNode;
            tempNode.pre = fakeHead;
        }

        return cacheMap.get(key).val;
    }

    public void put(int key, int value) {
        // 如果该key当前不存在，就加入，并且移到队头
        // 如果存在，就将其直接移到队头

        DuListNode tempNode = null;

        // 如果仅是更新操作，就直接更新即可
        if(cacheMap.containsKey(key)){
            get(key);
            cacheMap.get(key).val = value;
            return;
        }

        // 如果当前已经大于等于容量
        if(size >= capacity){
            cacheMap.remove(fakeTail.pre.key);
            fakeTail.pre.pre.next = fakeTail;
            fakeTail.pre = fakeTail.pre.pre;
            size--;

//            System.out.println("删了:" + fakeTail.pre.key);
//            System.out.println("打印Map:");
//            for(Map.Entry<Integer,DuListNode> entry : cacheMap.entrySet()){
//                System.out.println(entry.getKey() + " --> " + entry.getValue().val);
//            }
//
//            System.out.println();
//            System.out.println("删掉了:" +fakeTail.pre.key);
        }

        if(!cacheMap.containsKey(key)){
            tempNode = new DuListNode(key,value);

            // 采用头插法
            tempNode.next = fakeHead.next;
            fakeHead.next.pre = tempNode;

            fakeHead.next = tempNode;
            tempNode.pre = fakeHead;

            cacheMap.put(key,tempNode);
        }
        size++;
    }

}
