package Classify400.Array.基础;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_496 {
    public static void main(String[] args) {
//        --- test1 ----
//        int[] nums1 = {4,1,2};
//        int[] nums2 = {1,3,4,2};

//        ---- test2 ----
//        int[] nums1 = {2,4};
//        int[] nums2 = {1,2,3,4};

//        ---- test3 ----
        int[] nums1 = {1,3,5,2,4};
        int[] nums2 = {6,5,4,3,2,1,7};

        int[] resultArr = nextGreaterElement(nums1, nums2);

        for(int num : resultArr){
            System.out.print(num + " ");
        }
    }

    // 看题解明白的，先不考虑nums1，求出nums2中每个元素的下一个更大元素，
    // 写入Map中记录
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length = nums2.length;
        if(length == 0){
            return new int[]{};
        }

        int[] resultArr = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();

        // 数字，nums2中的下标
        Map<Integer,Integer> recordMap = new HashMap<>();

        // 求出nums2中，该元素的下一个更大值
        for(int i = 0;i < length;i++){
            while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i]){
                int temp = stack.pop();
                recordMap.put(nums2[temp],nums2[i]);
            }
            stack.add(i);
        }

        for(int i = 0;i < nums1.length;i++){
            resultArr[i] = recordMap.containsKey(nums1[i])
                    ? recordMap.get(nums1[i]) : -1;
        }

        return resultArr;
    }
}
