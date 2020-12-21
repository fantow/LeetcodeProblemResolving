package Hot100;

public class P_55_1 {
    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
        int[] nums = {3,2,1,0,4};
        boolean flag = canJump(nums);

        System.out.println(flag);
    }

    public static boolean canJump(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return true;
        }

        boolean[] canArriveHere = new boolean[length];

        canArriveHere[0] = true;

        for(int i = 0;i < length;i++){
            if(canArriveHere[i] == true){
                int stepCount = nums[i];
    //            if(stepCount >= 0){
    //                canArriveHere[i] = true;
    //            }

                for(int j = 1;j <= stepCount && i + j < length;j++){
                    canArriveHere[i + j] = true;
                }
            }else{
                return false;
            }
        }

        return canArriveHere[length - 1];
    }
}
