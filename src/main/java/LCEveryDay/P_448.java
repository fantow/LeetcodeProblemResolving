package LCEveryDay;

import java.util.ArrayList;
import java.util.List;

public class P_448 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = findDisappearedNumbers(nums);

        for(int num : list){
            System.out.print(num + " ");
        }
    }

    // 先原地置换，再扫描一遍数组即可
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;

        List<Integer> list = new ArrayList<>();

        // 从下标为1开始
        for(int i = 0;i < length;i++){
            while(nums[i] != i + 1){
//                if(i + 1 > nums[i] || nums[i] == nums[nums[i] - 1]){
                // 如果已经相等，说明这个就是多余的数字
                if(nums[i] == nums[nums[i] - 1]){
                    break;
                }else{
                    swap(nums,i,nums[i] - 1);
                }
            }
        }

        // 最后再扫描一次
        for(int i = 0;i < length;i++){
            if(nums[i] != i + 1){
                list.add(i + 1);
            }
        }

        return list;
    }

    public static void swap(int[] nums,int from,int to){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
