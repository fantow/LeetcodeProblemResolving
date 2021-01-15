package Algo91.Chap01_数组_栈_队列;

import java.util.*;

// 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
// 输出：[[2,4],[1,3],[2,4],[1,3]]
public class P_133 {
    public static void main(String[] args) {
//        int[][] arr = {{2,4},{1,3},{2,4},{1,3}};
//        List<Node> list = new ArrayList<>();
//        for(int i = 1;i <= 4;i++){
//            Node node = new Node(i);
//            list.add(node);
//        }
//
//        for(int i = 0;i < arr.length;i++){
//            int[] ar = arr[i];
//            Node root = list.get(i);
//
//            List<Node> li = new ArrayList<>();
//            for(int j = 0;j < 2;j++){
//                Node no = list.get(ar[j] - 1);
//                li.add(no);
//            }
//            root.neighbors = li;
//        }
//
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//
//        List<Node> l1 = new ArrayList<>();
//        l1.add(node2);
//
//        List<Node> l2 = new ArrayList<>();
//        l2.add(node1);
//
//        node1.neighbors = l1;
//        node2.neighbors = l2;

        Node node1 = new Node(1);

        boolean[] isVisited = new boolean[4];
//        Node root = cloneGraph(list.get(0));
        Node root = cloneGraph(node1);

//        printGraph(list.get(0),isVisited);
        printGraph(node1,isVisited);
        System.out.println(" --- ");

        isVisited = new boolean[4];
        printGraph(root,isVisited);


        List<Node> neighbors = root.neighbors;
        for(Node no : neighbors){
            System.out.print(no.val + " ");
        }

    }


    public static void printGraph(Node node,boolean[] isVisited){
        if(node == null || isVisited[node.val - 1] == true){
            return;
        }

        List<Node> nodes = node.neighbors;
        System.out.print("[ ");
        for(Node n : nodes){
            System.out.print(n.val + " ");
        }
        System.out.println(" ]");

        isVisited[node.val - 1] = true;

        for(Node n : nodes){
            printGraph(n,isVisited);
        }
    }

    public static Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        Set<Integer> visitedSet = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        Map<Integer,Node> map = new HashMap<>();

        queue.add(node);

        while(!queue.isEmpty()){
            Node no = queue.poll();
            Node newNo = null;
            if(map.containsKey(no.val - 1)){
                newNo = map.get(no.val - 1);
            }else{
                newNo = new Node(no.val);
            }

//            System.out.println("newNo : " + newNo.val);
            visitedSet.add(newNo.val);

            List<Node> neighbors = no.neighbors;
            if(neighbors == null || neighbors.size() == 0){
                newNo.neighbors = new ArrayList<>();
            }

            List<Node> newNeighbors = new ArrayList<>();
            for(Node neighbor : neighbors){
                if(!visitedSet.contains(neighbor.val)) {
                    if (!map.containsKey(neighbor.val - 1)) {
                        map.put(neighbor.val - 1, new Node(neighbor.val));
                    }
                    queue.add(neighbor);
                }
                newNeighbors.add(map.get(neighbor.val - 1));
            }
            newNo.neighbors = newNeighbors;
            map.put(newNo.val - 1,newNo);
        }

        return map.get(node.val - 1);
    }
}



class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
