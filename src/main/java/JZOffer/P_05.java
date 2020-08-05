package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_05 {
    public static void main(String[] args) {
        String s = "We are happy.";
        String str = replaceSpace(s);
        System.out.println(str);
    }

    public static String replaceSpace(String s) {
        int length = s.length();
        if (length == 0){
            return s;
        }

        int spaceCount = 0;
        // 先遍历一次String，找到有多少个空格
        char[] charArray = s.toCharArray();
        for(char ch : charArray){
            if(ch == ' '){
                spaceCount++;
            }
        }

        char[] newCharArray = new char[length + 2 * spaceCount];

        int temp = length - 1;
        for(int i = newCharArray.length - 1;i >= 0 && temp >= 0;i--){
            if(charArray[temp] != ' '){
                newCharArray[i] = charArray[temp--];
            }else{
                newCharArray[i--] = '0';
                newCharArray[i--] = '2';
                newCharArray[i] = '%';
                temp--;
            }
        }

        return String.valueOf(newCharArray);
    }
}
