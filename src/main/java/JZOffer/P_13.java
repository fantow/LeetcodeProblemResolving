package JZOffer;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_13 {

    public static boolean[][] visited;

    public static void main(String[] args) {
        int m = 3;
        int n = 1;
        int k = 0;

        int result = movingCount(m, n, k);
        System.out.println(result);
    }

    public static int movingCount(int m, int n, int k) {

        visited = new boolean[m][n];

        int result = dfs(m, n, k, 0, 0);
        return result;
    }

    public static int dfs(int m,int n,int k,int row,int col){
        if(row >= m || row < 0 || col >= n || col < 0 || !countFunc(row,col,k) || visited[row][col]){
            return 0;
        }
        visited[row][col] = true;

        int result = 1 + dfs(m,n,k,row - 1,col) + dfs(m,n,k,row + 1,col) + dfs(m,n,k,row,col - 1)
                       + dfs(m,n,k,row,col + 1);

        return result;
    }

    public static boolean countFunc(int m,int n,int k){
        int addResult = 0;
        while(m > 0){
            addResult += m % 10;
            m /= 10;
        }

        while(n > 0){
            addResult += n % 10;
            n /= 10;
        }

        if(addResult > k){
            return false;
        }else{
            return true;
        }
    }

}
