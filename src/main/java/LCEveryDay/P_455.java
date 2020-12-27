package LCEveryDay;

import java.util.Arrays;

public class P_455 {
    public static void main(String[] args) {
//        int[] g = {1,2,3};
//        int[] s = {1,1};

//        int[] g = {1,2};
//        int[] s = {1,2,3};


        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};

        int result = findContentChildren(g, s);
        System.out.println(result);
    }

    public static int findContentChildren(int[] g, int[] s) {
        int childLength = g.length;
        int goodLength = s.length;

        if(s.length == 0){
            return 0;
        }

        // 先对这两个数组排序
        Arrays.sort(g);
        Arrays.sort(s);

        int result = 0;

        int i = 0,j = 0;

        while(i < childLength && j < goodLength){
            if(g[i] <= s[j]){
                result++;
                i++;
                j++;
            }else{
                j++;
            }
        }

        return result;
    }
}
