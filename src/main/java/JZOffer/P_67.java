package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_67 {
    public static void main(String[] args) {
//        ---- test1 ----
//        String str = "42";

//        ---- test2 ----
//        String str = "   -42";

//        ---- test3 ----
//        String str = "4193 with words";

//        ---- test4 ----
//        String str = "words and 987";

//        ---- test5 ----
//        String str = "-91283472332";

//        ---- test6 ----
//        String str = "3.14159";

//        ---- test7 ----
//        String str = ".1";

//        ---- test8 ----
//        String str = "9223372036854775808";

//        ---- test9 ----
//        String str = "-91283472332";

//        ---- test10 ----
//        String str = "2147483648";

//        --- test11 ----
        String str = "-5-";

        int result = strToInt(str);

        System.out.println(result);
    }

    // 重点应该在如果str中表示的string如何转换为数字
    public static int strToInt(String str) {
        if(str == null){
            return 0;
        }
        str = str.trim();

        int length = str.length();
        if(length == 0){
            return 0;
        }

        boolean transToNum = false;
        boolean isPositive = true;
        boolean isOutOfBounds = false;
        char[] chars = str.toCharArray();

        // 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。
        // 所以这里不能使用long，其实使用了long，某些用例也会越界
//        long resultNum = 0;
        int resultNum = 0;

        for(int i = 0;i < length;i++){
            // 只要出现了字母，就会停止转换
            if((chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z')){
                // 比如前面是数字表示，后面出现了字母
                // 跳出循环
                break;
            }else if(chars[i] == '+' || chars[i] == '-'){
                if(!transToNum){
                    isPositive = (chars[i] == '+') ? true : false;
                    transToNum = true;
                }else{
                    // 比如在开始计数后，又出现正负号，则会转换失败
                    break;
                }
            }else if(chars[i] >= '0' && chars[i] <= '9'){
                transToNum = true;
                // 这里需要判断两次
                // 第一次.resultNum 在 *10 前是否可能越过 (Integer.MAX_VALUE / 10) 或 (Integer.MIN_VALUE / 10)
                // 第二次.resultNum 在 resultNum * 10 + (chars[i] - '0')后是否越界
                int temp = resultNum;
                // 这里有一个情况就是，temp 并不大于 Integer.MAX_VALUE / 10，但是*10 + char[i] - '0' 后越界了
                if(temp > (Integer.MAX_VALUE / 10)){
                    isOutOfBounds = true;
                    break;
                }else if(temp == Integer.MAX_VALUE / 10 && (chars[i] - '0') > 7){
                    isOutOfBounds = true;
                    break;
                }
                else if(temp < (Integer.MIN_VALUE / 10)){
                    isOutOfBounds = true;
                    break;
                }

                resultNum = resultNum * 10 + (chars[i] - '0');
                if(resultNum > Integer.MAX_VALUE){
                    isOutOfBounds = true;
                    break;
                }else if(resultNum < Integer.MIN_VALUE){
                    isOutOfBounds = true;
                    break;
                }
            }else{
                break;
            }
        }

        if(isOutOfBounds){
            if(isPositive){
                return Integer.MAX_VALUE;
            }else{
                return Integer.MIN_VALUE;
            }
        }

        if(!isPositive){
            resultNum = - resultNum;
        }

        // 判断是否越界
        if(resultNum > Integer.MAX_VALUE || resultNum < Integer.MIN_VALUE){
            return (resultNum < 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return resultNum;
    }

}
