package Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        boolean flag = wordBreak(s, wordDict);
        System.out.println(flag);
    }

    // 采用BFS
    public static boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] isVisited = new boolean[length];

        Set<String> set = new HashSet<>();

        for(String str : wordDict){
            set.add(str);
        }

        return false;
    }
}
