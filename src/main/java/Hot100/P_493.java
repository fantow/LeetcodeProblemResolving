package Hot100;

public class P_493 {
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};

//        int[] nums = {2,4,3,5,1};

//        int[] nums = {5,4,3,2,1};

//        int[] nums = {-5,-5};

//        int[] nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        int result = reversePairs(nums);
//        for(int i = 0;i < nums.length;i++){
//            System.out.print(nums[i] + " ");
//        }
//        System.out.println();
        System.out.println(result);
    }

    // 逆序对问题，使用归并排序
    public static int reversePairs(int[] nums) {
        int length = nums.length;

        if(length == 0 || length == 1){
            return 0;
        }

        int left = 0;
        int right = length - 1;

        int result = mergeSort(nums,left,right);

        return result;
    }

    public static int mergeSort(int[] nums,int left,int right){
        if(right - left < 1){
            return 0;
        }

        int mid = left + (right - left) / 2;
        int reuslt = 0;
        reuslt += mergeSort(nums,left,mid);
        reuslt += mergeSort(nums,mid + 1,right);

        int i = left;
        int j = mid + 1;
        while(i <= mid){
            while(j <= right && (long)nums[i] > 2 * (long)nums[j]){
                j++;
            }
            reuslt += j - mid - 1;
            i++;
        }

        sort(nums,left,right);
        return reuslt;
    }

    public static int sort(int[] nums,int left,int right){
        int length = nums.length;
        long[] tempArr = new long[length];

        int mid = left + (right - left) / 2;
        // 拷贝数组
        for(int i = left;i <= right;i++){
            tempArr[i] = nums[i];
        }
        int count = 0;

        // 在tempArr中进行比较，再将其直接拷贝会nums数组
        int idx = left;
        int i = 0;
        int j = 0;
        for(i = left,j = mid + 1;i <= mid && j <= right;idx++){
//            System.out.println(tempArr[i] + " : " + tempArr[j]);
            // 要逆序存
            if(tempArr[i] <= tempArr[j]){
                nums[idx] = (int)tempArr[i++];
            }else{
                nums[idx] = (int)tempArr[j++];
            }
        }

        while(i <= mid){
            nums[idx++] = (int)tempArr[i++];
        }

        while(j <= right){
            nums[idx++] = (int)tempArr[j++];
        }

        return count;
    }

}
