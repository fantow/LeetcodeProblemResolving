package CodeTop;

public class P_415 {
    public static void main(String[] args) {

//        String num1 = "11";
//        String num2 = "123";

        String num1 = "1";
        String num2 = "99";

        String s = addStrings(num1, num2);
        System.out.println(s);
    }

    public static String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        // 从后向前算比较简单
        StringBuilder stringBuilder = new StringBuilder();

        // 如果长度不一样，调整num1为最长的
        if(len1 < len2){
            String temp = num1;
            num1 = num2;
            num2 = temp;

            int tmp = len1;
            len1 = len2;
            len2 = tmp;
        }

        // 调整的最好方式是对短的String前面补0
        while(num2.length() < num1.length()){
            num2 = "0" + num2;
        }

        // 用来记录进位
        int dicimal = 0;

        for(int i = len1 - 1;i >= 0;i--){
            int temp = (num1.charAt(i) - '0') + (num2.charAt(i) - '0') + dicimal;

            stringBuilder.append(temp % 10);
            dicimal = temp / 10;
        }

        if(dicimal != 0){
            stringBuilder.append(dicimal);
        }

        return stringBuilder.reverse().toString();
    }
}
