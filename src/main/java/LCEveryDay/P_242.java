package LCEveryDay;

public class P_242 {
    public static void main(String[] args) {
//        String s = "anagram";
//        String t = "nagaram";

        String s = "rat";
        String t = "car";

        boolean flag = isAnagram(s, t);
        System.out.println(flag);
    }

    public static boolean isAnagram(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        if(len1 != len2){
            return false;
        }

        int[] count = new int[26];

        for(int i = 0;i < len1;i++){
            count[s.charAt(i) - 97] ++;
        }

        for(int i = 0;i < len2;i++){
            if(count[t.charAt(i) - 97] > 0){
                count[t.charAt(i) - 97]--;
            }else{
                return false;
            }
        }

        for(int i = 0;i < 26;i++){
            if(count[i] != 0){
                return false;
            }
        }

        return true;
    }
}
