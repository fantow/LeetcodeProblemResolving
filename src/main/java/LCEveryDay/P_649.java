package LCEveryDay;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P_649 {
    public static void main(String[] args) {
//        String senate = "RD";
//        String senate = "RDD";
//        String senate = "D";
        String senate = "DDRRR";
        String result = predictPartyVictory(senate);

        System.out.println(result);
    }

    public static String predictPartyVictory(String senate) {
        int length = senate.length();
        if(length == 0){
            return "";
        }

        Queue<Integer> queueR = new LinkedList<>();
        Queue<Integer> queueD = new LinkedList<>();

//        char[] chars = senate.toCharArray();

        // 将所有元素按投票顺序装入队列
        for(int i = 0;i < senate.length();i++){
            if(senate.charAt(i) == 'R'){
                queueR.offer(i);
            }else{
                queueD.offer(i);
            }
        }

        while(!queueR.isEmpty() && !queueD.isEmpty()){
            int R = queueR.poll();
            int D = queueD.poll();

            if(R < D){
                queueR.offer(R + length);
            }else{
                queueD.offer(D + length);
            }
        }

        return !queueR.isEmpty() ? "Radiant" : "Dire";
    }


    // 这个用例没有考虑一个议员被无效后，就不能再使别人无效了
    public static String predictPartyVictory1(String senate) {
        int length = senate.length();
        if(length == 0){
            return "";
        }

        char[] chars = senate.toCharArray();

        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < chars.length;i++){
            map.put(chars[i], map.getOrDefault(chars[i],0) + 1);
        }

        if(map.size() == 1){
            return !map.containsKey('D') ? "Radiant" : "Dire";
        }

        // Map中代表的是当前场景下，两个阵营还剩下的有权利投票数
        for(int i = 0;i < chars.length;i++){
            char ch = chars[i];
            // 如果是R，则会尝试使后面的D无效
            if(ch == 'R'){
                if(map.get('D') > 1){
                    map.put('D',map.get('D') - 1);
                }else{
                    return "Radiant";
                }
            }else{
                if(map.get('R') > 1){
                    map.put('R',map.get('R') - 1);
                }else{
                    return "Dire";
                }
            }
        }

        return "";
    }
}
