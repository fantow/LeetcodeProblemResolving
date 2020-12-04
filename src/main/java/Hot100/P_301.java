package Hot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_301 {
    public static void main(String[] args) {
        String s = "(a)())()";
        List<String> list = removeInvalidParentheses(s);

        System.out.println(list);
    }

    static Set<String> resultSet = new HashSet<>();

    public static List<String> removeInvalidParentheses(String s) {
        int length = s.length();

        List<String> resultList = new ArrayList<>();

        if(length == 0){
            resultList.add("");
            return resultList;
        }

        // 计算出需要处理的左右括号

        int leftCount = 0;
        int rightCount = 0;
        for(int i = 0;i < length;i++){
            if(s.charAt(i) == '('){
                leftCount++;
            }else if(s.charAt(i) == ')'){
                // 如果有左括号去匹配右括号，则抵消掉左括号
                if(leftCount > 0){
                    leftCount--;
                }else{
                    rightCount++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        DfsFunc(s.toCharArray(), sb,0,0,0,leftCount,rightCount);


        resultList = new ArrayList<>(resultSet);

        return resultList;
    }

    public static void DfsFunc(char[] chars,StringBuilder sb,int index,int open,int close,int openRem,int closeRem){
        int length = chars.length;
        if(index == length){
            if(openRem == 0 && closeRem == 0){
                resultSet.add(new String(sb));
            }
            return ;
        }

        // 当有需要被处理的左/右括号时，它一定构不成合法括号集
        if(chars[index] == '(' && openRem > 0 || chars[index] == ')' && closeRem > 0){
            DfsFunc(chars,sb,index + 1,open,close,chars[index] == '(' ? openRem - 1 :openRem,
                    chars[index] == ')' ? closeRem - 1: closeRem);
        }

        sb.append(chars[index]);
        if(chars[index] != '(' && chars[index] != ')'){
            DfsFunc(chars,sb,index + 1,open,close,openRem,closeRem);
        }else if(chars[index] == '('){
            DfsFunc(chars,sb,index + 1,open + 1,close,openRem,closeRem);
        }else if(chars[index] == ')' && open > close){
            // 这个判断很重要，如果遍历过程中发现了左括号比有括号多了，就结束递归
            DfsFunc(chars,sb,index + 1,open,close + 1,openRem,closeRem);
        }

        sb.deleteCharAt(sb.length() - 1);
        return;
    }

}
