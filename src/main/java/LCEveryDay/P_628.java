package LCEveryDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_628 {
    public static void main(String[] args) {
//        int[] nums = {1,2,3};
        int[] nums = {1,2,3,4};
        int result = maximumProduct(nums);

        System.out.println(result);
    }

    public static int maximumProduct(int[] nums) {
        int length = nums.length;

        if(length < 3){
            return 0;
        }else if(length == 3){
            return nums[0] * nums[1] * nums[2];
        }

        // 存放负数
        List<Integer> nagList = new ArrayList<>();

        // 存放正数
        List<Integer> posList = new ArrayList<>();
        int zeroCount = 0;

        for(int i = 0;i < length;i++){
            if(nums[i] > 0){
                posList.add(nums[i]);
            }else if(nums[i] < 0){
                nagList.add(nums[i]);
            }else{
                zeroCount++;
            }
        }

        Collections.sort(nagList);
        Collections.sort(posList);


        // 可能出现负数，所以策略是：
        // 排序后，选出最大的三个数
        // 1.最大的三个数都是正数，直接乘即可
        // 2.最大的三个数都是负数，说明nums中都是负数，同样直接乘即可
        // 3.如果有正有负：一定是选最小的两个负数，一个最大的正数
        // 4.如果有0：

        int result = 1;
        if(posList.size() >= 3){
            for(int i = posList.size() - 1;i >= posList.size() - 3;i--){
                result *= posList.get(i);
            }
            return result;
        }else if(nagList.size() >= 2 && posList.size() >= 1){
            // 选最大的正数 * 两个最小的负数
            result *= nagList.get(0);
            result *= nagList.get(1);
            result *= posList.get(posList.size() - 1);
            return result;
        }else if(nagList.size() < 2){
            return 0;
        }else{
            // 负数多
            // 没有0
            if(length == posList.size() + nagList.size()){
                return nagList.get(nagList.size() - 1) * nagList.get(nagList.size() - 2) * nagList.get(nagList.size() - 3);
            }else{
                return 0;
            }

        }
    }
}
