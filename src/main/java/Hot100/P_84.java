package Hot100;

public class P_84 {
    public static void main(String[] args) {
//        int[] heights = {2,1,5,6,2,3};
        int[] heights = {0,9};
        int result = largestRectangleArea(heights);

        System.out.println(result);
    }

    public static int largestRectangleArea(int[] heights) {
        int length = heights.length;
        if(length == 0){
            return 0;
        }

        int maxArea = 0;

        maxArea = 1 * heights[0];

        for(int i = 1;i < length;i++){
            if(heights[i] != 0){
                int curMinHeight = heights[i];
                maxArea = Math.max(heights[i] * 1,maxArea);
                for(int j = i - 1;j >= 0;j--){
                    if(heights[j] != 0){
                        curMinHeight = Math.min(curMinHeight,heights[j]);
                        maxArea = Math.max(maxArea,curMinHeight * (i - j + 1));
                    }else{
                        break;
                    }
                }
            }
        }

        return maxArea;
    }
}
