package LCEveryDay;

public class P_605 {
    public static void main(String[] args) {
//        int[] flowerbed = {1,0,0,0,0,1};
        int[] flowerbed = {1,0,0,0,1,0,0};
        int n = 2;

        boolean flag = canPlaceFlowers(flowerbed, n);
        System.out.println(flag);
    }

    // 给定了当前的花坛格式，去判断是否可以种下n朵花，所以每朵花需要
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;

        int ptr = 0;
        while(ptr < length){
            if(n <= 0){
                return true;
            }

            if(flowerbed[ptr] != 0){
                ptr++;
                continue;
            }

            // 如果ptr == 0，不需要判断前面的是否为1
            if(ptr > 0){
                if(flowerbed[ptr - 1] != 0){
                    ptr++;
                    continue;
                }
            }

            if(ptr < length - 1 && flowerbed[ptr + 1] != 0){
                ptr++;
                continue;
            }

            n--;
            flowerbed[ptr] = 1;
            ptr++;
        }

        if(n <= 0){
            return true;
        }

        for(int num : flowerbed){
            System.out.print(num + " ");
        }
        System.out.println();

        return false;
    }
}
