package Company.ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_15 {
    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {-1,0,1};

        int[] nums = {0,0,0,0};

        List<List<Integer>> lists = threeSum(nums);

        for(List<Integer> list : lists){
            for(Integer num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;

        List<List<Integer>> resultList = new ArrayList<>();

        if(length < 3){
            return resultList;
        }

        Arrays.sort(nums);

        int lastI = Integer.MIN_VALUE;

        // 注意判重
        for(int i = 0;i <= length - 3;i++){
            if(lastI == nums[i]){
                continue;
            }
            lastI = nums[i];

            if(nums[i] > 0){
                break;
            }

            int left = i + 1;
            int right = length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum < 0){
                    while(left < right && nums[left] == nums[++left]);
                }else if(sum > 0){
                    while(left < right && nums[right] == nums[--right]);
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);

                    resultList.add(list);

                    while(left < right && nums[left] == nums[++left]);

                    while(left < right && nums[right] == nums[--right]);
                }
            }
        }

        return resultList;
    }
}
