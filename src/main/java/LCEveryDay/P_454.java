package LCEveryDay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_454 {
    public static void main(String[] args) {

        int[] A ={1,2};
        int[] B = {-2,-1};
        int[] C = {-1,2};
        int[] D = {0,2};


//        int[] A = {-1,-1};
//        int[] B = {-1,1};
//        int[] C = {-1,1};
//        int[] D = {1,-1};

        int result = fourSumCount(A, B, C, D);
        System.out.println(result);
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length;
        if(length == 0){
            return 0;
        }

        int count = 0;

        // sum --> count
        Map<Integer,Integer> map1 = new HashMap<>();

        for(int i = 0;i < length;i++){
            for(int j = 0;j < length;j++){
                int tempSum = A[i] + B[j];
                map1.put(tempSum,map1.getOrDefault(tempSum,0) + 1);
            }
        }

        for(int i = 0;i < length;i++){
            for(int j = 0;j < length;j++){
                int tempSum = C[i] + D[j];
                if(map1.containsKey(-tempSum)){
                    count += map1.get(-tempSum);
                }
            }
        }

        return count;
    }


    // 暴力循环
    public static int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length;
        if(length == 0){
            return 0;
        }

        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);

        int count = 0;

        // 如何对四层for循环优化？
        for(int i = 0;i < length;i++){
//            if(i > 0 && A[i - 1] == A[i]){
//                continue;
//            }
            for(int j = 0;j < length;j++){
//                if(j > 0 && B[j - 1] == B[j]){
//                    continue;
//                }
                for(int k = 0;k < length;k++){
//                    if(k > 0 && C[k - 1] == C[k]){
//                        continue;
//                    }
                    for(int l = 0;l < length;l++){
//                        if(l > 0 && D[l - 1] == D[l]){
//                            continue;
//                        }
                        if(A[i] + B[j] + C[k] + D[l] == 0){
//                            System.out.println(i + ":" + j + ":" + k + ":" + l);
                            System.out.println(A[i] + ":" +  B[j] + ":" + C[k] + ":" + D[l]);
                            count++;
//                            if(D[l] >= 0){
//                                break;
//                            }
                        }

                    }
                }
            }

        }

        return count;
    }
}
