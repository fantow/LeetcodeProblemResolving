package 代码练习.Test3_1;

import com.sun.scenario.effect.Merge;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        MergeSort solution = new MergeSort();

        solution.mergeSort(nums,0,nums.length - 1);
        for(int num : nums){
            System.out.print(num + " ");
        }
    }

    public void mergeSort(int[] nums,int left,int right){
        int mid = left + (right - left) / 2;
        if(left < right){
            mergeSort(nums,left,mid);
            mergeSort(nums,mid + 1,right);
            merge(nums,left,mid,right);
        }
    }

    // left~mid 是一部分，mid+1~right是一部分
    public void merge(int[] nums,int left,int mid,int right){
        int length = nums.length;
        int[] tempArr = new int[length];

        int ptr1 = left;
        int ptr2 = mid + 1;

        int index = left;

        while(ptr1 <= mid && ptr2 <= right){
            if(nums[ptr1] < nums[ptr2]){
                tempArr[index++] = nums[ptr1++];
            }else{
                tempArr[index++] = nums[ptr2++];
            }
        }

        while(ptr1 <= mid){
            tempArr[index++] = nums[ptr1++];
        }

        while(ptr2 <= right){
            tempArr[index++] = nums[ptr2++];
        }


        // 写回原数组
        for(int i = left;i <= right;i++){
            nums[i] = tempArr[i];
        }

        return;
    }

}
