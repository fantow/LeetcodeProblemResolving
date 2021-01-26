package 算法通关40讲;

import java.util.List;

// 一道回溯的问题
// 需要维护还可以再使用的左右括号个数
// 一旦出现有括号剩下的比左括号少了，就直接返回(剪枝)
public class P_22 {
    public static void main(String[] args) {
        int n = 3;
        List<String> strings = generateParenthesis(n);

        for(String str : strings){
            System.out.print(str + " ");
        }
    }

    public static List<String> generateParenthesis(int n) {


        return null;
    }
}
