package Hot100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P_207 {
    public static void main(String[] args) {
//        int numCourses = 2;
//        int[][] prerequisites = {{1,0}};
//        int[][] prerequisites = {{1,0},{0,1}};

//        int numCourses = 5;
//        int[][] prerequisites = {{3,0},{1,0},{3,1},{2,1},{4,2},{4,3}};
//        int[][] prerequisites = {{3,0},{1,0},{3,1},{2,1},{4,2},{4,3},{1,4}};


        int numCourses = 3;
        int[][] prerequisites = {{1,0}};

        boolean flag = canFinish(numCourses, prerequisites);

        System.out.println(flag);
    }


    // 使用DFS来做
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int length  = prerequisites.length;

        // 有向图应该是使用邻接表存储
        ListNode[] graphArr = new ListNode[numCourses];

        for(int i = 0;i < numCourses;i++){
            graphArr[i] = new ListNode(i);
        }

        for(int i = 0;i < length;i++){
            // 获取先行课代码
            int[] tempArr = prerequisites[i];

            int preNo = tempArr[1];
            int no = tempArr[0];

            ListNode node = graphArr[preNo];

            // 使用头插法插入
            ListNode tempNode = new ListNode(no);
            tempNode.next = node.next;
            node.next = tempNode;
        }

        int[] visited = new int[numCourses];
        // 使用DFS
        for(int i = 0;i < numCourses;i++){
            if(!dfs(visited,i,graphArr)){
                return false;
            }
        }

        return true;
    }

    public static boolean dfs(int[] visited,int idx,ListNode[] graphArr){
        for(int i : visited){
            System.out.print(i + " ");
        }
        System.out.println();
        ListNode node = graphArr[idx];
        int idx1 = node.val;
        if(visited[node.val] == 1){
            return false;
        }else if(visited[node.val] == -1){
            return true;
        }

        visited[idx1] = 1;
        node = node.next;
        while(node != null){
            if(!dfs(visited,node.val,graphArr)){
                return false;
            }
            node = node.next;
        }

        visited[idx1] = -1;
        return true;
    }



    // 使用邻接表+BFS来做
    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
        int length  = prerequisites.length;

        // 有向图应该是使用邻接表存储
        ListNode[] graphArr = new ListNode[numCourses];

        for(int i = 0;i < numCourses;i++){
            graphArr[i] = new ListNode(i);
        }


        int[] inArr = new int[numCourses];
        for(int i = 0;i < length;i++){
            // 获取先行课代码
            int[] tempArr = prerequisites[i];

            int preNo = tempArr[1];
            int no = tempArr[0];

            inArr[no]++;

//            if(graphArr[preNo] == null){
//                ListNode node = new ListNode(preNo);
//                graphArr[preNo] = node;
//            }
//
//            if(graphArr[no] == null){
//                ListNode node = new ListNode(no);
//                graphArr[no] = node;
//            }

            ListNode node = graphArr[preNo];

            // 使用头插法插入
            ListNode tempNode = new ListNode(no);
            tempNode.next = node.next;
            node.next = tempNode;
        }

//        for(int i = 0;i < numCourses;i++){
//            ListNode node = graphArr[i];
//            while(node != null){
//                System.out.print(node.val + " ");
//                node = node.next;
//            }
//            System.out.println();
//        }


        for(int i = 0;i < numCourses;i++){
            System.out.println(i + " -> " + inArr[i]);
        }

        // 使用BFS判断是否有环
        // 先找到入度为0的节点入队

        Queue<ListNode> queue = new LinkedList<>();

        int idx = -1;
        for(int i = 0;i < numCourses;i++){
            if(inArr[i] == 0){
                queue.add(graphArr[i]);
            }
        }

        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            node = node.next;
            while(node != null){
                inArr[node.val]--;

                if(inArr[node.val] == 0){
                    queue.offer(graphArr[node.val]);
                }

                node = node.next;
            }
        }

        for(int i = 0;i < numCourses;i++){
            if(inArr[i] != 0){
                return false;
            }
        }

        return true;
    }

    // 应该是要求这个图是否有环
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        int length  = prerequisites.length;

        // 有向图应该是使用邻接表存储
        ListNode[] graphArr = new ListNode[length];

        for(int i = 0;i < length;i++){
            // 获取先行课代码
            int[] tempArr = prerequisites[i];

            int preNo = tempArr[1];
            int no = tempArr[0];

            if(graphArr[preNo] == null){
                ListNode node = new ListNode(preNo);
                graphArr[preNo] = node;
            }

            ListNode node = graphArr[preNo];

            // 使用头插法插入
            ListNode tempNode = new ListNode(no);
            tempNode.next = node.next;
            node.next = tempNode;
        }

        for(int i = 0;i < length;i++){
            int[] arr = prerequisites[i];
            int preNo = arr[1];
            int no = arr[0];

            ListNode node1 = graphArr[preNo];
            while(node1 != null && node1.val != no){
                node1 = node1.next;
            }

            ListNode node2 = graphArr[no];
            while(node2 != null && node2.val != preNo){
                node2 = node2.next;
            }

            if(node1 != null || node2 != null){
                return false;
            }
        }

        return true;
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
