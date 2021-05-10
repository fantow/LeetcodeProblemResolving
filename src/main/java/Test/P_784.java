package Test;

import java.util.ArrayList;
import java.util.List;

public class P_784 {
    public static void main(String[] args) {
//        String S = "a1b2";
//        String S = "12345";
//        String S = "0";
        String S = "C";
        List<String> list = letterCasePermutation(S);

        for(String str : list){
            System.out.println(str);
        }
    }

    // DFS
    public static List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();

        // 每次的DFS有两种选择：变为大写或者不变
        char[] chars = S.toCharArray();

        dfs(0,chars,list);

        return list;
    }

    public static void dfs(int idx,char[] chars,List<String> list){
        int length = chars.length;
        if(idx >= length){
            list.add(new String(chars));
            return;
        }

        // 如果是数字
        if(chars[idx] >= '0' && chars[idx] <= '9'){
            dfs(idx + 1,chars,list);
        }else{
            // 如果是字母，则需要考虑是否进行转变大写
            // 不转为大写
            dfs(idx + 1,chars,list);

            // 转为大写
            chars[idx] = transferFunc(chars[idx]);
            dfs(idx+1,chars,list);

            // 进行回溯
            chars[idx] = transferFunc(chars[idx]);
        }

        return;
    }

    // 转换函数
    public static char transferFunc(char ch){
        char result = ch;
        // 如果是大写就转为小写
        if(ch >= 'a' && ch <= 'z'){
            result -= ('a' - 'A');
        }else if(ch >= 'A' && ch <= 'Z'){
            // 如果是小写就转为大写
            result += ('a' - 'A');
        }

        return result;
    }

}
