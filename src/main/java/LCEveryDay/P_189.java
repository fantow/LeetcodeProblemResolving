package LCEveryDay;

public class P_189 {
    public static void main(String[] args) {

//        5,6,7,1,2,3,4
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

//        3,99,-1,-100
//        int[] nums = {-1,-100,3,99};
//        int k = 2;

//        int[] nums = {1,2,3};
//        int k = 4;

        rotate(nums,k);

        for(int num : nums){
            System.out.print(num + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        if(k >= length){
            k = k % length;
        }

        int newK = nums.length - 1 - k;

        rotateFunc(nums,0,newK);
        rotateFunc(nums,newK + 1,length - 1);
        rotateFunc(nums,0,length - 1);
    }

    // 将start~end区间中的数字换逆置
    public static void rotateFunc(int[] nums,int start,int end){
        int length = end - start + 1;
//        System.out.println("len:" + length);
        if(start < 0 || start >= nums.length || end < 0 || end >= nums.length){
            return ;
        }

        for(int i = 0;i < length / 2;i++){
//            System.out.println("交换了:" + (start + i) + " -> " + (end - i));
            swap(nums,start + i,end - i);
        }
        return;
    }

    public static void swap(int[] nums,int from,int to){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

}
