package Hot100;

import java.util.ArrayList;
import java.util.List;

public class P_448 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = findDisappearedNumbers(nums);

        System.out.println(list);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;

        List<Integer> list = new ArrayList<>();

        if(length == 0){
            return list;
        }

        int flag = 0;

        for(int i = 0;i < length;i++){
            if(nums[i] == i + 1){
                continue;
            }else{
                while(nums[i] != i + 1){

                    int temp = nums[i];
                    if(temp == nums[temp - 1]){
                        break;
                    }

                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                }
            }
        }

        for(int i = 0;i < length;i++){
            if(nums[i] != i + 1){
                list.add(i + 1);
            }
        }

        return list;
    }
}
