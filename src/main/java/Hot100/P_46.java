package Hot100;

import java.util.*;

public class P_46 {

    public static List<List<Integer>> resultList = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> lists = permute1(nums);

        System.out.println(lists);
    }


    // 使用DFS
    public static List<List<Integer>> permute1(int[] nums) {
        int length = nums.length;

        if(length == 0){
            return new ArrayList<>();
        }
        if(length == 1){
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            return new ArrayList<List<Integer>>(){{add(list);}};
        }

        boolean[] isVisited = new boolean[length];

        for(int i = 0;i < length;i++){


        }




        return null;
    }

    public static void BFS(){


    }



    // 使用回溯法
    public static List<List<Integer>> permute(int[] nums) {
        int length = nums.length;

        if(length == 0){
            return new ArrayList<>();
        }
        if(length == 1){
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            return new ArrayList<List<Integer>>(){{add(list);}};
        }

        boolean[] isVisited = new boolean[length];
        List<Integer> tempList = new ArrayList<>();

        for(int i = 0 ;i < length;i++){
            tempList.add(nums[i]);
            isVisited[i] = true;
            func(tempList,nums,isVisited);
            // 恢复现场
            tempList.remove(tempList.size() - 1);
            isVisited[i] = false;
        }

        return resultList;
    }

    public static void func(List<Integer> tempList,int[] nums,boolean[] isVisited){
        if(tempList.size() == nums.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(isVisited[i] != true){
                tempList.add(nums[i]);
                isVisited[i] = true;
                func(tempList,nums,isVisited);
                tempList.remove(tempList.size() - 1);
                isVisited[i] = false;
            }
        }
        return;
    }

}
