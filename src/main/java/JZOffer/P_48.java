package JZOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_48 {
    public static void main(String[] args) {
//        ---- test1 ----
//        String str = "abcabcbb";

//        ---- test2 ----
//        String str = "bbbbb";

//        ---- test3 ----
          String str = "pwwkew";

//          ---- test4 ----
//        String str = "abba";

        int result = lengthOfLongestSubstring(str);

        System.out.println(result);
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        int length = s.length();
        if(length == 0 || length == 1){
            return length;
        }

        Map<Character,Integer> map = new HashMap<>();
        int[] dpArr = new int[length];
        char[] chars = s.toCharArray();

        // 初始化
        dpArr[0] = 1;
        map.put(chars[0],0);

        // 用于记录上次产生冲突的idx
        int collision = -1;

        for(int idx = 1;idx < length;idx++) {
            char ch = chars[idx];
            if(map.get(ch) != null){
                collision = Math.max(map.get(ch),collision);
            }

            if(dpArr[idx - 1] < idx - collision){
                System.out.println("idx:" + idx + " collision:" + collision);
                dpArr[idx] = dpArr[idx - 1] + 1;
            }else{
                dpArr[idx] = dpArr[idx - 1];
            }

            map.put(ch,idx);
        }

        for(int a : dpArr){
            System.out.print(a + " ");
        }
        System.out.println();

        return dpArr[length - 1];
    }
}
