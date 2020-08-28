package Classify400.Array.基础;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_229 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] nums = {3,2,3};

//        ---- test2 ----
        int[] nums = {1,1,1,3,3,2,2,2};


        List<Integer> result = majorityElement(nums);

        for(int num : result){
            System.out.println(num);
        }
    }

    // 前提是n/k时，最多有k-1个众数，所以最多有2个众数出现
    public static List<Integer> majorityElement(int[] nums) {

        int length = nums.length;
        if(length == 0){
            return new ArrayList<>();
        }else if(length == 1){
            return new ArrayList<Integer>(){{add(nums[0]);}};
        }

        List<Integer> resultList = new ArrayList<>();

        int temp1 = 0;
        int temp2 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int i = 0;i < length;i++){
            if(temp1 == nums[i]){
                count1++;
                continue;
            }else if(temp2 == nums[i]){
                count2++;
                continue;
            }

            if(count1 == 0){
                temp1 = nums[i];
                count1++;
                continue;
            }

            if(count2 == 0){
                temp2 = nums[i];
                count2++;
                continue;
            }
            count1--;
            count2--;
        }

        count1 = 0;
        count2 = 0;
        for(int num : nums){
            if(temp1 == num){
                count1++;
            }else if(temp2 == num){
                count2++;
            }
        }

        if(count1 > length / 3){
            resultList.add(temp1);
        }
        if(count2 > length / 3){
            resultList.add(temp2);
        }

        return resultList;
    }
}
