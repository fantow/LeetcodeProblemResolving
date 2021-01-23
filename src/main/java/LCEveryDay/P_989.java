package LCEveryDay;

import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class P_989 {
    public static void main(String[] args) {
//        int[] A = {1,2,0,0};
//        int K = 34;

//        int[] A = {2,7,4};
//        int K = 181;

//        int[] A = {2,1,5};
//        int K = 806;

//        int[] A= {9,9,9,9,9,9,9,9,9,9};
//        int K = 1;

        int[] A = {0};
        int K = 23;

        List<Integer> list = addToArrayForm(A, K);

        for(Integer num : list){
            System.out.print(num + " ");
        }

    }

    // 先都转为int[]，再去每位加
    public static List<Integer> addToArrayForm(int[] A, int K) {
        int length = A.length;

        List<Integer> tempList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        while(K != 0){
            int temp = K % 10;
            tempList.add(temp);
            K /= 10;
        }

        int[] kArr = new int[tempList.size()];
        for(int i = 0;i < tempList.size();i++){
            kArr[i] = tempList.get(i);
        }

        // 将A数组整体逆置，方便计算
        swapArr(A);


        // 目前获得了int[] A和int[] kArr，需要将长的赋值给A
        if(A.length < kArr.length){
            int[] temp = kArr;
            kArr = A;
            A = temp;
        }

//        for(int i = 0;i < kArr.length;i++){
//            System.out.print(kArr[i] + " ");
//        }
//        System.out.println();




        // 用来表示加法的进位
        int digital = 0;

        for(int i = 0;i < kArr.length;i++) {
            int temp = A[i];
            temp += kArr[i];
            temp += digital;

            digital = 0;

            if (temp >= 10) {
                temp = temp % 10;
                digital = 1;
            }

            resultList.add(temp);
        }

        // 处理超过K长度部分的数字
        for(int i = kArr.length;i < A.length;i++){
            int temp = digital;
            digital = 0;

            temp += A[i];

            if(temp >= 10){
                temp = temp % 10;
                digital = 1;
            }

            resultList.add(temp);
        }

        if(digital != 0){
            resultList.add(digital);
        }

        // 再将list逆置
        for(int i = 0;i < resultList.size() / 2;i++){
            int temp = resultList.get(i);
            resultList.set(i,resultList.get(resultList.size() - 1 - i));
            resultList.set(resultList.size() - 1 - i,temp);
        }

        return resultList;
    }

    // 需要将A数组整体逆置
    public static void swapArr(int[] arr){
        int length = arr.length;

        for(int i = 0;i < length / 2;i++){
            int temp = arr[i];
            arr[i] = arr[length - 1 - i];
            arr[length - 1 - i] = temp;
        }
        return ;
    }

}
