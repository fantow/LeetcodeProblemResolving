package Hot100;

public class P_279 {
    public static void main(String[] args) {
//        int n = 12;
        int n = 13;
        int result = numSquares(n);

        System.out.println(result);
    }

    public static int numSquares(int n) {
        int[] dpArr = new int[n + 1];

        dpArr[0] = 0;
        if(n == 0){
            return 0;
        }
        dpArr[1] = 1;
        if(n == 1){
            return 1;
        }

        for(int i = 2;i <= n;i++){
            // 每一轮需要操作的数为i
            int baseNum = (int)Math.sqrt(i);
            if(baseNum * baseNum == i){
                dpArr[i] = 1;
                continue;
            }else{
                int minCount = Integer.MAX_VALUE;
                for(int j = 1;j <= i / 2;j++){
                    minCount = Math.min(minCount,dpArr[j] + dpArr[i - j]);
                }
                dpArr[i] = minCount;
            }
        }

        for(int arr : dpArr){
            System.out.print(arr + " ");
        }
        System.out.println();

        return dpArr[n];
    }
}
