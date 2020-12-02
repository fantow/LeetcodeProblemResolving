package LCEveryDay;

import java.util.Stack;

public class P_321 {
    public static void main(String[] args) {
//        int[] nums1 = {3,4,6,5};
//        int[] nums2 = {9,1,2,5,8,3};
//        int k = 5;

//        int[] nums1 = {6,7};
//        int[] nums2 = {6,0,4};
//        int k = 5;

        int[] nums1 = {3,9};
        int[] nums2 = {8,9};
        int k = 3;

//        int[] arr1 = getSubArr(nums1, 2);
//        int[] arr2 = getSubArr(nums2, 3);
//
//        for(int i = 0;i < arr1.length;i++){
//            System.out.print(arr1[i] + " ");
//        }
//
//        System.out.println();
//
//        for(int i = 0;i < arr2.length;i++){
//            System.out.print(arr2[i] + " ");
//        }
//
//        System.out.println();
//        int[] arr = mergeArr(arr1, arr2);
//        System.out.println("合并后结果");
//        for(int i = 0;i < arr.length;i++){
//            System.out.print(arr[i] + " ");
//        }

        int[] resultArr = maxNumber(nums1, nums2, k);
        for(int i = 0;i < resultArr.length;i++){
            System.out.print(resultArr[i] + " ");
        }
    }

    // 目前感觉是归并排序+一个当前对k的判断
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        if(length1 + length2 < k){
            return null;
        }

        int[] resArr = new int[k];

        // 从nums1中取i个元素，从nums2中取k-i个元素
        for(int i = 0;i <= k && i <= length1;i++){
            if(k - i >= 0 && k - i <= length2){
                if(getSubArr(nums1,i) == null){
                    continue;
                }

                if(getSubArr(nums2,k - i) == null){
                    continue;
                }
//                System.out.println("i: " + i + " k-i: " + (k - i));
                int[] tempArr = mergeArr(getSubArr(nums1,i),getSubArr(nums2,k - i));

//                for(int j = 0;j < tempArr.length;j++){
//                    System.out.print(tempArr[j] + " ");
//                }
//                System.out.println();

                if(compareFunc(tempArr,0,resArr,0)){
                    resArr = tempArr;
                }
            }
        }

        return resArr;
    }

    public static int[] getSubArr(int[] nums,int subLength){
        int length = nums.length;
        if(length < subLength){
            return null;
        }

        int canBeDel = length - subLength;

        if(length == subLength){
            return nums;
        }

        int[] resultArr = new int[subLength];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < length;i++){
//            if(stack.isEmpty()){
//                stack.add(nums[i]);
//            }
            while(!stack.isEmpty() && canBeDel > 0 && stack.peek() < nums[i]){
                stack.pop();
                canBeDel--;
            }
            stack.add(nums[i]);
        }

        while(stack.size() != subLength){
            stack.pop();
        }

        int idx = 0;
        while(!stack.isEmpty() && subLength > idx){
            resultArr[subLength - idx - 1] = stack.pop();
            idx++;
        }

        return resultArr;
    }


    // 合并两个nums，使其结果最大
    public static int[] mergeArr(int[] nums1,int[] nums2){
        int length1 = nums1.length;
        int length2 = nums2.length;

//        for(int i = 0;i < length1;i++){
//            System.out.print(nums1[i] + " ");
//        }
//        System.out.println();
//
//        for(int i = 0;i < length2;i++){
//            System.out.print(nums2[i] + " ");
//        }
//        System.out.println();

        if(length1 == 0 || length2 == 0){
            return length1 == 0 ? nums2 : nums1;
        }

        int[] resultArr = new int[length1 + length2];

        int idx1 = 0;
        int idx2 = 0;
        int idx = 0;

        while(idx < length1 + length2){
            if(compareFunc(nums1,idx1,nums2,idx2)){
                resultArr[idx++] = nums1[idx1++];
            }else{
                resultArr[idx++] = nums2[idx2++];
            }
        }
//
//        while(idx1 != length1){
//            resultArr[idx++] = nums1[idx1++];
//        }
//
//        while(idx2 != length2){
//            resultArr[idx++] = nums2[idx2++];
//        }

        return resultArr;
    }

    // 返回nums1是否大于nums2
    public static boolean compareFunc(int[] nums1,int p1,int[] nums2,int p2){
        if (p2 >= nums2.length) return true;
        if (p1 >= nums1.length) return false;
        if (nums1[p1] > nums2[p2]) return true;
        if (nums1[p1] < nums2[p2]) return false;
        return compareFunc(nums1, p1 + 1, nums2, p2 + 1);
    }
}
