package Algo91.Chap01_数组_栈_队列;


import java.util.*;

// 需要支持插入，删除和随机获取的O(1)算法，并且可以判断出是否存在
public class P_380 {


    // 大方向应该是使用HashMap，因为这样的添加和删除时间复杂度比较低，并且可以判断当前Key是否存在
    // random应该如何做？
    /** Initialize your data structure here. */
//    public RandomizedSet() {
//
//    }

    public Map<Integer,Integer> map = new HashMap<>();
    public List<Integer> arr = new ArrayList<>();
    Random random = new Random();

    // 维护当前数组实际使用长度
    public int length = 0;

    public P_380(){

    }

    public static void main(String[] args) {
        P_380 randomSet = new P_380();
//        System.out.println(randomSet.insert(1));
//        System.out.println(randomSet.remove(2));
//        System.out.println(randomSet.insert(2));
//        System.out.println(randomSet.getRandom());
//        System.out.println(randomSet.remove(1));
//        System.out.println(randomSet.insert(2));
//        System.out.println(randomSet.getRandom());



//        System.out.println(randomSet.insert(0));
//        System.out.println(randomSet.insert(1));
//
//        System.out.println(randomSet.remove(0));
//        System.out.println(randomSet.insert(2));
//
//        System.out.println(randomSet.remove(1));
//        for(Map.Entry<Integer,Integer> entry : randomSet.map.entrySet()){
//            System.out.println(entry.getKey() + " -> " + entry.getValue());
//        }


        for(Map.Entry<Integer,Integer> entry : randomSet.map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println(randomSet.insert(0));

        for(Map.Entry<Integer,Integer> entry : randomSet.map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println(randomSet.remove(0));

        for(Map.Entry<Integer,Integer> entry : randomSet.map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println(randomSet.insert(0));
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{
            map.put(val,arr.size());
            arr.add(arr.size(),val);
        }

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        int idx = map.get(val);
        int lastElem = arr.get(arr.size() - 1);

        arr.set(idx,lastElem);
        map.put(lastElem,idx);

        arr.remove(arr.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int idx = random.nextInt(arr.size());
        return arr.get(idx);
    }

}
