package TheImport250Problems;

import JZOffer.P_30;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_03 {
    public static void main(String[] args) {
//        ---- test1 ----
//        String s = "abcabcbb";

//        ---- test2 ----
//        String s = "bbbbb";

//        ---- test3 ----
//        String s = "pwwkew";

//        ---- test4 ---
        String s = "au";

        int result = lengthOfLongestSubstring(s);

        System.out.println();
        System.out.println(result);
    }

    // 好像是剑指Offer上有相同的题，
    // 使用DP解决
    // 问题在于新状态的判断比如pwwkew
    // 在判断到pww时，最长子串为2，继续向后遍历是出现k，这时最常子串为最新的wk
    // 需要维护最近一次发生重复的指针，如果map中找不到本次遍历的字符，
    // 就用i - collprt + 1，构成最新的未发生重复子串长度
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(length == 0){
            return 0;
        }

//        使用一个指针记录上一次发生冲突的位置
        int collptr = -1;

        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int[] dpArr = new int[length];

        // 首个必定不会发生碰撞
        dpArr[0] = 1;
        map.put(chars[0],0);

        for(int i = 1;i < length;i++){
            char ch = chars[i];

            if(map.get(ch) != null){
                collptr = Math.max(map.get(ch),collptr);
            }

            if(dpArr[i - 1] < i - collptr){
                dpArr[i] = dpArr[i - 1] + 1;
            }else{
                dpArr[i] = dpArr[i - 1];
            }

            map.put(ch,i);
        }

        for(int num : dpArr){
            System.out.print(num + " ");
        }

        return dpArr[length - 1];
    }

//    自己写的，是错的
//    for(int i = 1;i < length;i++){
//        if(map.containsKey(chars[i])){
//            collptr = Math.max(collptr,map.get(chars[i]));
//            if(i <= collptr + dpArr[i - 1]){
//                dpArr[i] = dpArr[i - 1];
//            }else{
//                dpArr[i] = dpArr[i - 1] + 1;
//            }
//            collptr = i;
//        }else {
//            // 如果当前没有发生重复，直接 +1即可(这样想是错误的)
//            // 比如pwwkew中，遍历到第一个k时，不能直接+1
//            是这里错了，当没有发生重复时，也就是这个chars[i]是新遇到的，
//            但是不能直接的dpArr[i - 1] + 1，因为不知道这个新来的是否是和原子串组成新的最长子串
//            还是要和上面一样，通过上一轮重复下标来判断是否组成新的最长子串
//            dpArr[i] = Math.max(i - collptr + 1,dpArr[i - 1] + 1);
//        }
//        map.put(chars[i],i);
//    }


}
