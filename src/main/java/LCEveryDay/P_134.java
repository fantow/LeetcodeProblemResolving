package LCEveryDay;

import Hot100.P_2;

public class P_134 {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        int result = canCompleteCircuit(gas, cost);
        System.out.println(result);
    }

    public static int canCompleteCircuit(int[] gas,int[] cost){
        int length = gas.length;
        if(length == 0){
            return 0;
        }

        int remain = 0;
        int minRemain = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 0;i < length;i++){
            remain += (gas[i] - cost[i]);
            if(remain < minRemain){
                minRemain = remain;
                minIndex = i;
            }
        }

        return remain >= 0 ? (minIndex + 1) % length : -1;
    }



//    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        int length = gas.length;
//        if(length == 0){
//            return 0;
//        }
//
//        int result = 0;
//
//        // 先判断是否有结果
//        // 只有gas的总和 >= cost的总和时，才可能有结果
//        for(int i = 0;i < length;i++){
//            result += gas[i];
//            result -= cost[i];
//        }
//
//        if(result < 0){
//            return -1;
//        }
//
//        int[] temp = new int[length];
//        int[] remain = new int[length];
//
//        int firstNonPositive = -1;
//        boolean getIndex = false;
//        for(int i = 0;i < length;i++){
//            temp[i] = gas[i] - cost[i];
//            if(temp[i] == -1 && getIndex == false){
//                firstNonPositive = temp[i];
//                getIndex = true;
//            }
//        }
//
//        // 从temp[i]中第一个非负数开始遍历
//
//
//
//        return 0;
//    }
}
