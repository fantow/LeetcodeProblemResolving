package LCEveryDay;

public class P_1052 {
    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int X = 3;

        int result = maxSatisfied(customers, grumpy, X);
        System.out.println(result);
    }


    // 定长的滑动窗口问题
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // 先计算，如果没有技巧，有多少客户满意
        int sum = 0;

        for(int i = 0;i < customers.length;i++){
            if(grumpy[i] == 0){
                sum += customers[i];
            }
        }

        int maxResult = sum;

        // 启动窗口
        int left = 0;
        int right = 0;

        int current = 0;

        for(;right < customers.length;right++){
            // 如果小于X，说明当前构不成窗口
            if(grumpy[right] == 1){
                current += customers[right];
            }

            if(right < X - 1){
                continue;
            }else if(right == X - 1){
                maxResult = Math.max(maxResult,sum + current);
                continue;
            }

            // 移动left
            if(grumpy[left] == 1){
                current -= customers[left];
            }
            left++;

            // 如果目前已经构成窗口，就要开始计算了
            maxResult = Math.max(maxResult,sum + current);
        }

        return maxResult;
    }
}
