package ACwing_寒假每日一题;

import java.util.Arrays;
import java.util.Scanner;

public class P_1_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] nums = new int[n];

        for(int i = 0;i < n;i++){
            nums[i] = scanner.nextInt();
        }

        if(n == 1){
            System.out.println(0);
        }

        Arrays.sort(nums);

        int location = nums[(n - 1) / 2];

        int count = 0;
        for(int i = 0;i < n;i++){
            count += Math.abs(nums[i] - location);
        }
        System.out.println(count);
    }
}
