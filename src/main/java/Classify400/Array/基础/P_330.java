package Classify400.Array.基础;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author chenyang270@jd.com
 * @CreateDate
 * @Version: 1.0
 */
public class P_330 {
    public static void main(String[] args) {
        int[] nums = {1,3};
        int n = 6;

        int result = minPatches(nums, n);
        System.out.println(result);
    }

    //
    public static int minPatches(int[] nums, int n) {
        int length = nums.length;
        int ans = 0;
        int current_coverage = 0;
        int pos = 0;

        while(current_coverage < n){
            if(pos < length){
                if(nums[pos] <= current_coverage + 1){
                    current_coverage += nums[pos];
                    pos += 1;
                }else{
                    ans += 1;
                    current_coverage += current_coverage + 1;
                }
            }else{
                ans += 1;
                current_coverage += current_coverage + 1;
            }
        }

        return ans;
    }
}
