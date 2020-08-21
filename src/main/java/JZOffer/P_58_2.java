package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_58_2 {
    public static void main(String[] args) {
//        ---- test1 ----
//        String s = "abcdefg";
//        int n = 2;

//        ---- test2 ----
        String s = "lrloseumgh";
        int n = 6;

        String result = reverseLeftWords(s, n);
        System.out.println(result);
    }

    // 逆置三次即可
    public static String reverseLeftWords(String s, int n) {
        int length = s.length();
        // 更好的方式应该是直接在String上操作，这里偷懒了。
        char[] chars = s.toCharArray();
        reverse(chars,0,n - 1);
        reverse(chars,n,length - 1);
        reverse(chars,0,length - 1);


        return String.valueOf(chars);
    }

    public static void reverse(char[] chars,int start,int end){
        while(start <= end){
            char ch = chars[start];
            chars[start] = chars[end];
            chars[end] = ch;

            start++;
            end--;
        }
    }
}
