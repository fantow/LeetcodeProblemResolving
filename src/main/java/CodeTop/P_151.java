package CodeTop;

public class P_151 {
    public static void main(String[] args) {
//        String s = "the sky is blue";
        String s = "a good   example";

        String str = reverseWords(s);
        System.out.println(str);
    }

    public static String reverseWords(String s) {
        int length = s.length();

        if(length == 0){
            return s;
        }

        s = s.trim();
        String[] strings = s.split(" ");

        int len = strings.length;

        if(len == 1){
            return s;
        }

        // 翻转数组
        for(int i = 0;i < len / 2;i++){
            String temp = strings[i];
            strings[i] = strings[len - 1 - i];
            strings[len - 1 - i] = temp;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0;i < len;i++){
            if(strings[i] == " " || strings[i].length() == 0){
                continue;
            }
            stringBuilder.append(strings[i].trim());
            if(i != len - 1){
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }
}
