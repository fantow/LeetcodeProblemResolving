package Classify400.Array.基础;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_134 {
    public static void main(String[] args) {
//        ---- test1 ----
//        int[] gas = {1,2,3,4,5};
//        int[] cost = {3,4,5,1,2};

//        ---- test2 ----
//        int[] gas = {2,3,4};
//        int[] cost = {3,4,3};

//        ---- test3 ----
//        int[] gas = {3,3,4};
//        int[] cost = {3,4,4};

//        ---- test4 ----
        int[] gas = {3,1,1};
        int[] cost = {1,2,2};

        int result = canCompleteCircuit1(gas, cost);

        System.out.println(result);
    }

    // 可以通过模拟所有场景来判断是否可以到达
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;

        int curGas = 0;

        int tempPtr = -1;
        for(int start = 0;start < length;start++){
            curGas = gas[start];
            int journeyCount = 0;
            boolean flag = true;
            for(;journeyCount < length;journeyCount++){
                tempPtr = (journeyCount + start) % length;
                if(curGas < cost[tempPtr]){
                    flag = false;
                    break;
                }else{
                    curGas = curGas - cost[tempPtr] + gas[(tempPtr + 1) % length];
                    System.out.println("curGas:" +curGas + " tempPtr:" + tempPtr + " journeyCount:" + journeyCount + " flag:" + flag);
                }
            }

            if((tempPtr + 1) % length == start && flag){
                return start;
            }
        }

        return -1;
    }


    // 通过只遍历一次得到结果
    // 条件1.首先证明在整个路中，一定存在起点能到达终点(就是sum(gas) >= sum(cost))
    // 条件2.如果有一条路A站到D站，遍历过程中发现A站不能到达D站，那么A~D之间的所有站都无法到达D站(因为全部是A到D的子集)
    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int length = gas.length;

        int curTank = 0;
        int sumTank = 0;
        int start = 0;

        for(int i = 0;i < length;i++){
            curTank += gas[i] - cost[i];
            sumTank += gas[i] - cost[i];

            if(curTank < 0){
                start = i + 1;
                curTank = 0;
            }
        }

        return sumTank >= 0 ? start : -1;
    }


}
