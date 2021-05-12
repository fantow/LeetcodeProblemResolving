package CodeTop;

import java.util.Arrays;

public class P_88 {
    public static void main(String[] args) {

//        int[] nums1 = {1,2,3,0,0,0};
//        int m = 3;
//
//        int[] nums2 = {2,5,6};
//        int n = 3;

        int[] nums1 = {0};
        int m = 0;

        int[] nums2 = {1};
        int n = 1;

        merge(nums1,m,nums2,n);

        for(int num : nums1){
            System.out.print(num + " ");
        }
    }

    // 从后向前确定数组顺序
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int ptr1 = m - 1;
        int ptr2 = n - 1;

        int idx = m + n - 1;

        while(ptr1 >= 0 && ptr2 >= 0){
            if(nums1[ptr1] >= nums2[ptr2]){
                nums1[idx--] = nums1[ptr1];
                ptr1--;
            }else{
                nums1[idx--] = nums2[ptr2];
                ptr2--;
            }
        }

        while(ptr1 >= 0){
            nums1[idx--] = nums1[ptr1--];
        }

        while(ptr2 >= 0){
            nums1[idx--] = nums2[ptr2--];
        }
    }
}
