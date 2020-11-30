package Hot100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class P_406 {
    public static void main(String[] args) {
//        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] people = {{4,0},{5,0},{2,2},{3,2},{1,4},{6,0}};

        int[][] ints = reconstructQueue(people);
        for(int[] arr : ints){
            System.out.print(arr[0] + " " + arr[1]);
            System.out.println();
        }

    }

    public static int[][] reconstructQueue(int[][] people) {
        int length = people.length;

        if(length == 0){
            return people;
        }

        List<int[]> resultList = new LinkedList<>();

        // 先将people转换为逆序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o2[0] - o1[0];
                }
            }
        });

        for(int i = 0;i < length;i++){
            resultList.add(i,people[i]);
        }

        // 使用插入排序
        for(int i = 0;i < length;i++){
            int[] person = people[i];
            int count = 0;
            for(int j = 0;j < i;j++){
                if(person[1] == 0){
                    resultList.remove(i);
                    resultList.add(0,person);
                    break;
                }
                if(people[j][0] >= person[0]){
                    count++;
                }

                if(count == person[1]){
                    resultList.remove(i);
                    resultList.add(j + 1,person);
                }
            }
        }

        int[][] resultArr = new int[resultList.size()][2];

        for(int i = 0;i < resultList.size();i++){
            resultArr[i] = resultList.get(i);
        }

        return resultArr;
    }
}
