package JZOffer;

import java.util.HashMap;
import java.util.Map;

public class P_46 {

    public static void main(String[] args) {
//        int num = 12258;
//        int num = 506;
        int num = 2163;
        int result = translateNum2(num);

        System.out.println(result);
    }

    // dp方法
    public static int translateNum(int num) {
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();

        int length = str.length();
        if(length == 0){
            return 0;
        }
        if(length == 1){
            return 1;
        }

        int[] dp = new int[length + 1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i <= length;i++){
            // 判断是否可以和上一个数合为一个字符
//            int result = Integer.valueOf(str.substring(i - 2,i));
            int result = (chars[i - 2] - '0') * 10 + (chars[i - 1] - '0');
            if(result <= 25){
                if(chars[i - 2] == '0'){
                    dp[i] = dp[i - 1];
                }else{
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }else{
                dp[i] = dp[i - 1];
            }
        }

        return dp[length];
    }


    // 方法2.使用递归
    public static int translateNum1(int num) {
        String str = String.valueOf(num);
        int length = str.length();

        if(length == 0){
            return 0;
        }
        if(length == 1){
            return 1;
        }

        char[] chars = str.toCharArray();

        int result = reverseTranslate(chars, 0);
        return result;
    }

    // index是左右标记点
    public static int reverseTranslate(char[] chars,int index){
        if(index >= chars.length){
            return 1;
        }

        // 左部分是一个一个加进去的
        int leftNum = reverseTranslate(chars,index + 1);

        // 有部分是尝试两个数翻译
        int rightNum = 0;
        if(index + 1 < chars.length){
            int result = (chars[index] - '0') * 10 + (chars[index + 1] - '0');
            if(result <= 25){
                if((chars[index] - '0') != 0){
                    rightNum = reverseTranslate(chars,index + 2);
                }
            }
        }

        return leftNum + rightNum;
    }


    // 方法3.对递归方法进行优化，因为存在重复计算
    public static int translateNum2(int num) {
        String str = String.valueOf(num);
        int length = str.length();

        if(length == 0){
            return 0;
        }
        if(length == 1){
            return 1;
        }

        char[] chars = str.toCharArray();

        int result = reverseTranslateAdvance(chars, 0);
        return result;
    }

//    Map<index,count>
    public static Map<Integer,Integer> cacheMap = new HashMap<>();

    public static int reverseTranslateAdvance(char[] chars,int index){
        if(index >= chars.length){
            cacheMap.put(index,1);
            return 1;
        }

        int leftNum = 0;
        // 左部分是一个一个加进去的
        if(cacheMap.get(index + 1) == null) {
            leftNum = reverseTranslate(chars, index + 1);
            cacheMap.put(index + 1,leftNum);
        }else{
            leftNum = cacheMap.get(index + 1);
        }

        // 有部分是尝试两个数翻译
        int rightNum = 0;
        if(index + 1 < chars.length){
            int result = (chars[index] - '0') * 10 + (chars[index + 1] - '0');
            if(result <= 25){
                if((chars[index] - '0') != 0){
                    if(cacheMap.get(index + 2) == null){
                        rightNum = reverseTranslate(chars,index + 2);
                        cacheMap.put(index + 2,rightNum);
                    }else{
                        rightNum = cacheMap.get(index + 2);
                    }
                }
            }
        }

        return leftNum + rightNum;
    }

}
