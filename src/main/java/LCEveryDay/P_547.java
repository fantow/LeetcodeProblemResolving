package LCEveryDay;

public class P_547 {
    public static void main(String[] args) {
//        int[][] isConnected = {
//                {1,1,0},
//                {1,1,0},
//                {0,0,1}
//        };

        int[][] isConnected = {
                {1,0,0},
                {0,1,0},
                {0,0,1}
        };

        int result = findCircleNum(isConnected);
        System.out.println(result);
    }

    // 应该是使用并查集
    public static int findCircleNum(int[][] isConnected) {
        int cityNum = isConnected.length;

        if(cityNum == 0){
            return 0;
        }

        // 并查集结果集
        int[] resultArr = new int[cityNum];

        // 对并查集数据初始化，一开始都是自己本身
        for(int i = 0;i < resultArr.length;i++){
            resultArr[i] = i;
        }

        // 因为是无向图，所以只看右对角矩阵就可以了
        for(int i = 0;i < isConnected.length;i++){
            for(int j = i + 1;j < isConnected[0].length;j++){
                if(isConnected[i][j] == 1){
                    union(resultArr,i,j);
                }
            }
        }

        int reusltCount = 0;

        for(int i = 0;i < resultArr.length;i++){
            if(resultArr[i] == i){
                reusltCount++;
            }
        }

        return reusltCount;
    }

    // find函数
    public static int find(int[] resultArr,int x){
        if(resultArr[x] != x){
            resultArr[x] = find(resultArr,resultArr[x]);
        }
        return resultArr[x];
    }

    // union函数,将a作为b的root
    public static void union(int[] resultArr,int a,int b){
        int aRoot = find(resultArr,a);
        int bRoot = find(resultArr,b);

        if(aRoot == bRoot){
            return ;
        }else{
            resultArr[bRoot] = aRoot;
        }

        return;
    }

}
