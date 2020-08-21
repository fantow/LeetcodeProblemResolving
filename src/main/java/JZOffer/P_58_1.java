package JZOffer;



/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_58_1 {
    public static void main(String[] args) {
//        ---- test1 ----
//        String s = "the sky is blue";

//        ---- test2 ----
//        String s = "  hello world!  ";

//        ---- test3 ----
        String s = "a good   example";


        String reverse = reverseWords(s);

        System.out.println(reverse);
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strings = s.trim().split(" ");

        for(int i = strings.length - 1;i >= 0;i--){
            // 判断String[] 中的" "，应该用!strings[i].equals("")
            if(!strings[i].equals("")){
                sb.append(strings[i]);
                if(i != 0){
                    sb.append(" ");
                }
            }
        }

        return sb.toString();
    }
}
