package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_66 {
    public static void main(String[] args) {

        int[] a = {1,2,3,4,5};
        int[] arr = constructArr(a);

        for(int num : arr){
            System.out.print(num + " ");
        }
    }

    public static int[] constructArr(int[] a) {
        int length = a.length;
        if(length == 0){
            return new int[]{};
        }
        int[] preArr = new int[length];
        int[] postArr = new int[length];

        preArr[0] = a[0];
        postArr[length - 1] = a[length - 1];

        for(int i = 1;i < length;i++){
            preArr[i] = preArr[i - 1] * a[i];
            postArr[length - 1 -i] = postArr[length - i] * a[length - i - 1];
        }

        int[] result = new int[length];
        for(int i = 0;i < length;i++){
            if(i == 0){
                result[i] = 1 * postArr[i + 1];
            }else if(i == length - 1){
                result[i] = preArr[i - 1] * 1;
            }else{
                result[i] = preArr[i - 1] * postArr[i + 1];
            }
        }

        return result;
    }
}
