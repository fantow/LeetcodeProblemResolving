package CodeTop;

import java.util.ArrayList;
import java.util.List;

public class P_46 {
    public static void main(String[] args) {

        int[] nums = {1,2,3};
        List<List<Integer>> lists = permute(nums);

        for(List<Integer> list : lists){
            System.out.println(list);
        }
    }

    // 应该是用回溯法
    public static List<List<Integer>> permute(int[] nums) {
        int length = nums.length;

        List<List<Integer>> res = new ArrayList<>();

        if(length == 0){
            return res;
        }

        boolean[] isVisited = new boolean[length];

        List<Integer> list = new ArrayList<>();
        dfs(nums,isVisited,list,res);

        return res;
    }

    public static void dfs(int[] nums,boolean[] isVisited,List<Integer> list,List<List<Integer>> res){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            // i下标元素没有被访问过
            if(isVisited[i] != true) {
                list.add(nums[i]);
                isVisited[i] = true;
                dfs(nums,isVisited,list,res);
                isVisited[i] = false;
                list.remove(list.size() - 1);
            }
        }
        return ;
    }
}
