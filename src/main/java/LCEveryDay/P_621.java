package LCEveryDay;

import java.util.*;

public class P_621 {
    public static void main(String[] args) {
//        char[] tasks = {'A','A','A','B','B','B'};
//        int n = 2;
//        int n = 0;

//        char[] tasks = {'A','A','A','B','B'};
//        int n = 2;

//        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
//        int n = 2;

        char[] tasks = {'A','A','A','B','B','B','C','C','C','D','D','E'};
        int n = 2;

        int result = leastInterval(tasks, n);

        System.out.println(result);
    }

    public static int leastInterval(char[] tasks, int n) {
        int length = tasks.length;

        int[] countArr = new int[26];

        for(char ch : tasks){
            countArr[ch - 'A']++;
        }

        int maxValue= 0;

        for(int count : countArr){
            maxValue = Math.max(count,maxValue);
        }

        int maxCount = 0;
        for(int i : countArr){
            if(i == maxValue){
                maxCount++;
            }
        }

        return Math.max((maxValue - 1) * (n + 1) + maxCount,length);
    }


    // 这道题用堆写太复杂了
    public static int leastInterval1(char[] tasks, int n) {
        int length = tasks.length;
        if(length == 1){
            return 1;
        }

        if(n == 0){
            return length;
        }

        Map<Character,Integer> countMap = new HashMap<>();

        for(int i = 0;i < length;i++){
            countMap.put(tasks[i],countMap.getOrDefault(tasks[i],0) + 1);
        }

        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return countMap.getOrDefault(o2,0) - countMap.getOrDefault(o1,0);
            }
        });

        // 向queue中加入元素
        for(Map.Entry<Character,Integer> entry : countMap.entrySet()){
            queue.add(entry.getKey());
        }

        Character character = queue.peek();
        int levelNum = countMap.getOrDefault(character,0);
        int sumTime = 0;

        Set<Character> chars = new HashSet<>();

        // 如果题目给出n>0，就需要保证这一行一定有>n+1个不同元素
        for(int i = 0;i < levelNum - 1;i++){
            // 用来记录这一行已经加了多少个元素
            int count = 0;
//            while(!queue.isEmpty() && count <= n){
            while(!queue.isEmpty() && count <= n){
                Character poll = queue.poll();
                System.out.print("加入:" + poll + " ");
                if(countMap.get(poll) > 1) {
                    countMap.put(poll, countMap.get(poll) - 1);
                    // 将其加入set中，等待本轮结束再加回去
                    chars.add(poll);
                }
                count++;
                sumTime++;
            }
            System.out.println("本轮结束 // ");
            // 将计算过的加回去
            Iterator<Character> iterator = chars.iterator();
            while(iterator.hasNext()){
                queue.offer(iterator.next());
                iterator.remove();
            }

            if(count < n + 1){
                sumTime += n + 1 - count;
            }
        }

        System.out.println(queue);
        // 最后一行需要特别处理
        if(!queue.isEmpty()){
            sumTime += queue.size();
        }

        return sumTime;
    }
}
