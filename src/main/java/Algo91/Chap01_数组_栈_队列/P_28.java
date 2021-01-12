package Algo91.Chap01_数组_栈_队列;

//给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。

// 示例 1:
// 输入: haystack = "hello", needle = "ll"
//输出: 2
//
// 示例 2:
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1

public class P_28 {
    public static void main(String[] args) {
//        String haystack = "hello";
//        String needle = "ll";

//        String haystack = "aaaaa";
//        String needle = "bba";

//        String haystack = "mississippi";
//        String needle = "issipi";

        String haystack = "abc";
        String needle = "c";


        int idx = strStr(haystack, needle);
        System.out.println(idx);
    }

    public static int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();

        if(len1 < len2){
            return -1;
        }

        if(len2 == 0){
            return 0;
        }

        // 指向haystack的遍历指针
        for(int i = 0;i < len1;i++){
            int from = i;

            for(int idx = 0;idx < len2 && from + idx < len1;idx++){
                if(haystack.charAt(from + idx) != needle.charAt(idx)){
                    break;
                }else{
                    if(idx == len2 - 1){
                        return from;
                    }
                }
            }
        }

        return -1;
    }
}
