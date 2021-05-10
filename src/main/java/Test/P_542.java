package Test;

import java.util.LinkedList;
import java.util.Queue;

public class P_542 {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {0,0,0},
//                {0,1,0},
//                {0,0,0}
//        };

        int[][] matrix = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };


        int[][] result = updateMatrix(matrix);
        for(int row = 0;row < matrix.length;row++){
            for(int col = 0;col < matrix[0].length;col++){
                System.out.print(result[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = 0;
        if(rows != 0){
            cols = matrix[0].length;
        }

        int[][] resultMat = new int[rows][cols];
        boolean[][] isVisited = new boolean[rows][cols];
        Queue<Pair> queue = new LinkedList<>();

        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(matrix[row][col] == 0){
                    isVisited[row][col] = true;
                    Pair pair = new Pair();
                    pair.x = row;
                    pair.y = col;
                    pair.val = 0;
                    queue.offer(pair);
                }
            }
        }

        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            int row = pair.x;
            int col = pair.y;
            int val = pair.val;

            // 再用pair去找1的节点，并且因为就差一个节点，所以一定是最小的
            // 向上
            if(row - 1 >= 0){
                if(isVisited[row - 1][col] == false && matrix[row - 1][col] != 0){
                    Pair p = new Pair();
                    p.x = row - 1;
                    p.y = col;
                    p.val = val + 1;
                    isVisited[row - 1][col] = true;
                    resultMat[row - 1][col] = val + 1;
                }
            }

            // 向下
            if(row + 1 < rows){
                if(isVisited[row + 1][col] == false && matrix[row + 1][col] != 0){
                    Pair p = new Pair();
                    p.x = row + 1;
                    p.y = col;
                    p.val = val + 1;
                    isVisited[row + 1][col] = true;
                    resultMat[row + 1][col] = val + 1;
                }
            }

            // 向左
            if(col - 1 >= 0){
                if(isVisited[row][col - 1] == false && matrix[row][col - 1] != 0){
                    Pair p = new Pair();
                    p.x = row;
                    p.y = col - 1;
                    p.val = val + 1;
                    isVisited[row][col - 1] = true;
                    resultMat[row][col - 1] = val + 1;
                }
            }

            // 向右
            if(col + 1 < cols){
                if(isVisited[row][col + 1] == false && matrix[row][col + 1] != 0){
                    Pair p = new Pair();
                    p.x = row;
                    p.y = col + 1;
                    p.val = val + 1;
                    isVisited[row][col + 1] = true;
                    resultMat[row][col + 1] = val + 1;
                }
            }
        }

        return resultMat;
    }

    static class Pair{
        public int x;
        public int y;
        public int val;
    }

}
