package Hot100;

public class P_338 {
    public static void main(String[] args) {
//        int num = 5;
//        int num = 2;
        int num = 7;
        int[] resultArr = countBits(num);

        for(int i = 0;i < resultArr.length;i++){
            System.out.print(resultArr[i] + " ");
        }
    }

    public static int[] countBits(int num) {
        int[] resultArr = new int[num + 1];

        if(num == 0){
            resultArr[0] = 0;
            return resultArr;
        }else if(num == 1){
            resultArr[0] = 0;
            resultArr[1] = 1;
            return resultArr;
        }

        // 对数组进行初始化
        resultArr[0] = 0;
        resultArr[1] = 1;

        // 2^n 这个数的1的个数一定是1个
        for(int i = 1;Math.pow(2,i) <= num;i++){
            resultArr[(int)Math.pow(2,i)] = 1;
        }

        for(int i = 2;i <= num;i++){
            int base = getBase(i);

            int other = i - (int)Math.pow(2,base);
//            System.out.println("i:" + i +" num:" + (int)Math.pow(2,base));
            resultArr[i] = resultArr[(int)Math.pow(2,base)] + resultArr[other];
        }

        return resultArr;
    }

    public static int getBase(int x){
        if(x == 1 || x == 0){
            return x;
        }
        return (int)(Math.log(x) / Math.log(2));
    }

}
