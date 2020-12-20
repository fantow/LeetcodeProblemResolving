package Hot100;

public class P_72 {
    public static void main(String[] args) {
//        String word1 = "horse";
//        String word2 = "ros";

        String word1 = "intention";
        String word2 = "execution";

        int result = minDistance(word1, word2);

        System.out.println(result);
    }

    public static int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        // dpArr[i][j] 表示word1的第i位及以前 构成 word2的第j列及以前的最小操作次数
        int[][] dpArr = new int[length1 + 1][length2 + 1];

        // 对dpArr进行初始化
        for(int i = 0;i <= length1;i++){
            dpArr[i][0] = i;
        }

        for(int j = 0;j <= length2;j++){
            dpArr[0][j] = j;
        }

        // 增：dpArr[i][j] = dpArr[i][j - 1] + 1;
        // 删：dpArr[i][j] = dpArr[i - 1][j] + 1;
        // 改：dpArr[i][j] = dpArr[i - 1][j - 1] + 1;
        for(int i = 1;i <= length1;i++){
            for(int j = 1;j <= length2;j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dpArr[i][j] = dpArr[i - 1][j - 1];
                }else{
                    int min = Math.min(dpArr[i][j - 1],dpArr[i - 1][j]);
                    min = Math.min(min ,dpArr[i - 1][j - 1]);
                    dpArr[i][j] = min + 1;
                }
            }
        }


        for(int i = 0;i <= length1;i++){
            for(int j = 0;j <= length2;j++){
                System.out.print(dpArr[i][j] + " ");
            }
            System.out.println();
        }


        return dpArr[length1][length2];
    }
}
