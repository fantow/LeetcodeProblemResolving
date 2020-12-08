package LCEveryDay;

import Hot100.P_2;

import java.util.ArrayList;
import java.util.List;

public class P_842 {
    public static void main(String[] args) {
//        String S = "123456579";
//        String S = "1101111";
        String S = "1011";
        List<Integer> list = splitIntoFibonacci(S);

        System.out.println(list);
    }

    public static List<Integer> splitIntoFibonacci(String S) {
        int length = S.length();
        List<Integer> resultList = new ArrayList<>();
        if(length < 3){
            return resultList;
        }

        func(resultList,S,0,0,0);

        return resultList;
    }

    static List<Integer> list = new ArrayList<>();

    public static boolean func(List<Integer> list,String S,int index,int sum,int prev){
        int length = S.length();
        if(length < 3){
            return false;
        }

        if(index == length){
            return list.size() >= 3;
        }

        long currentLong = 0;
        for(int i = index;i < length;i++){
            // 允许出现0的情况，但是不允许出现0X的情况
            if(i > index && S.charAt(index) == '0'){
                break;
            }

            currentLong = currentLong * 10 + S.charAt(i) - '0';

            if(currentLong > Integer.MAX_VALUE){
                break;
            }

            int cur = (int)currentLong;
            if(list.size() >= 2){
                if(cur < sum){
                    continue;
                }else if(cur > sum){
                    break;
                }
            }

            list.add(cur);
//            System.out.println(list);
            if(func(list,S,i + 1,prev + cur,cur)){
                return true;
            }else{
                list.remove(list.size() - 1);
            }

//            func(list,S,i + 1,prev + cur,cur);
//            list.remove(list.size() - 1);

        }
        return false;
    }

}
