package 手写代码练习;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_1 {
    private final LinkedHashMap<Integer,Integer> map;

    public LRUCache_1(int capacity){
        this.map = new LinkedHashMap<Integer, Integer>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return map.size() > capacity;
            }
        };
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }else{
            return map.get(key);
        }
    }

    public void put(int key,int value){
        map.put(key,value);
    }

    public static void main(String[] args) {
        LRUCache_1 cache = new LRUCache_1(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
}
