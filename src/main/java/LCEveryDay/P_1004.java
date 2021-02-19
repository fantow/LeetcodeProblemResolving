package LCEveryDay;

public class P_1004 {
    public static void main(String[] args) {
        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
        int K = 2;

//        int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
//        int K = 3;

//        int[] A = {0,0,1,1,1,0,0};
//        int K = 0;

        int result = longestOnes(A, K);
        System.out.println(result);
    }

    // 可以更改题意：将K个值从0变为1求最长数组，改变为 -->
    // 求一个最长数组，需要保证该数组中0的个数最多为K个
    // 变为了一个窗口变动的滑动窗口问题
    public static int longestOnes(int[] A, int K) {
        int length = A.length;

        int left = 0;
        int right = 0;
        // 还剩下可以改变0的个数
        int reduency = K;

        int maxLength = 0;
//        int currentLength = 0;

        while(left <= right && right < length){
            if(A[right] != 0){
                maxLength = Math.max(maxLength,(right - left + 1));
            }else{
                // 如果不为1，则需要考虑K够不够用，如果不够用，需要移动left
                if(reduency > 0){
                    reduency--;
                    maxLength = Math.max(maxLength,(right - left + 1));
                }else{
                    while(left <= right && A[left] != 0){
                        left++;
                    }

                    if(left == right){
                        left++;
                        right++;
                        continue;
                    }

                    left++;
                    reduency++;
                    maxLength = Math.max(maxLength,(right - left + 1));

                    continue;
                }
            }

            right++;
        }

        return maxLength;
    }
}
