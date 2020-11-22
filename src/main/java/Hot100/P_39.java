package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_39 {
    public static List<List<Integer>> resultList = new ArrayList<>();
    public static void main(String[] args) {
//        int[] candidates = {2,3,6,7};
//        int target = 7;

        int[] candidates = {2,3,5};
        int target = 8;

        Arrays.sort(candidates);

        List<List<Integer>> lists = combinationSum(candidates, target);
        for(List list : lists){
            System.out.println(list);
        }
    }

    // 题目保证了candidates和target中都是正整数
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> tempList = new ArrayList<>();
        int tempSum= 0;

        func(candidates,target,tempList,tempSum);

        return resultList;
    }

    public static void func(int[] candidates,int target,List<Integer> tempList,int tempSum){
        int length = candidates.length;

        if(tempSum > target){
            return;
        }

        if(tempSum == target){
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = 0;i < length;i++){
            if(!tempList.isEmpty()){
                if(tempList.get(tempList.size() - 1) > candidates[i]){
                    continue;
                }
            }
            tempSum += candidates[i];
            tempList.add(candidates[i]);
            func(candidates,target,tempList,tempSum);
            tempSum -= candidates[i];
            tempList.remove(tempList.size() - 1);
        }

        return;
    }
}
