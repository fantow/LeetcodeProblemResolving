package CodeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_39 {
    public static void main(String[] args) {
//        int[] candidates = {2,3,6,7};
//        int target = 7;

        int[] candidates = {2,3,5};
        int target = 8;

        List<List<Integer>> lists = combinationSum(candidates, target);

        for(List<Integer> list : lists){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> lists = new ArrayList<>();

    // 用回溯法去做
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int length = candidates.length;
        if(length == 0){
            return lists;
        }

        List<Integer> list = new ArrayList<>();

        Arrays.sort(candidates);

        dfs(candidates,target,list,0);

        return lists;
    }

    // 带回溯法的dfs
    public static void dfs(int[] candidates,int target,List<Integer> list,int startIdx){
        if(target == 0){
            lists.add(new ArrayList<>(list));
            return ;
        }

        if(startIdx >= candidates.length){
            return ;
        }

        for(int i = startIdx;i < candidates.length;i++){
            if(candidates[i] > target){
                return ;
            }

            target -= candidates[i];
            list.add(candidates[i]);

            dfs(candidates,target,list,i);

            target += candidates[i];
            list.remove(list.size() - 1);
        }

        return ;
    }
}
