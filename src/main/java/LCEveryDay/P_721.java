package LCEveryDay;

import java.util.*;

public class P_721 {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        String[][] arr = {
                {"John", "johnsmith@mail.com", "john00@mail.com"},
                {"John", "johnnybravo@mail.com"},
                {"John", "john_newyork@mail.com","johnsmith@mail.com"},
                {"Mary", "mary@mail.com"}
        };

        for(String[] strs : arr){
            List<String> list = new ArrayList<>();
            for(String str : strs){
                list.add(str);
            }
            accounts.add(list);
        }

        List<List<String>> lists = accountsMerge(accounts);

        for(List<String> list : lists){
            for(String str : list){
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int nums = accounts.size();
        List<List<String>> resultList = new ArrayList<>();
        if(nums == 0){
            return resultList;
        }

        // 该address --> 对应父
        Map<String,String> map = new HashMap<>();

        // 记录address和owner的对应关系
        Map<String,String> map2 = new HashMap<>();

        // 先对Map进行初始化
        for(List<String> list : accounts){
            if(list.size() > 1){
                String owner = list.get(0);
                String rootAddr = list.get(1);
                map2.put(rootAddr,owner);
                for(int i = 1;i < list.size();i++){
                    map2.put(list.get(i),owner);
                    map.put(list.get(i),rootAddr);
                }
            }
        }

        for(List<String> list : accounts){
            String rootAddr = list.get(1);
            for(int i = 1;i < list.size();i++){
                if(find(map,rootAddr).equals(find(map,list.get(i)))){
                    continue;
                }else{
                    union(map,rootAddr,list.get(i));
                }
            }
        }

        // rootAddr --> list
        Map<String,List<String>> resultMap = new HashMap<>();

        for(Map.Entry<String,String> entry : map.entrySet()){
            String rootAddr = entry.getValue();

            if(!resultMap.containsKey(rootAddr)){
                List<String> list = new ArrayList<>();
                list.add(map2.get(rootAddr));
                list.add(rootAddr);
                if(!rootAddr.equals(entry.getKey())){
                    list.add(entry.getKey());
                }
                resultMap.put(rootAddr,list);
            }else{
                List<String> list = resultMap.get(rootAddr);
                if(!rootAddr.equals(entry.getKey())){
                    list.add(entry.getKey());
                }
            }
        }

        for(Map.Entry<String,List<String>> entry : resultMap.entrySet()){
            Collections.sort(entry.getValue());
            resultList.add(entry.getValue());
        }

        return resultList;
    }

    public static String find(Map<String,String> map,String address){
        if(address != map.get(address)){
            map.put(address,find(map,map.get(address)));
        }
        return map.get(address);
    }

    // 将y合并到x下
    public static void union(Map<String,String> map,String x,String y){
        String rootx = find(map,x);
        String rooty = find(map,y);

        if(rootx == rooty){
            return ;
        }

        map.put(rooty,rootx);
    }


}
