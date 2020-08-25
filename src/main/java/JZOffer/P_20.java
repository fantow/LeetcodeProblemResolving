package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_20 {
    public static void main(String[] args) {
//        ---- test1 ----
        String s = "+100";

//        ---- test2 ----
//        String s = "5e2";

//        ---- test3 ----
//        String s = "3.1416";

//        ---- test4 ----
//        String s = "-1E-16";


//        ---- test5 ----
//        String s = "12e";

        boolean flag = isNumber(s);

        System.out.println(flag);
    }


    // 基本思路就是如果s中存在e，e前面可以是正常的数字，甚至小数；但是e之后的必须是正或负的整数
    // 一开始的思路是通过e将s划分为两部分，但是这样存在问题，比如-100,2e这样的用例，判断起来比较麻烦因为被split分割的数字只有一个
    // 还不如加一个状态位，从头到尾遍历
    public static boolean isNumber(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        //标记是否遇到相应情况
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] str = s.trim().toCharArray();
        for(int i = 0;i < str.length; i++){
            if(str[i] >= '0' && str[i] <= '9'){
                numSeen = true;
            }else if(str[i] == '.'){
                //.之前不能出现.或者e
                if(dotSeen || eSeen){
                    return false;
                }
                dotSeen = true;
            }else if(str[i] == 'e' || str[i] == 'E'){
                //e之前不能出现e，必须出现数
                if(eSeen || !numSeen){
                    return false;
                }
                eSeen = true;
                numSeen = false;//重置numSeen，排除123e或者123e+的情况,确保e之后也出现数
            }else if(str[i] == '-' || str[i] == '+'){
                //+-出现在0位置或者e/E的后面第一个位置才是合法的
                if(i != 0 && str[i-1] != 'e' && str[i-1] != 'E'){
                    return false;
                }
            }else{//其他不合法字符
                return false;
            }
        }
        return numSeen;
    }
}
