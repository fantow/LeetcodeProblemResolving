package LCEveryDay;

public class P_395 {
    public static void main(String[] args) {
//        String s = "aaabb";
//        int k = 3;


        String s = "ababbc";
        int k = 2;

        int result = longestSubstring(s, k);
        System.out.println(result);
    }

    // 要求找出最长的子串，其中子串中每个字符的出现次数都不少于K
    // 一般使用滑动窗口的问题和这个不太类似，因为无法做到只要窗口不满足条件，就可以移动一端
    // 的指针
    public static int longestSubstring(String s, int k) {
        int length = s.length();

        int maxTries = length / k;

        int result = 0;

        for(int t = 1;t <= maxTries;t++){
            int left = 0;
            int right = 0;

            int total = 0;

            int less = 0;

            int[] count = new int[26];

            while(right < length){
                // 先将所有元素装进来
                count[s.charAt(right) - 'a']++;

                // 新来的
                if(count[s.charAt(right) - 'a'] == 1){
                    total++;
                    less++;
                }

                if(count[s.charAt(right) - 'a'] == k){
                    less--;
                }


                // total > t 一定不能保证每个元素不少于k
                while(total > t){
                    count[s.charAt(left) - 'a']--;
                    if(count[s.charAt(left) - 'a'] == k - 1){
                        less++;
                    }

                    if(count[s.charAt(left) - 'a'] == 0){
                        total--;
                        less--;
                    }

                    left++;
                }

                if(less == 0){
                    result = Math.max(result,right - left + 1);
                }

                right++;
            }
        }

        return result;
    }
}
