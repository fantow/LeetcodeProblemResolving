package LCEveryDay;

import java.util.*;

public class P_1178 {
    public static void main(String[] args) {
        String[] words = {"aaaa","asas","able","ability","actt","actor","access"};
        String[] pizzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};

        List<Integer> list = findNumOfValidWords(words, pizzles);

        for(Integer num : list){
            System.out.print(num + " ");
        }
    }

    // 先将words中的String用二进制表示，再创建Map
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        Map<Integer,Integer> map = new HashMap<>();
        for(String word : words){
            int mask = 0;

            for(char ch : word.toCharArray()){
                mask |= (1 << (ch - 'a'));
            }

            map.put(mask,map.getOrDefault(mask,0) + 1);
        }

        List<Integer> resultList = new ArrayList<>();
        // 再将每个puzzles的各个子集去Map中查找
        for(String puzzle : puzzles){
            int mask = 0;

            for(char ch : puzzle.toCharArray()){
                mask |= (1 << (ch - 'a'));
            }

            // 再去找出mask对应的子集
            Set<Integer> list = getBytesList(mask);
            int result = 0;
            for(Integer num : list){
                // 在这里检查puzzle的首字母问题
                if((num & 1 << (puzzle.charAt(0) - 'a')) == 0){
                    continue;
                }

                if(map.containsKey(num)){
                    result += map.get(num);
                }
            }

            resultList.add(result);
        }

        return resultList;
    }


    // 需要剔除掉不包含puzzle首字母的num
    public static Set<Integer> getBytesList(int mask){
        int sub = mask;

        Set<Integer> set = new HashSet<>();

        while(sub != 0){
            sub = (sub - 1) & mask;
            set.add(sub);
        }

        return set;
    }

}
