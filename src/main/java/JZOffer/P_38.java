package JZOffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_38 {

    public static char[] charArray;
    public static List<String> resultList = new ArrayList<>();

    public static void main(String[] args) {

        String s = "abc";
        String[] arr = permutation(s);
        for(String str : arr){
            System.out.println(str);
        }
    }

    public static String[] permutation(String s) {
        if(s.length() == 0){
            return new String[]{};
        }
        if(s.length() == 1){
            return new String[]{s};
        }

        charArray = s.toCharArray();

        // 从index = 0 的位置开始
        reverseString(0);

        return resultList.toArray(new String[resultList.size()]);
    }

    public static void reverseString(int index){
        if(index == charArray.length - 1){
            resultList.add(String.valueOf(charArray));
            return;
        }

        // 用于判断在同层中是否有重复的char
        Set<Character> duplexSet = new HashSet<>();
        for(int i = index;i < charArray.length;i++){
            // 枝剪
            if(duplexSet.contains(charArray[i])){
                continue;
            }

            duplexSet.add(charArray[i]);
            swap(i,index);
            reverseString(index + 1);
            // 对于在原数据上修改的，递归完成后一定要恢复
            swap(i,index);
        }
    }

    public static void swap(int from,int to){
        char temp = charArray[from];
        charArray[from] = charArray[to];
        charArray[to] = temp;
    }

}
