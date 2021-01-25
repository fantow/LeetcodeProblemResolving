package Algo91.Chap01_数组_栈_队列;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_1 {
    public static void main(String[] args) {
//        int[] nums = {2,7,11,15};
//        int target = 9;

        int[] nums = {3,3};
        int target = 6;

        int[] arr = twoSum(nums, target);

        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        if(length <= 1){
            return null;
        }

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < length;i++){
            map.put(nums[i],i);
        }

        for(int i = 0;i < length;i++){
            int temp = target - nums[i];
            if(map.containsKey(temp) && map.get(temp) != i){
                int[] arr = new int[2];
                arr[0] = i;
                arr[1] = map.get(temp);
                return arr;
            }
        }

        return null;
    }

    public static int[] twoSum1(int[] nums, int target) {
        int length = nums.length;
        if(length <= 1){
            return null;
        }

        for(int i = 0;i < length;i++){
            for(int j = i + 1;j < length;j++){
                if(nums[i] + nums[j] == target){
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }

        return null;
    }
}
