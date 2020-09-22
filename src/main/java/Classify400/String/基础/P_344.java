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
        char[] s = {'H','a','n','n','a','h','a'};

//        ---- test3 ----

        reverseString(s);
        System.out.println(new String(s));

        int a = 2;
        int k = 10;
        int p = 3;
        int result = func1(a,k,p);
        System.out.println(result);
    }

    static int func(int a,int k,int p){
        int result = 1;
        for(int i = 1;i <= k;i++){
            result = result * a % p;
        }
        return result;
    }

    static int func1(int a,int k,int p){
        int result = 1;
        if(k == 1){
            return a % p;
        }else{
            result = func1(a,k/2,p);
        }
        return result * result % p;
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
