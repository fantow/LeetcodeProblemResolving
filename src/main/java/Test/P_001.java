package Test;

import java.util.*;

public class P_001 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        while(scanner.hasNext()){
            list.add(scanner.nextInt());
        }
//        int[] arr = {-2,1,-3,-10,-1,2,1,-5,4};

        int[] arr = new int[list.size()];

        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();

        int length = arr.length;

        if(length <= 0){
            System.out.println(0);
        }

        // 先构造前缀和
        int[] sumArr = new int[arr.length];

        int temp = 0;
        for(int i = 0;i < arr.length;i++){
            temp += arr[i];
            sumArr[i] = temp;
        }

        // Num --> Index
        Map<Integer,Integer> map = new HashMap<>();

        // 将数字下标存入Map，如果最小元素的下标<最大元素下标，就可以得到结果，否则修改最大元素
        for(int i = 0;i < sumArr.length;i++){
            map.put(sumArr[i],i);
        }

        int[] resultArr = new int[2];

        // 应该用单调栈比较简单
        Stack<Integer> stack = new Stack<>();

        int maxVal = Integer.MIN_VALUE;
        int leftResult = 0;
        int rightResult = 0;

        // 双指针试试
        int left = 0;
        int right = 0;

        while(right < length){
            if(sumArr[left] <= sumArr[right]){
                if(maxVal < (sumArr[right] - sumArr[left])){
                    maxVal = sumArr[right] - sumArr[left];
                    leftResult = left;
                    rightResult = right;
                    right++;
                }else{
                    right++;
                }
            }else{
                left = right;
            }
        }

        resultArr[0] = leftResult + 1;
        resultArr[1] = rightResult;

        System.out.println(resultArr[0] + " -> " + resultArr[1]);
    }
}
