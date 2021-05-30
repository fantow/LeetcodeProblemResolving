package CodeTop;

public class P_8 {
    public static void main(String[] args) {
//        String s = "42";
//        String s = "     -42";
//        String s = "4193 with words";
//        String s = "words and 987";
//        String s = "-91283472332";
//        String s = "21474836460";
//        String s = " 0000000000012345678";
//        String s = " ";
        String s = "2147483646";

        int res = myAtoi(s);
        System.out.println(res);
    }

    public static int myAtoi(String s) {
        // 步骤
        // 1.丢弃无用前导空格
        // 2.检查字符，"+"/"-"
        // 3.读取数字字符
        // 4.输入转为数字
        // 5.超过范围的，将其固定结果

        // 1.丢弃前导空格
        s = s.trim();
        int length = s.length();
        if(length == 0){
            return 0;
        }

        // 2.检查正负号
        boolean isPositive = true;
        int idx = 0;

        if(s.charAt(0) == '+'  || s.charAt(0) == '-'){
            isPositive = s.charAt(0) == '+' ? true : false;
            idx++;
        }else if((s.charAt(0) >= 'a') && (s.charAt(0) <= 'z') || ((s.charAt(0) >= 'A') && (s.charAt(0) <= 'Z'))){
            // 说明第一个字符不是数字是字母，直接返回0
            return 0;
        }

        double res = 0;

        while(idx < length && (s.charAt(idx) >= '0' && s.charAt(idx) <= '9')) {
            res = res * 10 + (s.charAt(idx) - '0');

            if (isPositive && (res > ((1 << 31) - 1))) {
                return (1 << 31) - 1;
            } else if (!isPositive && (-res < (- 1 << 31))) {
                return - 1 << 31;
            }

            idx++;
        }

        return isPositive ? (int)res : (int) -res;
    }
}
