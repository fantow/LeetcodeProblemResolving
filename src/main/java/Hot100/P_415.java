package Hot100;

public class P_415 {
    public static void main(String[] args) {
        String num1 = "9999";
        String num2 = "2";

//        String num1 = "10";
//        String num2 = "30";

        String result = addStrings(num1, num2);
        System.out.println(result);
    }

    public static String addStrings(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();

        if(length1 == 0 && length2 == 0){
            return "";
        }

        if(length1 == 0 || length2 == 0){
            return length1 == 0 ? num2 : num1;
        }


        // 保证num1是最大的
        if(length1 < length2){
            String temp = num2;
            num2 = num1;
            num1 = temp;

            int length = length2;
            length2 = length1;
            length1 = length;
        }

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();


        // 存储进位
        int digit = 0;

        // 存储个位数
        int num = 0;

        StringBuilder sb = new StringBuilder();

        for(int i = 0;i < length1;i++){
            if(i >= length2){
                if(digit == 0){
                    sb.append(num1.charAt(i));
                }else{
                    int temp = num1.charAt(i) - '0' + digit;
                    num = temp % 10;
                    digit = temp / 10;
                    sb.append(num);
                }
                continue;
            }

            int tempNum = (num1.charAt(i) - '0') + (num2.charAt(i) - '0') + digit;
            sb.append(tempNum % 10);
            digit = tempNum / 10;
        }

        if(digit != 0){
            sb.append(digit);
        }

        return sb.reverse().toString();
    }
}
