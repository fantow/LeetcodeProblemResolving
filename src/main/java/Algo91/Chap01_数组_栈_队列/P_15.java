package Algo91.Chap01_数组_栈_队列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
// 复的三元组。
public class P_15 {
    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {};
        int[] nums = {0};

        List<List<Integer>> lists = threeSum(nums);

        for(List<Integer> list : lists){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;

        List<List<Integer>> resultList = new ArrayList<>();

        if(length <= 2){
            return resultList;
        }

        Arrays.sort(nums);

        // 需要保证去重
        for(int i = 0;i < length && nums[i] <= 0;i++){
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int target = nums[i];

            int left = i + 1;
            int right = length - 1;

            while(left < right){
                if(left > i + 1 && nums[left] == nums[left - 1]){
                    left++;
                    continue;
                }

                if(right < length - 1 && nums[right] == nums[right + 1]){
                    right--;
                    continue;
                }

                int temp = target + nums[left] + nums[right];
                if(temp == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(target);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    resultList.add(list);
                    left ++;
                    right--;
                }else if(temp > 0){
                    right --;
                }else {
                    left ++;
                }
            }
        }

        return resultList;
    }
}
