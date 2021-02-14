package LCEveryDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_765 {
    public static void main(String[] args) {
//        int[] row = {0, 2, 1, 3};
//        int[] row = {3, 2, 0, 1};
        int[] row = {5,6,4,0,2,1,9,3,8,7,11,10};
        int result = minSwapsCouples(row);

        System.out.println(result);
    }

    // 使用并查集
    public static int minSwapsCouples(int[] row) {
        int length = row.length;

        int totalPair = length / 2;
        int[] arr = new int[totalPair];

        for(int i = 0;i < length / 2;i++){
            arr[i] = i;
        }

        for(int i = 0;i < length;i += 2){
            int left = row[i] / 2;
            int right = row[i + 1] / 2;

//            if(left != right){
//                if(left < right){
//                    union(arr,left,right);
//                }else{
//                    union(arr,right,left);
//                }
//            }
//            System.out.println("连接L:" + left + " -> " + right);
            union(arr,left,right);
        }
//
//        for(int num : arr){
//            System.out.print(num + " ");
//        }
//        System.out.println();

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < totalPair;i++){
            int rootx = find(arr,i);
            if(rootx == i){
                continue;
            }
            map.put(rootx,map.getOrDefault(rootx,0) + 1);
        }

        int result = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
//            result += entry.getValue() - 1;
            result += entry.getValue();
        }

        return result;
    }

    public static int find(int[] arr,int x){
        if(arr[x] == x){
            return x;
        }

        arr[x] = find(arr,arr[x]);
        return arr[x];
    }

    // 将x合并到y上
    public static void union(int[] arr,int x,int y){
        int rootx = find(arr,x);
        int rooty = find(arr,y);

//        if(rootx != rooty){
            arr[rootx] = rooty;
//        }
    }


}
