package LCEveryDay;

import java.util.ArrayList;
import java.util.List;

public class P_204 {
    public static void main(String[] args) {
//        int n = 10;
        int n = 2;
        int result = countPrimes(n);

        System.out.println(result);
    }

    public static int countPrimes(int n) {
        boolean[] st = new boolean[n + 1];
        List<Integer> prime = new ArrayList<>();
        int count = 0;
        for(int i = 2;i <n;i++){
            if(!st[i]){
                prime.add(i);
                count++;
                st[i] = true;
            }

            for(int j = 0;prime.get(j) <= n / i;j++){
                st[prime.get(j) * i] = true;
                if(i % prime.get(j) == 0){
                    break;
                }
            }
        }

        return count;
    }


    // 1.方法一，普通筛选法，先将0~n的数存入数组，再遍历，将2~n的倍数删除，最后剩下的就是质数
    public static int countPrimes1(int n) {
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 0;
        }

        boolean[] isValid = new boolean[n];

        int count = 0;

        for(int i = 2;i < n;i++){
            if(isValid[i] == false){
                count++;
            }

            for(int j = i;j < n;j += i){
                isValid[j] = true;
            }
        }

        return count;
    }
}
