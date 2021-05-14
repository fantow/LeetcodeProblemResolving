package CodeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_15 {
    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);

        for(List<Integer> list : lists){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;

        List<List<Integer>> resList = new ArrayList<>();

        // 先排序
        Arrays.sort(nums);

        for(int i = 0;i < length - 2;i++){
            if(nums[i] > 0){
                break;
            }else if(i > 0 && nums[i - 1] == nums[i]){
                continue;
            }

            int left = i + 1;
            int right = length - 1;

            while(left < right){
                // 去重
                if(left > i + 1 && nums[left - 1] == nums[left]){
                    left++;
                    continue;
                }

                if(right < length - 1 && nums[right + 1] == nums[right]){
                    right--;
                    continue;
                }

                int target = nums[i] + nums[left] + nums[right];
                if(target == 0){
                    List<Integer> curList = new ArrayList<>();
                    curList.add(nums[i]);
                    curList.add(nums[left]);
                    curList.add(nums[right]);
                    resList.add(curList);

                    left ++;
                    right--;
                }else if(target > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }

        return resList;
    }
}
