package Classify400.String.基础;

/**
 * @Description:
 * @Author chenyang270@jd.com
 * @CreateDate
 * @Version: 1.0
 */
public class P_383 {
    public static void main(String[] args) {
//        ---- test1 ----
        String ransomNote = "a";
        String magazine = "b";

//        ---- test2 ----
//        String ransomNote = "aa";
//        String magazine = "ab";

//        ---- test3 ----
//        String ransomNote = "aa";
//        String magazine = "aab";

        boolean flag = canConstruct(ransomNote, magazine);
        System.out.println(flag);
    }

    // 使用一个数据用来记录magazinge中出现的字母次数
    public static boolean canConstruct(String ransomNote, String magazine) {
        int length1 = magazine.length();
        int length2 = ransomNote.length();
        if(length2 == 0){
            return true;
        }

        int[] tempArr = new int[26];
        for(int i = 0;i < length1;i++){
            tempArr[magazine.charAt(i) - 'a']++;
        }

        for(int i = 0;i < ransomNote.length();i++){
            if(tempArr[ransomNote.charAt(i) - 'a'] > 0){
                tempArr[ransomNote.charAt(i) - 'a']--;
            }else{
                return false;
            }
        }

        return true;
    }
}
