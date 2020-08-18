package JZOffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_45 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] nums = {10,2};

//        ---- test2 ----
//        int[] nums = {3,30,34,5,9};

//        ---- test3 ----
        int[] nums = {12,121};
        String result = minNumber(nums);

        System.out.println(result);
    }

    public static String minNumber(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return "";
        }
        if(length == 1){
            return String.valueOf(nums[0]);
        }

        // 先将nums的内容变为String数组
        String[] strArr = new String[length];

        for(int i = 0;i < length;i++){
            String str = String.valueOf(nums[i]);
            strArr[i] = str;
        }

        StringBuilder sb = new StringBuilder();

        // 若 x + y > y + x  --> x大
        // 若 x + y < y + x  --> y大

        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String str1 = s1 + s2;
                String str2 = s2 + s1;

                int length = str1.length();
                // 这里还不能使用转换判断大小，容易溢出，只能通过String格式判断
                for(int i = 0;i < length;i++){
                    if(str1.charAt(i) != str2.charAt(i)){
                        return str1.charAt(i) - str2.charAt(i);
                    }
                }
                return 0;
            }
        });

        for(String str : strArr){
            sb.append(str);
        }

        return sb.toString();
    }
}
