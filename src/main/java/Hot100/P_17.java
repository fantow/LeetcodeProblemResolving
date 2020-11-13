package Hot100;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_17 {

    static List<String> resultList = new ArrayList<>();

    static Map<Character,String> map = new HashMap<>();

    static{
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }

    public static void main(String[] args) {
        String digits = "2";
        List<String> strings = letterCombinations(digits);
        System.out.println(strings);
    }

    public static List<String> letterCombinations(String digits) {

        if(digits.length() == 0){
            return new ArrayList<>();
        }
        char ch = digits.charAt(0);
        String s = map.get(ch);

        for(int i = 0;i < s.length();i++){
            StringBuilder sb = new StringBuilder();
            func1(sb.append(s.charAt(i)),digits.substring(1));
        }

        return resultList;
    }

    // 采用回溯的方法
    public static void func1(StringBuilder stringBuilder,String digits){

        int length = digits.length();
        if(length == 0){
            resultList.add(stringBuilder.toString());
            return;
        }

        String s = map.get(digits.charAt(0));
        for(int i = 0;i < s.length();i++){
            func1(stringBuilder.append(s.charAt(i)),digits.substring(1));
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }





}
