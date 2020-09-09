package Classify400.String.基础;

/**
 * @Description:
 * @Author chenyang270@jd.com
 * @CreateDate
 * @Version: 1.0
 */
public class P_58 {
    public static void main(String[] args) {
//        ---- test1 ----
//        String s = "Hello World";

//        ---- test2 ----
        String s = " ";

        int result = lengthOfLastWord(s);

        System.out.println(result);
    }

    public static int lengthOfLastWord(String s) {
        int length = s.length();
        if(length == 0){
            return 0;
        }

        s = s.trim();

        String[] strings = s.split(" ");

        int result = strings[strings.length - 1].length();
        return result;
    }
}
