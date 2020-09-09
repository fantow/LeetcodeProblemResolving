package Classify400.String.基础;

/**
 * @Description:
 * @Author chenyang270@jd.com
 * @CreateDate
 * @Version: 1.0
 */
public class P_28 {
    public static void main(String[] args) {
//        ---- test1 ----
//        String haystack = "hello";
//        String needle = "ll";

//        ---- test2 ----
//        String haystack = "aaaaa";
//        String needle = "bba";

//        ---- test3 ----
        String haystack = "";
        String needle = "a";

        int result = strStr(haystack, needle);
        System.out.println(result);
    }

    public static int strStr(String haystack, String needle) {
        int length1 = haystack.length();
        int length2 = needle.length();
        if(length2 == 0){
            return 0;
        }

        int result = haystack.indexOf(needle);
        return result;
    }
}
