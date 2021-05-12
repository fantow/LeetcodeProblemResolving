package CodeTop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_1 {
    public static void main(String[] args) {

//        int[] nums = {2,7,11,15};
//        int target = 9;

        int[] nums = {3,2,4};
        int target = 6;

//        int[] nums = {3,3};
//        int target = 6;

        int[] result = twoSum(nums, target);

        for(int num : result){
            System.out.print(num + " ");
        }
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

       int[] resultArr = new int[2];

        for(int i = 0 ;i < length;i++){
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                resultArr[0] = i;
                resultArr[1] = map.get(target - nums[i]);
                return resultArr;
            }
        }

        return resultArr;
    }
}
