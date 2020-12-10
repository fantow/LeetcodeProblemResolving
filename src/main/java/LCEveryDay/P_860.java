package LCEveryDay;

import java.util.HashMap;
import java.util.Map;

public class P_860 {
    public static void main(String[] args) {
//        int[] bills = {5,5,5,10,20};
//        int[] bills = {5,5,5,10};
//        int[] bills = {10,10};
        int[] bills = {5,5,10,10,20};
        boolean flag = lemonadeChange(bills);

        System.out.println(flag);
    }

    public static boolean lemonadeChange(int[] bills) {
        int length = bills.length;
        if(length == 0){
            return true;
        }

        // <零钱金额，还剩次数>
        int[] remindMoney = new int[4];

        for(int i = 0;i < length;i++){
            int money = bills[i];

            // 需要找钱
            if(money != 5){
                // 从最大面额开始招起，不够的再向前遍历

                // 需要找给它的钱数
                int changeMoney = money - 5;
                for(int j = 3;j >= 0;j--){
                    while(changeMoney != 0 && changeMoney >= (j + 1) * 5 && remindMoney[j] > 0){
                        changeMoney -= (j + 1) * 5;
                        remindMoney[j]--;
                    }
                    if(changeMoney == 0){
                        break;
                    }
                }
                if(changeMoney != 0){
                    return false;
                }
            }

            remindMoney[money / 5 - 1] ++;
        }

        return true;
    }
}
