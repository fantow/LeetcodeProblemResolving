package CodeTop;

import java.util.ArrayList;
import java.util.List;

public class P_78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> lists = subsets(nums);

        for(List<Integer> list : lists){
            System.out.println(list);
        }
    }

    // 典型的dfs + 回溯
    public static List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        List<List<Integer>> resList = new ArrayList<>();

        // 添加空集
        List<Integer> empty = new ArrayList<>();
        resList.add(empty);

        List<Integer> tempList = new ArrayList<>();

        for(int i = 0;i < length;i++){
            tempList.add(nums[i]);
            dfs(nums,i,tempList,resList);
            tempList.remove(tempList.size() - 1);
        }

        return resList;
    }

    public static void dfs(int[] nums,int startIdx,List<Integer> tempList,List<List<Integer>> resList){
        int length = nums.length;

        if(startIdx >= length){
            return ;
        }

        resList.add(new ArrayList<>(tempList));

        for(int i = startIdx + 1;i < length;i++){
            tempList.add(nums[i]);

            dfs(nums,i,tempList,resList);

            tempList.remove(tempList.size() - 1);
        }


        return ;
    }

}
