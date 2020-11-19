package Hot100;

import java.util.ArrayList;
import java.util.List;

public class P_22 {

    public static List<String> resultList = new ArrayList<>();
    public static void main(String[] args) {
        int n = 3;
        List<String> list = generateParenthesis(n);

        for(String str : list){
            System.out.println(str);
        }
    }

    public static List<String> generateParenthesis(int n) {
        if(n == 0){
            return new ArrayList<>();
        }

        StringBuilder sb = new StringBuilder("(");

        // 尝试加左括号
        reverseFun(n,sb.append("("),2,0);

        sb.deleteCharAt(sb.length() - 1);
        // 尝试加右括号
        reverseFun(n,sb.append(")"),1,1);

        return resultList;
    }

    // 递归和回溯有什么区别？
    public static void reverseFun(int n,StringBuilder str,int leftNum,int rightNum){
        if(leftNum == n && rightNum == n ){
            resultList.add(new String(str));
        }

        if(leftNum > n || rightNum > n){
            return;
        }


        if(leftNum >= rightNum) {
            // 尝试加左括号
            reverseFun(n, str.append("("), leftNum + 1, rightNum);
            str.deleteCharAt(str.length() - 1);

            // 尝试加右括号
            reverseFun(n, str.append(")"), leftNum, rightNum + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
