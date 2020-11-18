package LCEveryDay;

import java.util.*;

public class P_1030 {
    public static void main(String[] args) {

//        int[][] order = allCellsDistOrder(1, 2, 0, 0);
//        int[][] order = allCellsDistOrder(2, 2, 0, 0);
//        int[][] order = allCellsDistOrder(2, 3, 1, 2);

//        for(int[] arr : order){
//            System.out.println(arr);
//        }


//        int[][] order = bfs(1,2,0,0);
//        int[][] order = bfs(2, 2, 0, 1);
        int[][] order = bfs(2, 3, 1, 2);

        for(int i = 0;i < order.length;i++){
            for(int j = 0;j < order[0].length;j++){
                System.out.print(order[i][j] + " ");
            }
            System.out.println();
        }


//        for(Pair pair : resultList){
//            System.out.println(pair);
//        }
    }


    public static int[][] bfs(int R,int C,int r0,int c0){
        int[][] resultArr = new int[R * C][1];

        // 使用BFS
        Pair[] queue = new Pair[R * C];

        int head = 0;
        int tail = 0;

        boolean[][] isVisited = new boolean[R][C];
        isVisited[r0][c0] = true;
        int distinct = 0;
        queue[tail++] = new Pair(r0,c0,0);
        int last = tail;

        while(head < tail){
            Pair pair = queue[head];
            int[] arr = new int[2];
            arr[0] = pair.x;
            arr[1] = pair.y;
            resultArr[head] = arr;
            head ++;

            // 尝试将上下左右的元素存入队列中
            // 上
            if(0 <= pair.x - 1 && pair.x - 1 < R && 0 <= pair.y && pair.y < C && isVisited[pair.x - 1][pair.y] == false){
                queue[tail++] = new Pair(pair.x - 1,pair.y,0);
                isVisited[pair.x - 1][pair.y] = true;
            }
            // 下
            if(0 <= pair.x + 1 && pair.x + 1 < R && 0 <= pair.y && pair.y < C && isVisited[pair.x + 1][pair.y] == false){
                queue[tail++] = new Pair(pair.x + 1,pair.y,0);
                isVisited[pair.x + 1][pair.y] = true;
            }
            // 左
            if(0 <= pair.x && pair.x < R && 0 <= pair.y - 1 && pair.y - 1 < C && isVisited[pair.x][pair.y - 1] == false){
                queue[tail++] = new Pair(pair.x,pair.y - 1,0);
                isVisited[pair.x][pair.y - 1] = true;
            }
            // 右
            if(0 <= pair.x && pair.x < R && 0 <= pair.y + 1 && pair.y + 1 < C && isVisited[pair.x][pair.y + 1] == false){
                queue[tail++] = new Pair(pair.x,pair.y + 1,0);
                isVisited[pair.x][pair.y + 1] = true;
            }

            if(head == last){
                last = tail;
                distinct++;
            }
        }


        return resultArr;
    }


    public static List<Pair> resultList = new ArrayList<>();

    // 可以直接算就行
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        for(int i = 0;i < R;i++){
            for(int j = 0;j < C;j++){
                int dis = getDistinct(i,j,r0,c0);
                resultList.add(new Pair(i,j,dis));
            }
        }

        Collections.sort(resultList);

        int[][] resultArr = new int[resultList.size()][1];

        int index = 0;
        for(Pair pair : resultList){
            int[] re = new int[2];
            re[0] = pair.x;
            re[1] = pair.y;
            resultArr[index] = re;
            index++;
        }

        return resultArr;
    }

    public static int getDistinct(int x,int y,int r0,int c0){
        return Math.abs(x - r0) + Math.abs(y - c0);
    }

//    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
////        List<Pair> resultList = new ArrayList<>();
////        resultList.add(new Pair(r0,c0,0));
//        int[][] isVisited = new int[R][C];
//
//        for(int i = 0;i < R;i++){
//            for(int j = 0;j < C;j++){
//                isVisited[i][j] = -1;
//            }
//        }
//
////        isVisited[r0][c0] = 0;
//
//        int row = r0;
//        int col = c0;
//
//        getDistinct(isVisited,row,col,R,C,-1);
//
//        return null;
//    }


    // 递归做有问题，无法保证最小
    public static void getDistinct(int[][] isVisited,int row,int col,int R,int C,int lastDistinct){
//        System.out.println(row+ " -> " + col + " -> " + R + " -> " + C );
        if(0 <= row && row < R && 0 <= col && col < C && isVisited[row][col] == -1){
            isVisited[row][col] = lastDistinct + 1;
            resultList.add(new Pair(row,col,lastDistinct + 1));
        }else{
            return;
        }

        // 左移
        getDistinct(isVisited,row,col - 1,R,C,isVisited[row][col]);
        // 右移
        getDistinct(isVisited,row,col + 1,R,C,isVisited[row][col]);
        // 上移
        getDistinct(isVisited,row - 1,col,R,C,isVisited[row][col]);
        // 下移
        getDistinct(isVisited,row + 1,col,R,C,isVisited[row][col]);

        return;
    }


    static class Pair implements Comparable<Pair>{
        int x;
        int y;
        int distinct;

        public Pair(int x, int y,int distinct) {
            this.x = x;
            this.y = y;
            this.distinct = distinct;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    ", distinct=" + distinct +
                    '}';
        }

        @Override
        public int compareTo(Pair o) {
            return this.distinct - o.distinct;
        }
    }
}
