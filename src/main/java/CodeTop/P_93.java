package CodeTop;

import java.util.ArrayList;
import java.util.List;

public class P_93 {
    public static void main(String[] args) {
        String s = "25525511135";

        List<String> list = restoreIpAddresses(s);
        System.out.println(list);
    }

    // 应该用一种递归写法,dfs+回溯
    public static List<String> restoreIpAddresses(String s) {
        int length = s.length();

        List<String> list = new ArrayList<>();

        if(length == 0){
            return list;
        }

//        func(s,0,list,"");

        return list;
    }

    public static void func(String s,int startIdx,List<String> list,List<String> curStrList){
        int length = s.length();

        if(startIdx >= length){
//            list.add(curString);
            return ;
        }

        // 最多三位
        for(int i = 0;i < 3;i++){
            String temp = s.substring(startIdx,startIdx + i);
            if(isTrue(temp)){


            }else{
                break;
            }


        }



    }

    // 如果str转换为数字后，>=0 && <= 255
    public static boolean isTrue(String str){
        int length = str.length();

        if(length <= 2){
            return true;
        }else{
            if((str.charAt(0) - '0') <= 2 && (str.charAt(1) - '0' <= 5) && (str.charAt(2) - '0' <= 5)){
                return true;
            }
        }

        return false;
    }
}
