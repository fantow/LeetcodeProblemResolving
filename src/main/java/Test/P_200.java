package Test;

import java.util.LinkedList;
import java.util.Queue;

public class P_200 {
    public static void main(String[] args) {
//        char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        };


        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        int result = numIslands(grid);
        System.out.println(result);
    }

    // BFS问题
    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = 0;
        if(rows != 0){
            cols = grid[0].length;
        }

        boolean[][] isVisited = new boolean[rows][cols];
        Queue<Pair> queue = new LinkedList<>();

        int result = 0;

        // 遍历找到岛屿
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(!isVisited[row][col] && grid[row][col] == '1'){
                    // 发现岛屿
                    result++;

                    isVisited[row][col] = true;

                    // 需要扩展本块岛屿
                    queue.offer(new Pair(row,col));
                    while(!queue.isEmpty()){
                        Pair pair = queue.poll();

                        int x = pair.x;
                        int y = pair.y;

                        isVisited[x][y] = true;

                        // 斜着连接的不算
                        // 向上
                        if(x - 1 >= 0 && grid[x - 1][y] == '1' && !isVisited[x - 1][y]){
                            queue.offer(new Pair(x - 1,y));
                        }

                        // 向下
                        if(x + 1 < rows && grid[x + 1][y] == '1' && !isVisited[x + 1][y]){
                            queue.offer(new Pair(x + 1,y));
                        }

                        // 向左
                        if(y - 1 >= 0 && grid[x][y - 1] == '1' && !isVisited[x][y - 1]){
                            queue.offer(new Pair(x,y - 1));
                        }

                        // 向右
                        if(y + 1 < cols && grid[x][y + 1] == '1' && !isVisited[x][y + 1]){
                            queue.offer(new Pair(x,y + 1));
                        }
                    }
                }
            }
        }

        return result;
    }

    static class Pair{
        public int x;
        public int y;
        public int val;

        public Pair() {
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
