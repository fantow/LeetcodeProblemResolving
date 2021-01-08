package Hot100;

public class P_28 {
    public static void main(String[] args) {
//        String haystack = "hello";
//        String needle = "ll";

//        String haystack = "aaaaa";
//        String needle = "bba";

        String haystack = "";
        String needle = "aa";

        int result = strStr(haystack, needle);
        System.out.println(result);
    }

    public static int strStr(String haystack, String needle) {
        int lenHayStack = haystack.length();
        int lenNeedle = needle.length();

        if(needle == null || lenNeedle == 0){
            return 0;
        }

        if(lenHayStack < lenNeedle){
            return -1;
        }

//        int index = haystack.indexOf(needle);

        int from = 0;
        int to = 0;

        int lastFrom = from;

        while(from < lenHayStack){
            if(haystack.charAt(from) != needle.charAt(to)){
                from = lastFrom + 1;
                lastFrom = from;
                to = 0;
                continue;
            }else{
                if(to == lenNeedle - 1){
                    return lastFrom;
                }else if(to >= lenNeedle){
                    return -1;
                }else{
                    from++;
                    to++;
                }
            }
        }

        return -1;
    }
}
