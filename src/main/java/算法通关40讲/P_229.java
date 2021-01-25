package 算法通关40讲;

import java.util.ArrayList;
import java.util.List;

public class P_229 {
    public static void main(String[] args) {
//        int[] nums = {3,2,3};
//        int[] nums = {1};
//        int[] nums = {1,1,1,3,3,2,2,2};
//        int[] nums = {2,2};
//        int[] nums = {1,3,3,2,2,4,3,3,5,5,6,3,3,7,7};
        int[] nums = {2,1,1,3,1,4,5,6};

        List<Integer> list = majorityElement(nums);

        for(Integer num : list){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // 要求找出出现次数超过n/3的元素，所以最多有2个。
    public static List<Integer> majorityElement(int[] nums) {
        int length = nums.length;

        List<Integer> resultList = new ArrayList<>();

        if(length == 0){
            return resultList;
        }else if(length == 1){
            resultList.add(nums[0]);
            return resultList;
        }

        int candidate1 = nums[0];
        int count1 = 0;

        int candidate2 = nums[0];
        int count2 = 0;

        for(int i = 0;i < length;i++){

            System.out.println("candidate1:" + candidate1 + " count1:" + count1 + " candidate2:" + candidate2 + " count2:" + count2);

            if(count1 == 0){
                candidate1 = nums[i];
                count1++;
                continue;
            }

            if(count2 == 0) {
                candidate2 = nums[i];
                count2++;
                continue;
            }

            if(candidate1 == nums[i]){
                count1++;
                continue;
            }

            if(candidate2 == nums[i]){
                count2++;
                continue;
            }

//            if(count1 == 0){
//                candidate1 = nums[i];
//                count1++;
//                continue;
//            }
//
//            if(count2 == 0) {
//                candidate2 = nums[i];
//                count2++;
//                continue;
//            }

            count1--;
            count2--;
        }

        System.out.println("candidate1:" + candidate1 + " count1:" + count1 + " candidate2:" + candidate2 + " count2:" + count2);

        count1 = 0;
        count2 = 0;

        for(int i = 0;i < length;i++){
            if(candidate1 == nums[i]){
                count1++;
            }else if(candidate2 == nums[i]){
                count2++;
            }
        }

        if(count1 > length / 3){
            resultList.add(candidate1);
        }

        if(count2 > length / 3){
            resultList.add(candidate2);
        }

        return resultList;
    }
}
