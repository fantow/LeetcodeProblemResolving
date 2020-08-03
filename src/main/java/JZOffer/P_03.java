package JZOffer;

import java.util.*;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */

//找出数组中重复的数字。
//    在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
//    数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
//    请找出数组中任意一个重复的数字。
public class P_03 {

    private static final int[] testArray1 = new int[]{2, 3, 1, 0, 2, 5, 3};
    private static final int[] testArray2 = new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    private static final List<int[]> testList = new ArrayList<int[]>();
    static{
        testList.add(testArray1);
        testList.add(testArray2);
    }

    public static void main(String[] args) {
        for(int[] array : testList){
            int result = findRepeatNumber1(array);
            System.out.println(result);
        }
    }

    // 方法一.时间复杂度O(logn)，空间复杂度O(1)
    public static int findRepeatNumber1(int[] nums){
        int length = nums.length;
        Arrays.sort(nums);
        for(int i = 1;i < length;i++){
            if(nums[i] == nums[i - 1]){
                return nums[i];
            }
        }
        return -1;
    }

    // 方法二.使用set集合,时间复杂度O(n)，空间复杂度O(n)
    public static int findRepeatNumber2(int[] nums){
        Set<Integer> duplicSet = new HashSet<Integer>();

        for(int num : nums){
            boolean flag = duplicSet.add(num);
            if(!flag){
                return num;
            }
        }
        return -1;
    }

    // 方法三.可因题意，使用临时数组,记录对应值出现次数，原理和使用Set相同
    // 时间复杂度O(n)，空间复杂度O(n)
    public static int findRepeatNumber3(int[] nums){
        int length = nums.length;
        int[] tmpArray = new int[length];
        for(int num : nums){
            tmpArray[num]++;
            if(tmpArray[num] > 1){
                return num;
            }
        }
        return -1;
    }


    // 方法四.原地置换
    public static int findRepeatNumber4(int[] nums){
        int length = nums.length;
        int tmpNum = -1;
        for(int i = 0;i < length;i++){
            while(i != nums[i]){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                tmpNum = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmpNum;
            }
        }
        return -1;
    }

//     方法在剑指Offer上介绍过，但是并不是一个好方法，存在用例限制
    public static int findRepeatNumber5(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int count = -1;
        while(left < right){
            int mid = left + (right - left) / 2;
            count = countNum(nums,nums[mid]);
            // 重复一定出现在nums[mid]的左侧
            if(count > nums[mid] + 1){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return nums[left];
    }

    private static int countNum(int[] nums,int target){
        int count = 0;
        int length = nums.length;
        for(int i = 0;i < length;i++){
            if(nums[i] <= target){
                count++;
            }
        }
        return count;
    }

}
