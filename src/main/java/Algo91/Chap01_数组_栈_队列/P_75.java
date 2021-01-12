package Algo91.Chap01_数组_栈_队列;


//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
// 示例 1：
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
//
//
// 示例 2：
//输入：nums = [2,0,1]
//输出：[0,1,2]
//
//
// 示例 3：
//输入：nums = [0]
//输出：[0]
//
//
// 示例 4：
//输入：nums = [1]
//输出：[1]
public class P_75 {
    public static void main(String[] args) {
//        int[] nums = {2,0,2,1,1,0};
//        int[] nums = {2,0,1};
//        int[] nums = {0};
        int[] nums = {1};
        sortColors(nums);

        for(int num : nums){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void sortColors(int[] nums) {
        int length = nums.length;
        if(length <= 1){
            return ;
        }

        // 只有0,1,2，可以使用三路快排的代码
        // 原地排序
        int zero = -1;
        int temp = 0;
        int two = length - 1;

        while(temp <= two){
            int val = nums[temp];

            if(val == 0){
                zero++;
                swap(nums,zero,temp);
                temp++;
            }else if(val == 1){
                temp++;
            }else{
                swap(nums,temp,two);
                two--;
            }
        }

        return ;
    }

    public static void swap(int[] nums,int from,int to){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
