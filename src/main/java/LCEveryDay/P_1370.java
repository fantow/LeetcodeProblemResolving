package LCEveryDay;

public class P_1370 {
    public static void main(String[] args) {
        String s = "aaaabbbbcccc";
        String str = sortString(s);

        System.out.println(str);
    }

    public static String sortString(String s) {
        int length = s.length();
        if(length == 0 || length == 1){
            return s;
        }

        // 使用桶排序
        StringBuilder sb = new StringBuilder();

        // 桶
        int[] bucket = new int[26];

        int bucketCount = 0;

        for(int i = 0;i < length;i++){
            bucket[s.charAt(i) - 'a']++;
            bucketCount++;
        }


        for(int i = 0;i < length || bucketCount > 0;i++){
            for(int j = 0;j < 26;j++){
                if(bucket[j] != 0){
                    sb.append((char) (j + 'a'));
                    bucket[j]--;
                    bucketCount--;
                }
            }

            for(int j = 25;j >=0 ;j--){
                if(bucket[j] != 0){
                    sb.append((char)(j + 'a'));
                    bucket[j]--;
                    bucketCount--;
                }
            }
        }

        return sb.toString();
    }
}
