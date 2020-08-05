package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_11 {
    public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
        int[] array2 = {2,2,2,0,1};
        int result = minArray(array2);

        System.out.println(result);
    }

    // 注意一定要用mid 与 right 比，如果用mid与left比，做不出来。
    public static int minArray(int[] numbers) {
        int length = numbers.length;
        if(length == 0){
            return -1;
        }
        if(length == 1){
            return numbers[0];
        }

        int left = 0;
        int right = length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(numbers[mid] > numbers[right]){
                left = mid + 1;

            }else if(numbers[mid] < numbers[right]){
                right = mid;
            }else{
                right = right - 1;
            }
        }

        return numbers[left];
    }
}
