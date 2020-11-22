package Hot100;

import javax.swing.text.html.ListView;
import java.util.*;

public class P_47 {
    public static List<List<Integer>> resultList = new ArrayList<>();

    public static void main(String[] args) {
//        int[] nums = {1,1,2};
        int[] nums = {1,2,3};
//        int[] nums = {3,3,0,3};
        List<List<Integer>> lists = permuteUnique(nums);

        for(List<Integer> list : lists){
            System.out.println(list);
        }
    }


    public static List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;

        if(length == 0){
            return new ArrayList<>();
        }

        if(length == 1){
            return new ArrayList<List<Integer>>(){{add(new ArrayList<Integer>(){{add(nums[0]);}});}};
        }

        boolean[] isVisited = new boolean[length];

        List<Integer> tempList = new ArrayList<>();
//        for(int i = 0;i < length;i++){
//            if(i == 0 || i > 0 && nums[i - 1] != nums[i]) {
//                tempList.add(nums[i]);
//                isVisited[i] = true;
//                System.out.println(nums[i]);
//                func(nums, isVisited, tempList);
//                tempList.remove(tempList.size() - 1);
//                isVisited[i] = false;
//            }
//        }
        func(nums,isVisited,tempList);

        return resultList;
    }

    public static void func(int[] nums,boolean[] isVisited,List<Integer> tempList){
        if(tempList.size() == nums.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        Set<Integer> set = new HashSet<>();

        // 需要保证，在本层中的isVisited中，不能选到重复的数字
        for(int i = 0;i < isVisited.length;i++){
            if(isVisited[i] == false && !set.contains(nums[i])){
                tempList.add(nums[i]);
                isVisited[i] = true;
                set.add(nums[i]);
                func(nums,isVisited,tempList);
                tempList.remove(tempList.size() - 1);
                isVisited[i] = false;
            }
        }

        return;
    }



//    public static List<List<Integer>> permuteUnique(int[] nums) {
//        int length = nums.length;
//        if(length == 0){
//            return new ArrayList<>();
//        }
//        if(length == 1){
//            return new ArrayList<List<Integer>>(){{add(new ArrayList<Integer>(){{add(nums[0]);}});}};
//        }
//
//        Arrays.sort(nums);
//
//        boolean[] isVisited = new boolean[length];
//        for(int i = 0;i <length;i++){
//            List<Integer> tempList = new ArrayList<>();
//            if(i > 0 && nums[i - 1] == nums[i]){
//                continue;
//            }
//            tempList.add(nums[i]);
//            isVisited[i] = true;
//            func(nums,tempList,isVisited);
//            tempList.remove(tempList.size() - 1);
//            isVisited[i] = false;
//        }
//
//        return resultList;
//    }
//
//    public static void func(int[] nums, List<Integer> tempList, boolean[] isVisited){
//        if(tempList.size() == nums.length){
//            resultList.add(new ArrayList<>(tempList));
//            return;
//        }
//
//        for(int i = 0;i < nums.length;i++){
////            if(isVisited[i] == true || i > 0 && nums[i - 1] == nums[i]){
//            if(isVisited[i] == true){
//                continue;
//            }
//
//            tempList.add(nums[i]);
//            isVisited[i] = true;
//            func(nums, tempList, isVisited);
//            tempList.remove(tempList.size() - 1);
//            isVisited[i] = false;
//        }
//    }

}
