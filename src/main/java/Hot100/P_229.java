package Hot100;

import java.util.ArrayList;
import java.util.List;

public class P_229 {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
//        int[] nums = {1};
//        int[] nums = {1,1,1,3,3,2,2,2};
//        int[] nums = {1,2};
//        int[] nums = {0,-1,2,-1};
        List<Integer> resultList = majorityElement(nums);

        for(Integer num : resultList){
            System.out.print(num + " ");
        }
    }

    // 摩尔投票法的升级版本
    public static List<Integer> majorityElement(int[] nums) {
        int length = nums.length;
        List<Integer> resultList = new ArrayList<>();

        if(length == 0){
            return resultList;
        }else if(length == 1){
            resultList.add(nums[0]);
            return resultList;
        }

        int candidate1 = Integer.MAX_VALUE;
        int count1 = 0;

        int candidate2 = Integer.MAX_VALUE;
        int count2 = 0;

        for(int i = 0;i < length;i++){
            if(candidate1 == Integer.MAX_VALUE || candidate1 == nums[i]){
                candidate1 = nums[i];
                count1++;
                continue;
            }

            if(candidate2 == Integer.MAX_VALUE || candidate2 == nums[i]){
                candidate2 = nums[i];
                count2++;
                continue;
            }

            if(candidate1 != nums[i] && candidate2 != nums[i]){
                if(count1 == 0 || count2 == 0){
                    if(count1 == 0){
                        candidate1 = nums[i];
                        count1++;
                    }else{
                        candidate2 = nums[i];
                        count2++;
                    }
                }else if(count1 != 0 && count2 != 0){
                    count1--;
                    count2--;
                }
            }
        }

//        System.out.println(candidate1 + " -> " + candidate2);

//        count1 = 0;
//        count2 = 0;
//
//        for(int i = 0;i < length;i++){
//            if(candidate1 == nums[i]){
//                count1++;
//            }else if(candidate2 == nums[i]){
//                count2++;
//            }
//        }

//        if(count1 > length / 3){
//            resultList.add(candidate1);
//        }
//
//        if(count2 > length / 3){
//            resultList.add(candidate2);
//        }

        if(count1 > 0){
            resultList.add(candidate1);
        }

        if(count2 > 0){
            resultList.add(candidate2);
        }

        return resultList;
    }
}
