package 算法通关40讲;

import java.util.ArrayList;
import java.util.List;

// 一道回溯的问题
// 需要维护还可以再使用的左右括号个数
// 一旦出现有括号剩下的比左括号少了，就直接返回(剪枝)
public class P_22 {
    public static void main(String[] args) {
//        int n = 3;
        int n = 1;
        List<String> strings = generateParenthesis(n);

        for(String str : strings){
            System.out.print(str + " ");
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        if(n == 0){
            return resultList;
        }

        List<String> tools = new ArrayList<>();
        tools.add("(");
        tools.add(")");

        StringBuilder sb = new StringBuilder();
        bfsFunc(n,sb,resultList,n,n,tools);

        return resultList;
    }

    // 参数分别表示：当前的String，结果容器，还剩下的左，右括号个数
    public static void bfsFunc(int n,StringBuilder sb,List<String> resultList,int left,int right,List<String> tools){
        // 如果剩余左括号个数 大于 右括号，一定非法
        if(left > right){
            return ;
        }

        if(left < 0 || right < 0){
            return ;
        }

        if(sb.length() == n * 2 && left == 0 && right == 0){
            resultList.add(new String(sb));
            return ;
        }

        // 每一次只有两种选择，添加左括号或者添加右括号
        for(String str : tools){
            if(str.equals("(")){
                sb.append(str);
                left--;
                bfsFunc(n,sb,resultList,left,right,tools);
                left++;
            }else if(str.equals(")")){
                sb.append(str);
                right--;
                bfsFunc(n,sb,resultList,left,right,tools);
                right++;
            }

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
