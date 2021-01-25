package LCEveryDay;

import java.util.ArrayList;
import java.util.List;

public class P_66 {
    public static void main(String[] args) {
//        int[] digits = {1,2,3};
//        int[] digits = {4,3,2,1};
//        int[] digits = {0};
        int[] digits = {9,9,9};
        int[] arr = plusOne(digits);

        for(int num : arr){
            System.out.print(num + " ");
        }
    }

    // 题目保证了digits的长度>=1
    public static int[] plusOne(int[] digits) {
        int length = digits.length;

        // 先将digits逆置，方便计算
        for(int i = 0;i < length / 2;i++){
            int temp = digits[i];
            digits[i] = digits[length - 1 - i];
            digits[length - 1 - i] = temp;
        }

        List<Integer> list = new ArrayList<>();

        // 用来记录进位
        int digit = 0;

        for(int i = 0;i < length;i++){
            int temp = digits[i];
            temp += digit;
            digit = 0;

            if(i == 0){
                temp += 1;
            }

            if(temp >= 10){
                temp = temp % 10;
                digit = 1;
            }

            list.add(temp);
        }

        if(digit != 0){
            list.add(digit);
        }

        int[] resultArr = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            resultArr[i] = list.get(list.size() - 1 - i);
        }

        return resultArr;
    }
}
