package Hot100;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_399 {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        List<String> list2 = new ArrayList<>();
        list2.add("b");
        list2.add("c");

        List<String> list3 = new ArrayList<>();
        list3.add("x3");
        list3.add("x4");

        List<String> list4 = new ArrayList<>();
        list4.add("x4");
        list4.add("x5");

        equations.add(list1);
        equations.add(list2);
//        equations.add(list3);
//        equations.add(list4);


        double[] values = {2.0,3.0};
//        double[] values = {3.0,4.0,5.0,6.0};

        List<List<String>> queries = new ArrayList<>();
        List<String> l11 = new ArrayList<>();
        l11.add("a");
        l11.add("c");

        List<String> l12 = new ArrayList<>();
        l12.add("b");
        l12.add("a");

        List<String> l13 = new ArrayList<>();
        l13.add("a");
        l13.add("e");

        List<String> l1 = new ArrayList<>();
        l1.add("a");
        l1.add("a");
        List<String> l2 = new ArrayList<>();
        l2.add("x");
        l2.add("x");

//        List<String> l22 = new ArrayList<>();
//        l22.add("x9");
//        l22.add("x9");

        queries.add(l11);
        queries.add(l12);
        queries.add(l13);
        queries.add(l1);
        queries.add(l2);
//        queries.add(l22);

        double[] doubles = calcEquation(equations, values, queries);
        for(double d : doubles){
            System.out.print(d + " ");
        }
    }


    public static Map<String,String> parent = new HashMap<>();
    public static Map<String,Double> dist = new HashMap<>();

    public static String find(String x){
        if(parent.get(x) != x){
            String t = find(parent.get(x));
            dist.put(x, dist.get(x) * dist.get(parent.get(x)));
            parent.put(x,t);
        }

        return parent.get(x);
    }

    // 本题应该使用并查集，实在不熟
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int length = equations.size();

        double[] resultArr = new double[queries.size()];
        if(length == 0){
            return resultArr;
        }

        // 初始化parent和dist数组
        for(int i = 0;i < length;i++){
            List<String> list = equations.get(i);
            String a = list.get(0);
            String b = list.get(1);

            parent.put(a,a);
            parent.put(b,b);

            dist.put(a,1.0);
            dist.put(b,1.0);
        }

        // 合并集合
        for(int i = 0;i < length;i++){
            List<String> list = equations.get(i);
            String a = list.get(0);
            String b = list.get(1);

            double value = values[i];

            // 将b成为a的root
            String roota = find(a);

            // 更新roota
            parent.put(roota,b);
            dist.put(roota,value / dist.getOrDefault(a,1.0));
        }

        // 求解结果
        for(int i = 0;i < queries.size();i++){
            List<String> list = queries.get(i);
//            System.out.println(list);
            String a = list.get(0);
            String b = list.get(1);

            if(!parent.containsKey(a) || !parent.containsKey(b) || find(a) != find(b)){
                resultArr[i] = -1.0;
            }else{
                resultArr[i] = dist.get(a) / dist.get(b);
            }
        }

        for(Map.Entry<String,String> entry : parent.entrySet()){
            System.out.print(entry.getKey() + " : " + entry.getValue());
            System.out.println();
        }

        for(Map.Entry<String,Double> entry : dist.entrySet()){
            System.out.print(entry.getKey() + " : " + entry.getValue());
            System.out.println();
        }


        return resultArr;
    }



    // 题目假设了不存在算不出的情况
//    public static double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        int length = equations.size();
//
//        // a ->  b:2 ,c:3
//        Map<String,Map<String,Double>> map = new HashMap<>();
//        for(int i = 0;i < length;i++){
//            List<String> list = equations.get(i);
//
//            String s1 = list.get(0);
//            String s2 = list.get(1);
//
//            if(map.containsKey(s1)){
//                Map<String, Double> integerMap = map.get(s1);
//                integerMap.put(s2,values[i]);
//            }else{
//                Map<String,Double> m1 = new HashMap<>();
//                m1.put(s1,1.0);
//                m1.put(s2,values[i]);
//                map.put(s1,m1);
//            }
////            Map<String,Double> mm = new HashMap<>();
////            mm.put(s2,1.0);
////            map.put(s2,mm);
//
//            if(map.containsKey(s2)){
//                Map<String, Double> map1 = map.get(s2);
//                map1.put(s1,1/values[i]);
//            }else{
//                Map<String,Double> m1 = new HashMap<>();
//                m1.put(s2,1.0);
//                m1.put(s1,1/values[i]);
//                map.put(s2,m1);
//            }
//        }
//
//        System.out.println(map);
//
//        double[] resultArr = new double[queries.size()];
//
//        for(int i = 0;i < queries.size();i++){
//            // 除数
//            String a = queries.get(i).get(0);
//
//            // 被除数
//            String b = queries.get(i).get(1);
//
////            System.out.println(a + " " + b);
//
//            if(!map.containsKey(a) || !map.containsKey(b)){
//                resultArr[i] = -1.0;
//                continue;
//            }
//
//            Map<String, Double> map1 = map.get(a);
//            if(map1.containsKey(b)){
//                resultArr[i] = map1.get(b);
//            }else {
//                // 如果不包含，就需要去推导了
//                for (Map.Entry<String, Double> entry : map1.entrySet()) {
//                    Map<String, Double> map2 = map.get(entry.getKey());
//                    if (map2.containsKey(b)) {
//                        // 这里拿到的是 a 下 的 某个元素与b的关系
//                        Double d2 = map2.get(b);
//                        BigDecimal bd = new BigDecimal(entry.getValue());
//                        BigDecimal bd2 = new BigDecimal(d2);
//                        resultArr[i] = bd.multiply(bd2).doubleValue();
//                    } else {
//                        continue;
//                    }
//                }
//            }
//        }
//        System.out.println(map);
//
//        return resultArr;
//    }
}
