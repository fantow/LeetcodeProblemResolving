package LCEveryDay;

import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class P_480 {
    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int k = 3;

        int[] nums = {2147483647,2147483647};
        int k = 2;

        double[] doubles = medianSlidingWindow(nums, k);

        for(double num : doubles){
            System.out.print(num + " ");
        }
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        double[] resultArr = new double[length - k + 1];

        int[] windowsArr = new int[k];

        int left = 0;
        int right = 0;

        int idx = 0;
        int idxx = 0;

        for(;right < k;right++){
            windowsArr[idx++] = nums[right];
        }

        // 先对数组进行排序
        Arrays.sort(windowsArr);
        resultArr[idxx++] = getMiddleResult(windowsArr,k);


        for(int i = 0;i < length - k;i++){
            for(int num : windowsArr){
                System.out.print(num + " ");
            }
            System.out.print("search:" + nums[i]);

            System.out.println();

            int deleteIdx = search(windowsArr,nums[i]);

            // 将新元素替换出队元素
            windowsArr[deleteIdx] = nums[i + k];


            while (deleteIdx < windowsArr.length - 1 && windowsArr[deleteIdx] > windowsArr[deleteIdx + 1]) {
                swap(windowsArr, deleteIdx, deleteIdx + 1);
                deleteIdx++;
            }
            //向前冒泡
            while (deleteIdx > 0 && windowsArr[deleteIdx] < windowsArr[deleteIdx - 1]) {
                swap(windowsArr, deleteIdx, deleteIdx - 1);
                deleteIdx--;
            }

            resultArr[idxx++] = getMiddleResult(windowsArr,k);
        }

        return resultArr;
    }

    public static void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    // 采用二分查找，找到需要删除的元素下标
    public static int search(int[] arr,int num){
        int length = arr.length;
        int left = 0;
        int right = length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == num){
                return mid;
            }else if(arr[mid] > num){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public static double getMiddleResult(int[] arr,int k){
        if(k % 2 == 0){
            long temp  = 0;
            temp += arr[k / 2 - 1];
            temp += arr[k / 2];
            return temp / 2.0;
        }else{
            return arr[k / 2];
        }
    }


    // 要求找到滑动窗口中的中位数，先试试如果采用最简单的方式求解
    public static double[] medianSlidingWindow2(int[] nums, int k) {
        int length = nums.length;

        int left = 0;
        int right = 0;

        double[] resultArr = new double[length - k + 1];
        int idx = 0;

        Deque<Integer> queue = new LinkedList<>();
//        queue.offerLast(nums[right]);

        for(;right < length;right++){
            queue.offerLast(nums[right]);
            if(right - left + 1 < k){
                continue;
            }

            double result = getResult(queue);
            resultArr[idx++] = result;
            queue.pollFirst();
        }

        return resultArr;
    }

    // 需要对每个窗口内的数字进行，排序，会超时
    public static double getResult(Deque<Integer> queue){
        int length = queue.size();
        int[] tempArr = new int[length];

        Iterator<Integer> iterator = queue.iterator();
        int idx = 0;

        while(iterator.hasNext()){
            tempArr[idx++] = iterator.next();
        }

        Arrays.sort(tempArr);

        if(length % 2 == 0){
            long temp = tempArr[length / 2 - 1];
            temp += tempArr[length / 2];
            return (double)(temp / 2.0);
        }else{
            return tempArr[length / 2];
        }

    }

}
