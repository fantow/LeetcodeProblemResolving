package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_15 {
    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0,0,0,0};

        int[] nums = {-2,0,0,2,2};

        List<List<Integer>> lists = threeSum(nums);

        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if(length < 3){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        // 每次都要固定最左边的指针
        for(int i = 0;i < length - 2;i++){
            // 如果最左边的都大于0了，那后面肯定无法组成和为0的组合了。
            if(nums[i] > 0){
                break;
            }

            // 防止重复
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            // 剩下区域需要找到的目标
            int target = - nums[i];

            int left = i + 1;
            int right = length - 1;

            while(left < right){
                if(nums[left] + nums[right] == target){
                    if(left > i + 1 && nums[left] == nums[left - 1]){
                        left++;
                        continue;
                    }

                    if(right < length - 1 && nums[right] == nums[right + 1]){
                        right--;
                        continue;
                    }

                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);

                    result.add(list);
                    left++;
                    right--;
                }else if(nums[left] + nums[right] < target){
                    left++;
                }else{
                    right--;
                }
            }
        }

        return result;
    }
}
