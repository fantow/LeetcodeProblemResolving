package Algo91.Chap01_数组_栈_队列;


// 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
public class P_242 {
    public static void main(String[] args) {
//        String s = "anagram";
//        String t = "nagaram";

        String s = "rat";
        String t = "car";

        boolean flag = isAnagram(s, t);
        System.out.println(flag);
    }

    public static boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        if(sLength != tLength){
            return false;
        }

        int[] countArr = new int[26];
        int count = 0;

        for(int i = 0;i < sLength;i++){
            countArr[s.charAt(i) - 'a']++;
            count++;
        }

        for(int i = 0;i < tLength;i++){
            if(countArr[t.charAt(i) - 'a'] > 0){
                countArr[t.charAt(i) - 'a'] --;
                count--;
            }else{
                return false;
            }
        }

        if(count == 0){
            return true;
        }

        return false;
    }
}
