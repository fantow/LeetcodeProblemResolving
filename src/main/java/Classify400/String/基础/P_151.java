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
//        String s = " ";

//        ---- test5 ----
//        String s = "  ";
//
//        String result = reverseWords(s);
//        System.out.println(result);

        String A = "123456";
        int b = 100;

        String[] results = div(A,b);
        for(String str : results){
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public static String[] div(String A,int b){
        String[] results = new String[2];

        int t = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < A.length();i++){
            t = t * 10 + (A.charAt(i) - '0');
            if(t / b != 0){
                sb.append(t / b);
            }
            t = t % b;
        }


        results[0] = sb.toString();
        results[1] = String.valueOf(t);

        return results;
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
