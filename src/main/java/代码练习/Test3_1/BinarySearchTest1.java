package 代码练习.Test3_1;

public class BinarySearchTest1 {
    public static void main(String[] args) {

    }

    public int binarySearch1(int[] nums,int target){
        int length = nums.length;

        int left = 0;
        int right = length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
//            if(check(mid)){
//                right = mid;
//            }else{
//                left = mid + 1;
//            }

        }

        return left;
    }


    public int binarySearch2(int[] nums,int target){
        int length = nums.length;

        int left = 0;
        int right = length - 1;

        while(left < right){
            int mid = (left + right + 1) / 2;

//            if(check(mid)){
//                left = mid;
//            }else{
//                right = mid - 1;
//            }
        }

        return left;
    }

}
