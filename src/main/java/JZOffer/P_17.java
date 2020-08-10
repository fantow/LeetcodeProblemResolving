package JZOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_17 {

    public static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) {
        int[] result = printNumbers(1);

        for (int re : result){
            System.out.println(re);
        }
    }

    public static int[] printNumbers(int n) {
        for(int i = 0;i < 10;i++){
            char[] tempCharArray = new char[n];
            tempCharArray[0] = (char)('0' + i);
            getNumbers(tempCharArray,n,1);
        }

        int[] resultArray = new int[resultList.size()];

        for(int i = 0;i < resultList.size();i++){
            resultArray[i] = resultList.get(i);
        }
        return resultArray;
    }

    public static void getNumbers(char[] num,int length,int index){

        int result = 0;

        if(index == length){
            int startIdx = 0;
            for(int i = 0;i < length;i++){
                if(num[i] != '0'){
                    startIdx = i;
                    break;
                }else{
                    continue;
                }
            }

            // 是倒着算的 '009' --> 900  '900' --> 009 --> 9
            for(int i = startIdx;i < length;i++){
                result = result * 10 + (num[i] - '0');
            }

            if(result != 0){
                resultList.add(result);
            }
            return ;
        }

        for(int i = 0;i < 10;i++){
            num[index] = (char)('0' + i);
            getNumbers(num,length,index + 1);
        }

        return ;
    }

}
