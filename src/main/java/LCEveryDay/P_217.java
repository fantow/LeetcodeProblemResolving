package LCEveryDay;

import Hot100.P_4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_217 {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};
//        int[] nums = {1,2,3,4};
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        boolean flag = containsDuplicate(nums);

        System.out.println(flag);
    }

    public static boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        if(length <= 1){
            return true;
        }

        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
