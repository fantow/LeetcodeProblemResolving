package LCEveryDay;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_767 {
    public static void main(String[] args) {
//        String S = "aab";
//        String S = "aaab";
//        String S = "aaabbcdde";
//        String S = "vvvlo";
        String S = "baaba";
        String result = reorganizeString(S);

        System.out.println(result);
    }

    // 可不可以使用桶排序？？？
    public static String reorganizeString(String S) {
        int length = S.length();
        if(length == 0){
            return "";
        }

        char[] chars = S.toCharArray();
        int[] countArr = new int[26];

        // 维护一个大根堆
        PriorityQueue<Character> heap = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return countArr[o2 - 'a'] - countArr[o1 - 'a'];
            }
        });

        for(int i = 0;i < length;i++){
            countArr[chars[i] - 'a']++;
        }


        int maxCount = Integer.MIN_VALUE;
        for(int i = 0;i < 26;i++){
            if(countArr[i] != 0){
                maxCount = Math.max(maxCount,countArr[i]);
                heap.offer((char)(i + 'a'));
            }
        }

        if(maxCount > (length + 1) / 2){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Character char1 = 'a';
        Character char2 = 'a';

        while(heap.size() > 1) {
            // 每次从heap中拿出两个元素
            char1 = heap.poll();
            char2 = heap.poll();

            sb.append(char1);
            sb.append(char2);

            countArr[char1 - 'a']--;
            countArr[char2 - 'a']--;

            if (countArr[char1 - 'a'] > 0) {
                heap.offer(char1);
            }

            if (countArr[char2 - 'a'] > 0) {
                heap.offer(char2);
            }
        }

        if(!heap.isEmpty()){
            sb.append(heap.poll());
        }

        return sb.toString();
    }


    // 使用左右指针交换，先对S排序
//    public static String reorganizeString(String S) {
//        if(S == null){
//            return "";
//        }
//
//        char[] chars = S.toCharArray();
//        int length = chars.length;
//
//        Arrays.sort(chars);
//
//        int left = 1;
//        int right = length - 1;
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(chars[left]);
//        while(left <= right){
//            if(chars[left - 1] != chars[left]){
//                sb.append(chars[left]);
//                left++;
//            }else{
//                if(chars[left] != chars[right]){
//                    char ch = chars[left];
//                    chars[left] = chars[right];
//                    chars[right] = ch;
//                    sb.append(chars[left]);
//                    left++;
//                }else{
//                    right--;
//                }
//            }
//        }
//
////        System.out.println(sb.toString());
//        return sb.length() == S.length() ? sb.toString() : "";
//    }
}
