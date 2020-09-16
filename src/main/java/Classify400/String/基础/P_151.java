package Classify400.String.基础;

/**
 * @Description:
 * @Author chenyang270@jd.com
 * @CreateDate
 * @Version: 1.0
 */
public class P_151 {
    public static void main(String[] args) {
//        ---- test1 ----
//        String s = "the sky is blue";

//        ---- test2 ----
//        String s = "  hello world!  ";

//        ---- test3 ----
//        String s = "a good   example";

//        ---- test4 ----
        String s = " ";

        String result = reverseWords(s);
        System.out.println(result);
    }


    public static String reverseWords(String s) {
        int length = s.length();
        if(length == 0){
            return s;
        }

        s = s.trim();
        String[] strings = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i = strings.length - 1;i >= 0;i--){
            if(strings[i] != "" && strings[i].length() != 0)
            sb.append(strings[i] + " ");
        }
        if(sb.length() > 0){
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

}
