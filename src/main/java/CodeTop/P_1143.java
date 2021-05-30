package CodeTop;

public class P_1143 {
    public static void main(String[] args) {
//        String test1 = "abcde";
//        String test2 = "ace";

//        String test1 = "abc";
//        String test2 = "abc";

//        String test1 = "abc";
//        String test2 = "def";

        String test1 = "hofubmnylkra";
        String test2 = "pqhgxgdofcvmr";

        int res = longestCommonSubsequence(test1, test2);

        System.out.println(res);
    }

    // 最长公共子序列
    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        // 选小的那个做text2
        if(len1 < len2){
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        int rows = text1.length();
        int cols = text2.length();

        int[][] dpArr = new int[rows + 1][cols + 1];

        int max = 0;

        // 对dpArr进行初始化
        // if != ,dpArr[row][col] = dpArr[row - 1][col]
        // if == ,dpArr[row][col] = dpArr[row - 1][col - 1] + 1;
        for(int row = 1;row <= rows;row++){
            for(int col = 1;col <= cols;col++){
                if(text1.charAt(row - 1) == text2.charAt(col - 1)){
                    dpArr[row][col] = dpArr[row - 1][col - 1] + 1;
                }else{
                    dpArr[row][col] = Math.max(dpArr[row][col - 1],dpArr[row - 1][col]);
                }

                max = Math.max(max,dpArr[row][col]);
            }
        }


//        for(int row = 0;row <= rows;row++){
//            for(int col = 0;col <= cols;col++){
//                System.out.print(dpArr[row][col] + " ");
//            }
//            System.out.println();
//        }

        return max;
    }
}
