package LCEveryDay;

import java.util.ArrayList;
import java.util.List;

public class P_228 {
    public static void main(String[] args) {
//        int[] nums = {0,1,2,4,5,7};
//        int[] nums = {0,2,3,4,6,8,9};
        int[] nums = {};

        List<String> list = summaryRanges(nums);

        for(String str : list){
            System.out.println(str);
        }
    }

    // 题目确定给的nums是有序的
    public static List<String> summaryRanges(int[] nums) {
        int length = nums.length;

        List<String> result = new ArrayList<>();

        if(length == 0){
            return result;
        }

        int min = nums[0];

        for(int i = 1;i < length;i++){
            if(nums[i] == nums[i - 1] + 1){
                continue;
            }else{
                if(min == nums[i - 1]){
                    result.add(min + "");
                }else{
                    String str = min + "->" + nums[i - 1];
                    result.add(str);
                }

                min = nums[i];
            }
        }

        // 出来后还需要判断一下
        if(min == nums[length - 1]){
            result.add(min + "");
        }else{
            String str = min + "->" + nums[length - 1];
            result.add(str);
        }

        return result;
    }
}
