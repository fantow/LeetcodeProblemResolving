package Hot100;

import java.util.*;

public class P_40 {
    public static List<List<Integer>> resultList = new ArrayList<>();
    public static void main(String[] args) {
//        int[] candidates = {10,1,2,7,6,1,5};
//        int target = 8;

        int[] candidates = {2,5,2,1,2};
        int target = 5;

        Arrays.sort(candidates);

        List<List<Integer>> lists = combinationSum2(candidates, target);
        for(List list : lists){
            System.out.println(list);
        }

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<Integer> tempList = new ArrayList<>();
        int tempSum = 0;
        int startIdx = 0;

        func(candidates,target,tempList,tempSum,startIdx);

        return resultList;
    }

    public static void func(int[] candidates,int target,List<Integer> tempList,int tempSum,int startIdx){
        int length = candidates.length;
        if(target <= tempSum){
            if(target == tempSum){
                resultList.add(new ArrayList<>(tempList));
            }
            return;
        }

        Set<Integer> set = new HashSet<>();


        for(int i = startIdx;i < length;i++) {
            if(set.contains(candidates[i])){
                continue;
            }
            tempList.add(candidates[i]);
            tempSum += candidates[i];
            set.add(candidates[i]);
            func(candidates, target, tempList, tempSum, i + 1);

            tempList.remove(tempList.size() - 1);
            tempSum -= candidates[i];
        }
        return;
    }

}
