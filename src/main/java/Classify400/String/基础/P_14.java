package Classify400.String.基础;

/**
 * @Description:
 * @Author chenyang270@jd.com
 * @CreateDate
 * @Version: 1.0
 */
public class P_14 {
    public static void main(String[] args) {
//        ---- test1 ----
//        String[] strs = {"flower","flow","flight"};

//        ---- test2 ----
        String[] strs = {"dog","racecar","car"};

        String result = longestCommonPrefix(strs);

        System.out.println(result);
    }

    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if(length == 0){
            return "";
        }

        String firstStr = strs[0];
        StringBuilder sb  = new StringBuilder();

        int idx = 0;
        for(;idx < firstStr.length();idx++){
            for(int i = 1;i <length;i++){
                String tempStr = strs[i];
                if(tempStr.length() - 1 < idx){
                    return sb.toString();
                }else{
                    if(tempStr.charAt(idx) == firstStr.charAt(idx)){
                        continue;
                    }else{
                        return sb.toString();
                    }
                }
            }
            sb.append(firstStr.charAt(idx));
        }

        return sb.toString();
    }
}
