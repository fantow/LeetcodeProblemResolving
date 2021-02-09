package LCEveryDay;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_992 {
    public static void main(String[] args) {
        int[] A = {1,2,1,2,3};
        int k = 2;


//        int[] A = {1,2,1,3,4};
//        int k = 3;


//        int[] A = {1,2};
//        int k = 1;


//        int[] A = {2,1,1,1,2};
//        int k = 1;


        int result = subarraysWithKDistinct(A, k);
        System.out.println(result);
    }



    // 题解解法，先求出最多有k个元素的组合个数，再求出最多有(k-1)个元素的组合个数，再一减就行了
    public static int subarraysWithKDistinct(int[] A, int K) {

        int maxK = getMaxKCount(A,K);
        int maxKMinusOne = getMaxKCount(A,K - 1);

        System.out.println(maxK);
        System.out.println(maxKMinusOne);

        System.out.println();
        return maxK - maxKMinusOne;
    }

    public static int getMaxKCount(int[] A,int k) {
        int length = A.length;

        int left = 0;
        int right = 0;

        // 用Map吧，不只是个位数
        Map<Integer,Integer> map = new HashMap<>();

        int count = 0;
        int diff = 0;

        // 采用滑动窗口
        while (right < length) {
            // 当前窗口没出现过
            if (!map.containsKey(A[right])) {
                diff++;
            }
            map.put(A[right],map.getOrDefault(A[right],0) + 1);

            // 如果当前窗口不同的数字个数超过k个，滑动左侧
            while (diff > k) {
                map.put(A[left],map.get(A[left]) - 1);
                if (map.get(A[left]) == 0) {
                    map.remove(A[left]);
                    diff--;
                }
                left++;
            }

            // 这样算其实是算在[left,right]这个区间内的所有子区间的个数：
            // 为了避免重复计算，都是以right作为右区间的子区间：
            // [left,right],[left - 1,right],[left - 2,right],......,[right - 1,right]
            count += right - left + 1;
            right++;
        }

        return count;
    }

    // 【O(n^2)的时间复杂度会超时】
    public static int subarraysWithKDistinct1(int[] A, int K) {
        int length = A.length;

        int count = 0;

        for(int i = 0;i < length;i++){
            Set<Integer> set = new HashSet<>();
            set.add(A[i]);

            if(set.size() == K){
                count++;
            }else if(set.size() > K){
                break;
            }

            for(int j = i + 1;j < length;j++){
                set.add(A[j]);
                if(set.size() == K){
                    count++;
                }else if(set.size() > K){
                    break;
                }
            }
        }

        return count;
    }
}
