package Classify400.String.基础;

/**
 * @Description:
 * @Author chenyang270@jd.com
 * @CreateDate
 * @Version: 1.0
 */
public class P_344 {
    public static void main(String[] args) {
//        ---- test1 ----
//        char[] s = {'h','e','l','l','o'};

//        ---- test2 ----
        char[] s = {'H','a','n','n','a','h'};

        reverseString(s);
        System.out.println(new String(s));
    }

    public static void reverseString(char[] s) {
        int length = s.length;
        if (length == 0 || length == 1){
            return;
        }

        for(int i = 0;i < length / 2;i++){
            char ch = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = ch;
        }

        return;
    }
}
