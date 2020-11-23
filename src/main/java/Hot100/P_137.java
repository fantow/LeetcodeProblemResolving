package Hot100;

import java.util.HashSet;
import java.util.Set;

public class P_137 {
    public static void main(String[] args) {
//        int[] nums = {2,2,3,2};
//        int[] nums = {0,1,0,1,0,1,99};

        int[] nums = {-2,-2,1,1,-3,1,-3,-3,-4,-2};

        int result = singleNumber(nums);
//        System.out.println(result);
    }

    public static int singleNumber(int[] nums) {

        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }

        for(int i = 0;i < 32;i++){
            System.out.print(counts[i] + " ");
        }


        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
