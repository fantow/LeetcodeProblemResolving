package LCEveryDay;

public class P_1208 {
    public static void main(String[] args) {
//        String s = "abcd";
//        String t = "bcdf";
//        int maxCost = 3;


//        String s = "abcd";
//        String t = "cdef";
//        int maxCost = 3;


//        String s = "abcd";
//        String t = "acde";
//        int maxCost = 0;

        String s = "krrgw";
        String t = "zjxss";
        int maxCost = 19;

        int result = equalSubstring(s, t, maxCost);
        System.out.println(result);
    }

    // 题目说明了s和t的长度一致
    public static int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
//        if(length < maxCost){
//            return length;
//        }

        int[] arr = new int[length];

        for(int i = 0;i < length;i++){
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

//        for(int num : arr){
//            System.out.print(num + " ");
//        }
//        System.out.println();

        int maxWindows = 0;

        // 将问题转化为，从获取到的差值数组中，移动大小可变的滑动窗口，使得窗口内数字总和<= cost，
        // 记录下窗口大小的最大值返回
        int left = 0;
        int right = 0;

        int currentSum = 0;

        for(;right < length;right++){
            currentSum += arr[right];

            if(currentSum <= maxCost){
                maxWindows = Math.max(maxWindows,(right - left + 1));
            }else{
                currentSum -= arr[left];
                left++;
            }
        }

        return maxWindows;
    }
}
