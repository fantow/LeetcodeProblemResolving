package Hot100;

import java.util.ArrayList;
import java.util.List;

public class P_77 {
    public static List<List<Integer>> resultList = new ArrayList<>();
    public static void main(String[] args) {
        int n = 4;
        int k = 3;

        List<List<Integer>> lists = combine(n, k);

        for(List<Integer> list : lists){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {

        List<Integer> tempList = new ArrayList<>();

        func(1,n,k,tempList);

        return resultList;
    }

    public static void func(int start,int n,int k,List<Integer> tempList){

        if(tempList.size() == k){
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        if(start > n){
            return;
        }
        for(int i = start;i <= n;i++){
            tempList.add(i);

            func(i + 1,n,k,tempList);

            tempList.remove(tempList.size() - 1);
        }

    }
}
