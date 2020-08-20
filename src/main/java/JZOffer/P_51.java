package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_51 {

    public static int count = 0;
//    public static int[] tempNums = new int[50001];


    public static void main(String[] args) {
//        ---- test1 ----
//        int[] nums = {7,5,6,4};

//        ---- test2 ----
        int[] nums = {7,5,4,6};

        int[] tempArr = new int[nums.length];

        int result = reversePairs(nums,tempArr);

        System.out.println(result);
    }

    // 利用归并排序修改
    public static int reversePairs(int[] nums,int[] tempArr) {
        int length = nums.length;

        int left = 0;
        int right = length - 1;


        mergeSort(nums,left,right,tempArr);

        return count;
    }

    public static void mergeSort(int[] nums,int left,int right,int[] tempArr){
        if(left < right){
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid, tempArr);
            mergeSort(nums,mid + 1,right,tempArr);
            merge(nums,left,right,mid,tempArr);
        }
    }

    // tempArr只从0开始用
    public static void merge(int[] nums,int left,int right,int mid,int[] tempArr){
        int i = left;
        int j = mid + 1;
        int idx = 0;
        while(i <= mid && j <= right){
            if(nums[i] > nums[j]){
                count += right - j + 1;
                tempArr[idx++] = nums[i++];
            }else{
                tempArr[idx++] = nums[j++];
            }
        }

        while(i <= mid){
            tempArr[idx++] = nums[i++];
        }

        while(j <= right){
            tempArr[idx++] = nums[j++];
        }

        for(int t = 0;t < idx;t++){
            nums[left + t] = tempArr[t];
        }
    }

//        一段规范的归并排序代码
//    public static void mergeSort(int[] nums,int left,int right,int[] tempArr){
//        if(left < right){
//            int mid = left + (right - left) / 2;
//            mergeSort(nums,left,mid,tempArr);
//            mergeSort(nums,mid + 1,right,tempArr);
//            merge(nums,left,right,mid,tempArr);
//        }
//    }
//
//
//    public static void merge(int[] nums,int left,int right,int mid,int[] tempArr){
//        int i = 0;
//        int j = left;
//        int k = mid + 1;
//        while(j <= mid && k <= right){
//            if(nums[j] < nums[k]){
//                tempArr[i++] = nums[j++];
//            }else{
//                tempArr[i++] = nums[k++];
//            }
//        }
//
//        while(j <= mid){
//            tempArr[i++] = nums[j++];
//        }
//        while(k <= right){
//            tempArr[i++] = nums[k++];
//        }
//
//        for(int t = 0;t < i;t++){
//            nums[left + t] = tempArr[t];
//        }
//
//        return ;
//    }

}
