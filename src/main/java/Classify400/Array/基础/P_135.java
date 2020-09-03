package Classify400.Array.基础;

import JZOffer.P_30;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author chenyang270@jd.com
 * @CreateDate
 * @Version: 1.0
 */
public class P_135 {
    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        int result = candy(ratings);

        System.out.println(result);
    }

    public static int candy(int[] ratings) {
        int length = ratings.length;
        if(length == 0){
            return 0;
        }

        int[] leftTraverse = new int[length];
        int[] rightTraverse = new int[length];

        // 对两个数组进行初始化
        for(int i = 0;i < length;i++){
            leftTraverse[i] = 1;
            rightTraverse[i] = 1;
        }

        // 左遍历
        for(int i = 1;i < length;i++){
            if(ratings[i] > ratings[i - 1]){
                leftTraverse[i] = leftTraverse[i - 1] + 1;
            }
        }

        int count = leftTraverse[length - 1];
        // 右遍历
        for(int i = length - 2;i >= 0;i--){
            if(ratings[i] > ratings[i + 1]){
                rightTraverse[i] = rightTraverse[i + 1] + 1;
            }
            count += Math.max(rightTraverse[i],leftTraverse[i]);
        }

        return count;
    }

}
