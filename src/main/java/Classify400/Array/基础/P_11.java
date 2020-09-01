package Classify400.Array.基础;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = maxArea(height);

        System.out.println(result);
    }

    // 需要替换每次两端中最短的板子
    public static int maxArea(int[] height) {
        int length = height.length;
        if(length == 0){
            return 0;
        }

        int left = 0;
        int right = length - 1;
        int max = 0;

        while(left < right){
            int temp = (right - left) * Math.min(height[left],height[right]);
            if(temp > max){
                max = temp;
            }else{
                if(height[left] > height[right]){
                    right--;
                }else if(height[left] < height[right]){
                    left++;
                }else{
                    left++;
                    right--;
                }
            }
        }

        return max;
    }
}
