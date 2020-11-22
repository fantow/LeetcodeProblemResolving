package Hot100;

import java.util.ArrayList;
import java.util.List;

public class P_78 {
    public static List<List<Integer>> resultList = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {0};
        List<List<Integer>> lists = subsets(nums);

        for(List<Integer> list : lists){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;

        resultList.add(new ArrayList<>());

        if(length == 0){
            return resultList;
        }

        if(length == 1){
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            resultList.add(list);
            return resultList;
        }

        List<Integer> tempList = new ArrayList<>();

        func(0,nums,tempList);

        return resultList;
    }

    public static void func(int start,int[] nums,List<Integer> tempList){
        int length = nums.length;

        if(start >= length){
            return;
        }

        for(int i = start;i < length;i++){
            tempList.add(nums[i]);
            resultList.add(new ArrayList<>(tempList));

            func(i + 1,nums,tempList);

            tempList.remove(tempList.size() - 1);
        }
        return;
    }

}
