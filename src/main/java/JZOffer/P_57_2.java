package JZOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_57_2 {
    public static void main(String[] args) {
        int target = 9;

        int[][] result = findContinuousSequence1(target);
        for(int i = 0;i < result.length;i++){
            for(int j = 0;j < result[i].length;j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 方法1.递归
    public static int[][] findContinuousSequence(int target) {
        if(target <= 1){
            return new int[][]{};
        }

        List<List<Integer>> resultList = new ArrayList<>();

        for(int i = 1;i <= target / 2;i++){
            int count = i;
            List<Integer> list = new ArrayList<>();
            list.add(i);
            for(int j = i + 1;j <= (target / 2) + 1;j++){
                count += j;
                list.add(j);
                if(count == target){
                    System.out.println(list);
                    resultList.add(new ArrayList<>(list));
                }else if(count > target){
                    break;
                }
            }
        }

        int[][] resultArr = new int[resultList.size()][];

        for(int i = 0;i < resultList.size();i++){
            List<Integer> list = resultList.get(i);
            int[] arr = new int[list.size()];
            for(int j = 0;j < list.size();j++){
                arr[j] = list.get(j);
            }
            resultArr[i] = arr;
        }

        return resultArr;
    }


    // 滑动窗口方法
    public static int[][] findContinuousSequence1(int target){
        List<int[]> resultList = new ArrayList<>();
        int left = 1;
        int right = left + 1;

        while(left <= target / 2){
            int sum = getSum(left,right);
            if(sum == target){
                int[] arr = new int[right - left + 1];
                int idx = 0;
                while(idx < right - left + 1){
                    arr[idx] = left + idx;
                    idx++;
                }
                resultList.add(arr);
                left++;
            }else if(sum > target){
                left++;
            }else{
                right++;
            }
        }

        int[][] resultArr = new int[resultList.size()][];

        for(int i = 0;i < resultList.size();i++){
            resultArr[i] = resultList.get(i);
        }

        return resultArr;
    }

    public static int getSum(int left,int right){
        return (right + left) * (right - left + 1) / 2;
    }
}
