package Classify400.String.基础;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @Description:
 * @Author chenyang270@jd.com
 * @CreateDate
 * @Version: 1.0
 */
public class P_387 {
    public static void main(String[] args) {
//        ---- test1 ----
//        String s = "leetcode";

//        ---- test2 ----
        String s = "loveleetcode";

        int result = firstUniqChar(s);
        System.out.println(result);
    }

    // 用一个Map计数
    public static int firstUniqChar(String s) {
        int length = s.length();
        if(length == 0){
            return 0;
        }

        Map<Character,Integer> tempMap = new HashMap<>();
        for(int i = 0;i < length;i++){
            if(!tempMap.containsKey(s.charAt(i))){
                tempMap.put(s.charAt(i),i);
            }else{
                tempMap.put(s.charAt(i),-1);
            }
        }


        for(int i = 0;i < length;i++){
            if(tempMap.get(s.charAt(i)) != -1){
                return tempMap.get(s.charAt(i));
            }
        }

        return -1;
    }
}
