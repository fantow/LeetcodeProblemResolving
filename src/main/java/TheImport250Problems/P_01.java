package TheImport250Problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_01 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] nums = {2,7,11,15};
//        int target = 9;

//        ---- test2 ----
        int[] nums = {3,2,4};
        int target = 6;

        int[] resultArr = twoSum2(nums, target);

        for(int num : resultArr){
            System.out.print(num + " ");
        }
    }

    // 双指针
    // 这样做如果数组中存在重复数字，会产生错误的答案，因为两个相同的值中，后面的值会覆盖前面的值的下标
    public static int[] twoSum1(int[] nums, int target) {
        int length = nums.length;

        // <数,原下标>
        Map<Integer,Integer> map = new HashMap<>();

        int left = 0;
        int right = length - 1;

        for(int i = 0;i < length;i++){
            map.put(nums[i],i);
        }

        Arrays.sort(nums);

        while(left < right){
            int temp = nums[left] + nums[right];
            if(temp == target){
                return new int[]{map.get(nums[left]),map.get(nums[right])};
            }else if(temp > target){
                right--;
            }else{
                left++;
            }
        }

        return new int[]{};
    }


    // 方法2.还是使用哈希表，只是修改了部分逻辑
    // 但是这样就不需要先排序了
    public static int[] twoSum2(int[] nums, int target) {
        int length = nums.length;
//        <数字，索引>
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < length;i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                if(i > map.get(temp)){
                    return new int[]{map.get(temp),i};
                }else{
                    return new int[]{i,map.get(temp)};
                }
            }
            map.put(nums[i],i);
        }

        return new int[]{};
    }


}
