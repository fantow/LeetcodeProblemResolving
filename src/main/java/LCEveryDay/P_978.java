package LCEveryDay;

public class P_978 {
    public static void main(String[] args) {
//        int[] arr = {9,4,2,10,7,8,8,1,9};
//        int[] arr = {4,8,12,16};
//        int[] arr = {100};
//        int[] arr = {1,2};
        int[] arr = {0,1,1,0,1,0,1,1,0,0};

        int result = maxTurbulenceSize(arr);
        System.out.println(result);
    }

    // DP
    public static int maxTurbulenceSize(int[] arr) {
        int length = arr.length;

        int[] up = new int[length];
        int[] down = new int[length];

        for(int i = 0;i < length;i++){
            up[i] = 1;
            down[i] = 1;
        }

        int ans = 1;

        for(int i = 1;i < length;i++){
            if(arr[i] < arr[i - 1]){
                down[i] = up[i - 1] + 1;
                ans = Math.max(ans,down[i]);
            }else if(arr[i] > arr[i - 1]){
                up[i] = down[i - 1] + 1;
                ans = Math.max(ans,up[i]);
            }
        }

        for(int i = 0;i < length;i++){
            System.out.print(up[i] + " ");
        }
        System.out.println();

        for(int i = 0;i < length;i++){
            System.out.print(down[i] + " ");
        }
        System.out.println();

        return ans;
    }

    // 【题目没看懂，好像和k的奇偶没什么关系】
    public static int maxTurbulenceSize1(int[] arr) {
        int length = arr.length;

        if(length == 1){
            return 1;
        }

        // 只记录gap
        boolean[] gap = new boolean[length - 1];


        for(int i = 0;i < length - 1;i++){
            // 是偶数
            if(i % 2 == 0){
                gap[i] = arr[i] < arr[i + 1] ? true : false;
            } else{
            // 是奇数
                gap[i] = arr[i] > arr[i + 1] ? true : false;
            }
        }

        int max = 0;
        int len = 0;
        // 最大连续的true + 1
        for(int i = 0;i < gap.length;i++){
            if(gap[i] == true){
                len ++;
            }else {
                max = Math.max(len + 1,max);
                len = 0;
            }
            System.out.print(gap[i] + " ");
        }
        System.out.println();

        if(len != 0){
            max = Math.max(len + 1,max);
        }

        return max;
    }
}
