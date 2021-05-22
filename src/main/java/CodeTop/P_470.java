package CodeTop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class P_470 {
    public static void main(String[] args) {
        int count = 20;

        List<Integer> res = new ArrayList<>();

        for(int i = 0;i < count;i++){
            res.add(rand10());
        }

        System.out.println(res);
    }

    // 假设rand7()已经被提供
    public static int rand10() {

        while(true) {
            int a = rand7();
            int b = rand7();

            // 这是一个1~49的随机结果
            int res = (a - 1) * 7 + b;

            if (res <= 40) {
                return res % 10 + 1;
            }
        }

    }

    public static int rand7(){
        return (int)(Math.random() * 7 + 1);
    }
}
