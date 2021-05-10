package Test;

import java.util.LinkedList;
import java.util.Queue;

public class P_733 {
    public static void main(String[] args) {
        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        int sr = 1;
        int sc = 1;
        int newColor = 2;

        int[][] result = floodFill(image, sr, sc, newColor);

        for(int row = 0;row < result.length;row++){
            for(int col = 0;col < result[0].length;col++){
                System.out.print(result[row][col] + " ");
            }
            System.out.println();
        }
    }

    // 辐射问题，用BFS
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = 0;
        if(rows != 0){
            cols = image[0].length;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(sr,sc,image[sr][sc]));

        boolean[][] isVisited = new boolean[rows][cols];

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
//            System.out.println(pair);
            int val = pair.val;
            // 先修改数组，再找上下左右和它相同的节点
            image[pair.x][pair.y] = newColor;

            isVisited[pair.x][pair.y] = true;

            // 向上
            if(pair.x - 1 >= 0 && image[pair.x - 1][pair.y] == val && !isVisited[pair.x - 1][pair.y]){
                queue.offer(new Pair(pair.x - 1,pair.y,image[pair.x - 1][pair.y]));
                isVisited[pair.x - 1][pair.y] = true;
            }

            // 向下
            if(pair.x + 1 < rows && image[pair.x + 1][pair.y] == val && !isVisited[pair.x + 1][pair.y]){
                queue.offer(new Pair(pair.x + 1,pair.y,image[pair.x + 1][pair.y]));
                isVisited[pair.x + 1][pair.y] = true;
            }

            // 向左
            if(pair.y - 1 >= 0 && image[pair.x][pair.y - 1] == val && !isVisited[pair.x][pair.y - 1]){
                queue.offer(new Pair(pair.x,pair.y - 1,image[pair.x][pair.y - 1]));
                isVisited[pair.x][pair.y - 1] = true;
            }

            // 向右
            if(pair.y + 1 < cols && image[pair.x][pair.y + 1] == val && !isVisited[pair.x][pair.y + 1]){
                queue.offer(new Pair(pair.x,pair.y + 1,image[pair.x][pair.y + 1]));
                isVisited[pair.x][pair.y + 1] = true;
            }
        }

        return image;
    }

    static class Pair{
        public int x;
        public int y;
        public int val;

        public Pair() {
        }

        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
