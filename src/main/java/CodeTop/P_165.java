package CodeTop;

public class P_165 {


    public static void main(String[] args) {

//        String version1 = "1.01";
//        String version2 = "1.001";

//        String version1 = "1.0";
//        String version2 = "1.0.0";

//        String version1 = "0.1";
//        String version2 = "1.1";

//        String version1 = "1.0.1";
//        String version2 = "1";

//        String version1 = "7.5.2.4";
//        String version2 = "7.5.3";

        String version1 = "1.1";
        String version2 = "1.10";

        int res = compareVersion(version1, version2);
        System.out.println(res);
    }

    // 需要忽略前导0
    public static int compareVersion(String version1, String version2) {
        if(version1 == null && version2 == null){
            return 0;
        }

        if(version1 == null || version2 == null){
            return version1 == null ? -1 : 1;
        }

        // 使用"."进行切分
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        boolean isChanged = false;

        // 将最短的换到version2上
        if(arr1.length < arr2.length){

            String[] tempArr = arr1;
            arr1 = arr2;
            arr2 = tempArr;

            isChanged = true;
        }

        // 比较
        int idx = 0;

        while(idx < arr2.length){
            int res = isEqual(arr1[idx],arr2[idx]);
            if(res != 0){
                return isChanged ? -res : res;
            }

            idx++;
        }

        // 如果一直相等，再去判断version1后面的是否有不是前导0的情况
        while(idx < arr1.length){
            if(transfor(arr1[idx]) != 0){
                return isChanged ? -1 : 1;
            }
            idx++;
        }

        return 0;
    }

    // str1 > str2 --> 1
    // str1 < str2 --> -1
    // str1 == str2 --> 0
    // 先字符转int
    public static int isEqual(String str1,String str2){
        int num1 = transfor(str1);
        int num2 = transfor(str2);

//        System.out.println("num1: " + num1 + " --> " + "num2: " + num2);

        if(num1 == num2){
            return 0;
        }

        return num1 > num2 ? 1 : -1;
    }

    // 这里忽略了负数情况
    public static int transfor(String str1){
        if(str1 == null || str1.length() == 0){
            return 0;
        }

        int res = 0;
        for(int i = 0;i < str1.length();i++){
            res *= 10;
            res += (str1.charAt(i) - '0');
        }

        return res;
    }

}
