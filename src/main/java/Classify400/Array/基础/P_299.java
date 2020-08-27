package Classify400.Array.基础;

import java.util.Arrays;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_299 {
    public static void main(String[] args) {
//        ---- test1 ----
//        String secret = "1807";
//        String guess = "7810";

//        ---- test2 ----
//        String secret = "1123";
//        String guess = "0111";

//        ---- test3 ----
//        String secret = "1";
//        String guess = "0";

//        ---- test4 ----
        String secret = "1122";
        String guess = "3456";

        String result = getHint1(secret, guess);
        System.out.println(result);
    }

    public static String getHint(String secret, String guess) {
        int length = secret.length();

        // 先找出公牛，再对String排序，找出有多少奶牛
        int bullsCount = 0;


        char[] secretChars = secret.toCharArray();
        char[] guessChars = guess.toCharArray();

        for(int i = 0;i < length;i++){
            if(secretChars[i] == guessChars[i]){
                bullsCount++;
            }
        }


        Arrays.sort(secretChars);
        Arrays.sort(guessChars);

        int ptr1 = 0;
        int ptr2 = 0;
        int cowsCount = -bullsCount;

        while(ptr1 < length && ptr2 < length){
            if(secretChars[ptr1] == guessChars[ptr2]){
                cowsCount++;
                ptr1++;
                ptr2++;
            }else if(secretChars[ptr1] < guessChars[ptr2]){
                ptr1++;
            }else{
                ptr2++;
            }
        }

        return bullsCount + "A" + cowsCount + "B";
    }

    // 看题解的答案，只使用一个长度为10的桶即可
    public static String getHint1(String secret, String guess) {
        int[] bucket = new int[10];
        int length = secret.length();

        int bullsCount = 0;
        int cowsCount = 0;

        for(int i = 0;i < length;i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bullsCount++;
                continue;
            }
            bucket[secret.charAt(i) - '0'] += 1;
            bucket[guess.charAt(i) - '0'] -= 1;
        }

        for(int i = 0;i < bucket.length;i++){
            if(bucket[i] > 0){
                cowsCount += bucket[i];
            }
        }

        cowsCount = length - cowsCount - bullsCount;

        return bullsCount + "A" + cowsCount + "B";
    }

}
