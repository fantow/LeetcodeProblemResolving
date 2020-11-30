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
        list1.add("x1");
        list1.add("x2");
        List<String> list2 = new ArrayList<>();
        list2.add("x2");
        list2.add("x3");

        List<String> list3 = new ArrayList<>();
        list3.add("x3");
        list3.add("x4");

        List<String> list4 = new ArrayList<>();
        list4.add("x4");
        list4.add("x5");

        equations.add(list1);
        equations.add(list2);
        equations.add(list3);
        equations.add(list4);


        double[] values = {3.0,3.0,5.0,6.0};

        List<List<String>> queries = new ArrayList<>();
        List<String> l11 = new ArrayList<>();
        l11.add("x1");
        l11.add("x5");

        List<String> l12 = new ArrayList<>();
        l12.add("x5");
        l12.add("x2");

        List<String> l13 = new ArrayList<>();
        l13.add("x2");
        l13.add("x4");

        List<String> l1 = new ArrayList<>();
        l1.add("x2");
        l1.add("x2");
        List<String> l2 = new ArrayList<>();
        l2.add("x2");
        l2.add("x9");

        List<String> l22 = new ArrayList<>();
        l2.add("x9");
        l2.add("x9");

        queries.add(l11);
        queries.add(l12);
        queries.add(l13);
        queries.add(l1);
        queries.add(l2);
        queries.add(l22);

        double[] doubles = calcEquation(equations, values, queries);
        for(double d : doubles){
            System.out.print(d + " ");
        }
    }

    // 题目假设了不存在算不出的情况
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int length = equations.size();

        // a ->  b:2 ,c:3
        Map<String,Map<String,Double>> map = new HashMap<>();
        for(int i = 0;i < length;i++){
            List<String> list = equations.get(i);

            String s1 = list.get(0);
            String s2 = list.get(1);

            if(map.containsKey(s1)){
                Map<String, Double> integerMap = map.get(s1);
                integerMap.put(s2,values[i]);
            }else{
                Map<String,Double> m1 = new HashMap<>();
                m1.put(s1,1.0);
                m1.put(s2,values[i]);
                map.put(s1,m1);
            }
//            Map<String,Double> mm = new HashMap<>();
//            mm.put(s2,1.0);
//            map.put(s2,mm);

            if(map.containsKey(s2)){
                Map<String, Double> map1 = map.get(s2);
                map1.put(s1,1/values[i]);
            }else{
                Map<String,Double> m1 = new HashMap<>();
                m1.put(s2,1.0);
                m1.put(s1,1/values[i]);
                map.put(s2,m1);
            }
        }

        System.out.println(map);

        double[] resultArr = new double[queries.size()];

        for(int i = 0;i < queries.size();i++){
            // 除数
            String a = queries.get(i).get(0);

            // 被除数
            String b = queries.get(i).get(1);

//            System.out.println(a + " " + b);

            if(!map.containsKey(a) || !map.containsKey(b)){
                resultArr[i] = -1.0;
                continue;
            }

            Map<String, Double> map1 = map.get(a);
            if(map1.containsKey(b)){
                resultArr[i] = map1.get(b);
            }else {
                // 如果不包含，就需要去推导了
                for (Map.Entry<String, Double> entry : map1.entrySet()) {
                    Map<String, Double> map2 = map.get(entry.getKey());
                    if (map2.containsKey(b)) {
                        // 这里拿到的是 a 下 的 某个元素与b的关系
                        Double d2 = map2.get(b);
                        BigDecimal bd = new BigDecimal(entry.getValue());
                        BigDecimal bd2 = new BigDecimal(d2);
                        resultArr[i] = bd.multiply(bd2).doubleValue();
                    } else {
                        continue;
                    }
                }
            }
        }
        System.out.println(map);

        return resultArr;
    }
}
