package LCEveryDay;

import java.util.Stack;

public class P_402 {
    public static void main(String[] args) {
//        String num = "1432219";
//        int k = 3;

//        String num = "10200";
//        int k = 1;

//        String num = "10";
//        int k = 2;

//        String num = "100";
//        int k = 1;

        String num = "112";
        int k = 1;

//        String num = "1234567890";
//        int k = 9;

//        String num = "100020";
//        int k = 1;

//        String s = removeKdigits(num, k);
//        System.out.println(s);

        String s = removeKdigits2(num,k);
        System.out.println(s);

    }

    public static String removeKdigits2(String num,int k){
        int length = num.length();
        if(length == k){
            return "0";
        }

        int m = length - k;

        StringBuilder sb = new StringBuilder();

        for(char ch : num.toCharArray()){
            while(sb.length() != 0 && k != 0){
                if(sb.charAt(sb.length() - 1) > ch){
                    sb = sb.deleteCharAt(sb.length() - 1);
                    k--;
                }else{
                    break;
                }
            }
            sb.append(ch);
        }

        sb = sb.delete(m,sb.length());

        while(sb.length()!= 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.length() > 0 ? sb.toString() : "0";
    }





    // 单调栈 + 计数k记录已经丢弃的数字
    // 这种写法是错的，因为无法处理1234567890这样的结果
    public static String removeKdigits(String num, int k) {
        int length = num.length();
        if(length <= k){
            return "0";
        }

        int count = 0;

        Stack<Character> stack = new Stack<>();

        for(int i = 0;i < length;i++){
            if(stack.isEmpty() || i == 0){
                stack.add(num.charAt(i));
                continue;
            }

            char peekElem = stack.peek();
            if(peekElem - num.charAt(i) > 0 && count < k){
//                System.out.println("pop了:" + stack.peek());
                stack.pop();
                count++;
            }
            stack.add(num.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);

        sb = sb.reverse();
        String result = sb.toString();
        if(sb.length() > length - k){
            result = sb.substring(0,length - k);
        }


        boolean flag = false;

        int index = 0;
        for(int i = 0;i < result.length();i++){
            if(result.charAt(i) != '0'){
                index = i;
                break;
            }
            if(i == result.length() - 1){
                flag = true;
            }
        }

        if(flag){
            return "0";
        }else{
            result = result.substring(index);
            return result;
        }
    }

    public static String removeKdigits1(String num, int k) {
        StringBuilder res = new StringBuilder();
        int n = num.length(), m = n - k;
        for (char c : num.toCharArray()) {
            while (k != 0 && res.length() != 0 && res.charAt(res.length() - 1) > c) {
//		                res.pop_back();
                res = res.deleteCharAt(res.length() - 1);
                --k;
            }
            res.append(c);
        }
        res = res.delete(m, res.length());
        // 去除前导0， 如10200，k = 1
        while (res.length() != 0 && res.charAt(0) == '0') {
            res = res.deleteCharAt(0);
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
