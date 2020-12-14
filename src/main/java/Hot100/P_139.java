package Hot100;

import java.util.*;

public class P_139 {
    public static void main(String[] args) {
//        String s = "leetcode";
//        List<String> wordDict = new ArrayList<String>(){{add("leet"); add("code");}};

//        String s = "applepenapple";
//        List<String> wordDict = new ArrayList<String>(){{add("apple");add("pen");}};


//        String s = "catsandog";
//        List<String> wordDict = new ArrayList<String>(){{add("cats");add("dog");add("sand");add("and");add("cat");}};

        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<String>(){{add("aaaa");add("aa");}};

//        String s = "aaaaaaa";
//        List<String> wordDict = new ArrayList<String>(){{add("aaaa");add("aaa");}};

//        String s = "abcd";
//        List<String> wordDict = new ArrayList<String>(){{add("a");add("abc");add("b");add("cd");}};

        boolean flag = wordBreak(s, wordDict);
        System.out.println(flag);
    }

    // 感觉像回溯啊...
    public static boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();


        // ------------  DFS   -----------------
        int wordNum = wordDict.size();

//         题目提到s，wordDict都不为空，所以这里就不判断了。

        boolean[] isVisited = new boolean[length];
        Set<String> set = new HashSet<>(wordDict);
        boolean result = dfs(s, wordDict, 0,isVisited,set);
        return result;


        // ------------  BFS   -----------------
        // 这个queue应该是用来存放当前匹配到的index
//        Set<String> set = new HashSet<>(wordDict);
//        boolean[] isVisited = new boolean[length];
//
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(0);
//
//        while(!queue.isEmpty()){
//            Integer index = queue.poll();
////            System.out.println("pop:" + index);
//            if(index >= length){
//                return true;
//            }
//
//            if(isVisited[index] == true){
//                continue;
//            }
//
//            for(int i = index;i <= length;i++){
//                if(set.contains(s.substring(index,i))){
//                    System.out.println(s.substring(index,i) + " offer:" + i);
//                    isVisited[i - 1] = true;
//                    queue.offer(i);
////                    System.out.println("offer:" + i);
//                }
//            }
//        }
//
////        for(boolean b : isVisited){
////            System.out.print(b + " ");
////        }
////        System.out.println();
//
//        return isVisited[length - 1];
    }




    public static boolean dfs(String s,List<String> wordDict,int index,boolean[] isVisited,Set<String> set){
        int length = s.length();
        if(index  >= length){
            return true;
        }

        // 说明以index为起始的部分已经判断完了，一定是失败的
        if(isVisited[index] == true){
            return false;
        }

        for(int i = index;i <= length;i++){
            if(set.contains(s.substring(index,i))){
                if(dfs(s, wordDict, i , isVisited, set)){
                    return true;
                }
            }
        }

        isVisited[index] = true;
        return false;
    }


    // 下一个需要判断的位置
    // 这个会在有的用例超时，原因是判断字符串是否存在时使用了逐位遍历，其实应该使用set+substring
    public static boolean dfs1(String s,List<String> wordDict,int index,boolean[] isVisited){
        int length = s.length();
        if(length <= index){
            return true;
        }


        if(isVisited[index] == true && dfs1(s, wordDict, index + 1, isVisited)){
            return true;
        }

        for(String str : wordDict){
            int idx = index;
            boolean flag = true;

//            System.out.println(str.length() + " + " + index + " length:" + length);
            if(str.length() + index > length){
                continue;
            }else{
                for(int i = 0;i < str.length() && idx < length;i++){
                    if(str.charAt(i) != s.charAt(idx)){
                        flag = false;
                        break;
                    }
                    idx++;
                }
                if(flag){
                    isVisited[idx - 1] = true;
                    if(dfs1(s,wordDict,idx,isVisited)){
                        return true;
                    }else{
                        continue;
                    }
                }
            }
        }

        return false;
    }

}
