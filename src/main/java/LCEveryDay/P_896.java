package LCEveryDay;

public class P_896 {
    public static void main(String[] args) {
//        int[] A = {1,2,2,3};
//        int[] A = {6,5,4,4};
//        int[] A = {1,3,2};
//        int[] A = {1,2,4,5};
        int[] A = {1,1,1};

        boolean flag = isMonotonic(A);
        System.out.println(flag);
    }


    // 判断该数组是否是单增/单减的
    public static boolean isMonotonic(int[] A) {
        int length = A.length;

        int[] arr = new int[length - 1];
        // 是否是单增队列
        boolean flag = true;

        for(int i = 1;i < length;i++){
            arr[i - 1] = A[i] - A[i-1];
        }

        // 再去判断arr[]如果都是非负就为单增，都是非正就是单减，否则返回false
        int isPositive = 0;
        for(int i = 0;i < length - 1;i++){
            if(isPositive == 0){
                if(arr[i] > 0){
                    isPositive = 1;
                }else if(arr[i] < 0){
                    isPositive = -1;
                }
            }else {
                if(isPositive > 0 && arr[i] < 0){
                    return false;
                }else if(isPositive < 0 && arr[i] > 0){
                    return false;
                }
            }
        }

        return true;
    }
}
