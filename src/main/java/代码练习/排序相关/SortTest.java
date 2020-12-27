package 代码练习.排序相关;

import java.util.Random;

// 这里提供一个测试环境
public class SortTest {
    public static void main(String[] args) {
        Random random = new Random();

        for(int i = 0;i < 1000;i++){
            // 默认对一个1000个元素的数组进行排序
            int[] nums = new int[1000];
            for(int j = 0;j < nums.length;j++){
                nums[j] = random.nextInt();
            }

            // 在这里创建排序相关的代码，并且返回void即可

            // 1.快排
//            QuickSort quickSort = new QuickSort();
//            quickSort.quickSort(nums,0,nums.length - 1);

            // 2.归并排序
//            MergeSort mergeSort = new MergeSort();
//            mergeSort.mergeSort(nums,0,nums.length - 1);

            // 3.冒泡排序
//            BubbleSort bubbleSort = new BubbleSort();
//            bubbleSort.bubbleSort(nums);

            // 4.选择排序
//            SelectSort selectSort = new SelectSort();
//            selectSort.selectSort(nums);

            // 5.插入排序
//            InsertSort insertSort = new InsertSort();
//            insertSort.insertSort(nums);

            // 6.堆排序
            DumpSort dumpSort = new DumpSort();
            dumpSort.dumpSort(nums);



            // 判定为递增
            for(int k = 1;k < nums.length;k++){
                if(nums[k] < nums[k - 1]){
                    System.out.println("Err");;
                    break;
                }
            }
        }
        System.out.println("end...");
    }
}
