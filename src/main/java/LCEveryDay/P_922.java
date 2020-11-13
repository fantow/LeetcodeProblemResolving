package LCEveryDay;

public class P_922 {
    public static void main(String[] args) {

//        int[] A = {4,2,5,7};
//        int[] A = {1,0};
//        int[] A = {2,3,1,1,4,0,0,4,3,3};
        int[] A = {2,3};
        int[] result = sortArrayByParityII(A);
        for(int num : result){
            System.out.print(num + " ");
        }
    }

    public static int[] sortArrayByParityII(int[] A) {
        int length = A.length;
        if(length == 0){
            return new int[0];
        }

//        int left = 0;
//        int right = length - 1;
//        int temp = -1;

        // 保证开始时的left和right分别指向偶和奇长度数
        // 其实这个判断没用，因为一半奇，一半偶，总数一定是偶数，最后一个元素的下标一定是奇数
//        if(right % 2 == 0 && A[right] % 2 == 0){
//            temp = right;
//            right--;
//        }

//        while(left <= right){
//
//            while(left <= right && (A[left] % 2) == (left % 2)){
//                left++;
//            }
//
//            while(left <= right && (A[right] % 2) == (right % 2)){
//                right--;
//            }
//
//            int tmp = A[left];
//            A[left] = A[right];
//            A[right] = tmp;
//
//            left++;
//            right--;
//        }


        // 普通的双指针从头尾遍历的应该没法做，会有两个指针同为偶下标，但是同为奇数的情况，这种情况会导致交换也不符合要求
        // 所以应该采用指向奇偶下标的指针
        int even = 0;
        int odd = 1;

        while(even < length && odd < length){
            while(even < length && even % 2 == (A[even] % 2)){
                even += 2;
            }

            while(odd < length && odd % 2 == (A[odd] % 2)){
                odd += 2;
            }

            // 表明不是因为遍历结束而进入的if
            if(even < length && odd < length){
                int temp = A[even];
                A[even] = A[odd];
                A[odd] = temp;
                even += 2;
                odd += 2;
            }
        }

        return A;
    }

}
