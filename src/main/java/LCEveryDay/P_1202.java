package LCEveryDay;
import java.util.*;

//输入：s = "dcab", pairs = [[0,3],[1,2]]
//输出："bacd"
//解释：
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[1] 和 s[2], s = "bacd"




//"udyyek"
//        [[3,3],[3,0],[5,1],[3,1],[3,4],[3,5]]


//"pwqlmqm"
//        [[5,3],[3,0],[5,1],[1,1],[1,5],[3,0],[0,2]]

public class P_1202 {
    public static void main(String[] args) {
        String s = "pwqlmqm";
        List<List<Integer>> pairs = new ArrayList<>();

        List<Integer> l1 = new ArrayList<>();
        l1.add(5);
        l1.add(3);

        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(0);

        List<Integer> l3 = new ArrayList<>();
        l3.add(5);
        l3.add(1);

        List<Integer> l4 = new ArrayList<>();
        l4.add(1);
        l4.add(1);

        List<Integer> l5 = new ArrayList<>();
        l5.add(1);
        l5.add(5);

        List<Integer> l6 = new ArrayList<>();
        l6.add(3);
        l6.add(0);

        List<Integer> l7 = new ArrayList<>();
        l7.add(0);
        l7.add(2);

        pairs.add(l1);
        pairs.add(l2);
        pairs.add(l3);
        pairs.add(l4);
        pairs.add(l5);
        pairs.add(l6);
        pairs.add(l7);




//        String s = "udyyek";
//        List<List<Integer>> pairs = new ArrayList<>();
//
//        List<Integer> l1 = new ArrayList<>();
//        l1.add(3);
//        l1.add(3);
//
//        List<Integer> l2 = new ArrayList<>();
//        l2.add(3);
//        l2.add(0);
//
//        List<Integer> l3 = new ArrayList<>();
//        l3.add(5);
//        l3.add(1);
//
//        List<Integer> l4 = new ArrayList<>();
//        l4.add(3);
//        l4.add(1);
//
//        List<Integer> l5 = new ArrayList<>();
//        l5.add(3);
//        l5.add(4);
//
//        List<Integer> l6 = new ArrayList<>();
//        l6.add(3);
//        l6.add(5);
//
//        pairs.add(l1);
//        pairs.add(l2);
//        pairs.add(l3);
//        pairs.add(l4);
//        pairs.add(l5);
//        pairs.add(l6);

////        String s = "dcab";
//        String s = "cba";
//        List<List<Integer>> pairs = new ArrayList<>();
//
//        List<Integer> l1 = new ArrayList<Integer>();
//        l1.add(0);
////        l1.add(3);
//        l1.add(1);
//
//
//        List<Integer> l2 = new ArrayList<Integer>();
//        l2.add(1);
//        l2.add(2);
//
////        List<Integer> l3 = new ArrayList<>();
////        l3.add(0);
////        l3.add(2);
//
//
//        pairs.add(l1);
//        pairs.add(l2);
////        pairs.add(l3);

        String result = smallestStringWithSwaps(s, pairs);

        System.out.println(result);
    }


    // 并差集也有问题：比如：{(0,2),(0,3),(1,1),(1,5),(3,5)}   -->  这样做得并查集无法将1合并到0的集合中。
    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int length = s.length();

        if(length <= 1){
            return s;
        }

        for(List<Integer> pair : pairs){
            int left = pair.get(0);
            int right = pair.get(1);

            if(left > right){
                pair.set(0,right);
                pair.set(1,left);
            }
        }

        Collections.sort(pairs,new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if(o1.get(0) == o2.get(0)){
                    return o1.get(1) - o2.get(1);
                }else{
                    return o1.get(0) - o2.get(0);
                }
            }
        });

//        for(List<Integer> li : pairs){
//            for(Integer i : li){
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }

        // 维护一个并差集数组
        int[] arr = new int[s.length()];

        // 初始化
        for(int i = 0;i < s.length();i++){
            arr[i] = i;
        }

        for(List<Integer> pair : pairs){
            union(arr,pair.get(0),pair.get(1));
        }


        for(int i = 0;i < arr.length;i++){
            arr[i] = find(arr,i);
        }


        Map<Integer,PriorityQueue<Character>> map = new HashMap<>();
        // 需要知道一共被分为了几组
        for(int i = 0;i < arr.length;i++){
            if(map.containsKey(arr[i])){
                map.get(arr[i]).offer(s.charAt(i));
            }else{
                PriorityQueue<Character> queue = new PriorityQueue<>();
                queue.offer(s.charAt(i));
                map.put(arr[i],queue);
            }
        }

//        for(int i : arr){
//            System.out.print(i + " ");
//        }
//        System.out.println();

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < arr.length;i++){
            PriorityQueue<Character> queue = map.get(arr[i]);
            sb.append(queue.poll());
        }

        return sb.toString();
    }


    // 这个已经是支持路径压缩的find了
    public static int find(int[] nums,int x){
        if(nums[x] != x){
            nums[x] = find(nums,nums[x]);
        }
        return nums[x];
    }

    public static void union(int[] nums,int from,int to){
        if(find(nums,from) != find(nums,to)){
            nums[find(nums,to)] = find(nums,from);
        }
    }


    // 不能这么做，即使排序了，也会有分错组的问题，应该使用并差集
    public static String WrongsmallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int length = s.length();

        if(length <= 1){
            return s;
        }

        for(List<Integer> pair : pairs){
            int left = pair.get(0);
            int right = pair.get(1);

            if(left > right){
                int temp = left;
                left = right;
                right = temp;
            }
        }

        // 需要对pairs进行排序
        Collections.sort(pairs, new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0) == o2.get(0)) {
                    return o1.get(1) - o2.get(1);
                }else{
                    return o1.get(0) - o2.get(0);
                }
            }
        });

        List<List<Integer>> list = new ArrayList<>();

        for(List<Integer> pair : pairs){
            if(list.isEmpty()){
                List<Integer> li = new ArrayList<>();

                if(pair.get(0) == pair.get(1)){
                    li.add(pair.get(0));
                }else{
                    li.add(pair.get(0));
                    li.add(pair.get(1));
                }

                list.add(li);
                continue;
            }

            boolean flag = false;
            for(List<Integer> li : list){
                if(li.contains(pair.get(0)) || li.contains(pair.get(1))){
                    // 因为可能两个都包含了，所以不能直接用else
                    if(!li.contains(pair.get(0))){
                        li.add(pair.get(0));
                    }else if(!li.contains(pair.get(1))){
                        li.add(pair.get(1));
                    }
                    flag = true;
                }
            }

            // 该pair中的元素不属于任意一个set
            if(!flag){
                List<Integer> li = new ArrayList<>();

                if(pair.get(0) == pair.get(1)){
                    li.add(pair.get(0));
                }else{
                    li.add(pair.get(0));
                    li.add(pair.get(1));
                }
                list.add(li);
            }
        }

        for(List<Integer> li : list){
            Collections.sort(li);
        }

        for(List<Integer> li : list){
            for(Integer i : li){
                System.out.print(i + " ");
            }
            System.out.println();
        }


        // 要求字典序最小
        char[] chars = s.toCharArray();

        for(List<Integer> li : list){
            List<Character> chList = new ArrayList<>();
            for(Integer idx : li){
                chList.add(s.charAt(idx));
            }

            Collections.sort(chList);

            for(int i = 0;i < chList.size();i++){
                chars[li.get(i)] = chList.get(i);
            }
        }

        String result = new String(chars);

        return result;
    }

}
