package LCEveryDay;

public class P_389 {
    public static void main(String[] args) {
//        String s = "abcd";
//        String t = "abcde";

//        String s = "";
//        String t = "y";

//        String s = "a";
//        String t = "aa";


        String s = "ae";
        String t = "aea";

        char ch = findTheDifference(s, t);
        System.out.println(ch);
    }

    public static char findTheDifference(String s, String t) {
        if(t.length() == 0 || s.length() >= t.length()){
            return ' ';
        }

        int[] chCount = new int[26];

        for(char ch : t.toCharArray()){
            chCount[ch - 'a'] ++;
        }

        for(char ch : s.toCharArray()){
            chCount[ch - 'a']--;
        }

        for(int i = 0;i < 26;i++){
            if(chCount[i] != 0){
                return (char)('a' + i);
            }
        }

        return ' ';
    }
}
