package LeetCode_TOP;

import java.util.HashMap;
import java.util.Map;

public class P_13{
    public static void main(String[] args) {
//        String s = "III";
//        String s = "IV";
//        String s = "LVIII";
        String s = "MCMXCIV";
        int result = romanToInt(s);

        System.out.println(result);
    }


    // 比较好的方式
    public static int romanToInt(String s) {
        int length = s.length();
        if(length == 0){
            return 0;
        }

        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
//        map.put("IV",4);
//        map.put("IX",9);
//        map.put("XL",40);
//        map.put("XC",90);
//        map.put("CD",400);
//        map.put("CM",900);

        int preNum = map.get(s.charAt(0));
        int result = 0;

        for(int i = 1;i < length;i++){
            int num = map.get(s.charAt(i));

            if(preNum < num){
                result -= preNum;
            }else{
                result += preNum;
            }

            preNum = num;
        }
        result += preNum;

        return result;
    }


    // 题目有说明：通常罗马数字小的在大的后面，表示+；如果出现小的在大的前面，表示-
    public static int romanToInt1(String s) {
        int length = s.length();
        if(length == 0){
            return 0;
        }

        Map<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);

        int idx = 0;
        int result = 0;
        while(idx < length){
            char ch = s.charAt(idx);
            if(map.containsKey(ch + "")){
                // 如果可以凑两个一组的
                if(idx + 1 < length && (ch == 'I' || ch == 'X' || ch == 'C')){
                    // 如果是这几个字符，尝试读取下一个字符
                    String str = Character.toString(ch) + s.charAt(idx + 1);
                    if(map.containsKey(str)){
                        result += map.get(str);
                        idx += 2;
                        continue;
                    }
                }

                result += map.get(ch + "");
            }else{
                return 0;
            }
            idx++;
        }

        return result;
    }
}
