package LCEveryDay;

public class P_738 {
    public static void main(String[] args) {
//        int N = 100;
//        int N = 1234;
//        int N = 332;
//        int N = 432;
        int N = 120;

        int result = monotoneIncreasingDigits(N);
        System.out.println(result);
    }

    public static int monotoneIncreasingDigits(int N) {
        // 先要计算这个N的位数
        int temp = N;
        int length = 0;
        while(temp != 0){
            temp /= 10;
            length++;
        }

        // 如果是0位或者1位，直接返回N
        if(length == 1 || length == 0){
            return N;
        }

        temp = N;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < length;i++){
            int num = temp % 10;
            temp = temp / 10;
            sb.append(num);
        }

        char[] chars = sb.reverse().toString().toCharArray();

        for(int i = 1;i < length;i++){
            if(chars[i - 1] <= chars[i]){
                continue;
            }else{
                // 需要去判断nums[i-1]-1和nums[i-2]的关系
                func(chars,i-1);
            }
        }

        return Integer.parseInt(new String(chars));
    }

    // 用来向前遍历的
    public static void func(char[] chars,int idx){
        if(idx < 1){
            chars[0] = (char)(chars[0] - 1);
            for(int i = 1;i < chars.length;i++){
                chars[i] = '9';
            }
            return;
        }

        // 将nums[idx] 和nums[idx - 1]比较
        if(chars[idx] != '0' && (char)(chars[idx] - 1) >= chars[idx - 1]){
            chars[idx] = (char)(chars[idx] - 1);
            for(int i = idx + 1;i < chars.length;i++){
                chars[i] = '9';
            }
        }else{
            func(chars,idx - 1);
        }
        return;
    }

}
