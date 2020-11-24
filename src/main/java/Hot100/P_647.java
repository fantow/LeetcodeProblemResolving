package Hot100;

public class P_647 {
    public static void main(String[] args) {
//        String s = "abc";
//        String s = "aaa";
        String s = "aaaaa";
        int count = countSubstrings(s);

        System.out.println(count);
    }

    // 这是一个二维dp
    public static int countSubstrings(String s) {
        int length = s.length();
        if(length == 0 || length == 1){
            return length;
        }

        int count = 0;

        boolean[][] dpArr = new boolean[length][length];

        // 初始化dpArr
        // 初始化主对角线
        for(int i = 0;i < length;i++){
            dpArr[i][i] = true;
            count++;
        }

        // 初始化主对角线上面一斜对角线
        for(int i = 0;i < length - 1;i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                dpArr[i][i + 1] = true;
                count++;
            }else{
                dpArr[i][i + 1] = false;
            }
        }

        // 初始化主对角线下面的斜对角线
//        for(int i = 1;i < length;i++){
//            dpArr[i][i - 1] = true;
//        }

        // 进行dp公式推导
        // dp[i][j] = s.charAt(i - 1) == s.charAt(j + 1) && dp[i + 1][j - 1];

        // dp的遍历是有顺序的
//        for(int i = 0;i < length;i++){
//            for(int j = i + 2;j < length;j++){
//                if(i + 1 < length && j - 1 >= 0){
//                    if(i == 0 && j == 4){
//                        System.out.println(s.charAt(i) == s.charAt(j));
//                        System.out.println(dpArr[i + 1][j - 1]);
//                    }
//                    dpArr[i][j] = (s.charAt(i) == s.charAt(j)) && dpArr[i + 1][j - 1];
//                    if(dpArr[i][j] == true){
//                        count++;
//                    }
//                }
//            }
//        }


        // 本题要先列后行
        for(int j = 2;j < length;j++){
            for(int i = 0;i < j - 1;i++){
               if(i + 1 < length && j - 1 >= 0){
                    dpArr[i][j] = (s.charAt(i) == s.charAt(j)) && dpArr[i + 1][j - 1];
                    if(dpArr[i][j] == true){
                        count++;
                    }
               }
            }
        }

        for(int i = 0;i < length;i++){
            for(int j = 0;j < length;j++){
                System.out.print(dpArr[i][j] + " ");
            }
            System.out.println();
        }

        return count;
    }
}
