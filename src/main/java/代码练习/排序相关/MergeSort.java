package 代码练习.排序相关;

public class MergeSort {
    public static void main(String[] args) {
//        int[] nums = {5,4,3,2,1};
//        int[] nums = {5,4,7,2,1};
        int[] nums = {1,2,3,4,5};
        MergeSort mergeSort = new MergeSort();

        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        mergeSort.mergeSort(nums,0,mid);
        mergeSort.mergeSort(nums,mid + 1,right);
        mergeSort.merge(nums,left,right);

        for(int num : nums){
            System.out.print(num + " ");
        }
    }

    public void merge(int[] nums,int left,int right){
        if(left < right){
            int length = right - left + 1;
            int[] tempArr = new int[length];

            for(int i = 0;i < length;i++){
                tempArr[i] = nums[left + i];
            }

            int mid = left + (right - left) / 2;

            int l = left;
            int r = mid + 1;

            int idx = left;

            while(l <= mid && r <= right){
                if(tempArr[l - left] < tempArr[r - left]){
                    nums[idx] = tempArr[l - left];
                    l++;
                }else{
                    nums[idx] = tempArr[r - left];
                    r++;
                }
                idx++;
            }

            while(l <= mid){
                nums[idx++] = tempArr[l - left];
                l++;
            }

            while(r <= right){
                nums[idx++] = tempArr[r - left];
                r++;
            }
        }
    }

    public void mergeSort(int[] nums,int left,int right){
        if(left < right){
            int mid = left + (right - left) / 2;

            mergeSort(nums,left,mid);
            mergeSort(nums,mid + 1,right);
            merge(nums,left,right);
        }
    }
}
