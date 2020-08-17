package JZOffer;

import java.util.*;

/**
 * @Description:
 * @Author chenyang270
 * @CreateDate
 * @Version: 1.0
 */
public class P_40 {
    public static void main(String[] args) {
//        ---- test1 ----
        int[] arr = {3,2,1};
        int k = 2;

//        ---- test2 ----
//        int[] arr = {0,1,2,1};
//        int k = 1;

        int[] list = getLeastNumbers4(arr, k);

        for(int a : list){
            System.out.println(a);
        }
    }
    // 最简单的方式，先对数组排序，再取前k个
    public static int[] getLeastNumbers1(int[] arr, int k) {
        int length = arr.length;
        if(length < k){
            return new int[]{};
        }

        Arrays.sort(arr);


        return Arrays.copyOfRange(arr,0,k);
    }

    // 使用快排，如果本次的temp排序结果就是第k个，那就表明前k-1个元素一定是k-1小的
    public static List<Integer> resultList = new ArrayList<>();
    public static int[] getLeastNumbers2(int[] arr,int k){
        int length = arr.length;
        if(length == 0){
            return new int[]{};
        }
        if(length == 1){
            return arr;
        }
        if(length < k){
            return new int[]{};
        }

        int[] resultArr = null;
        quickSort(arr,0,length - 1,k);
        if(resultList.size() != 0) {
            resultArr = new int[resultList.size()];
            int i = 0;
            for (int a : resultList) {
                resultArr[i++] = a;
            }
        }else{
            // 可能的一种情况是直接排好序了，没有走到pivotPos == k - 1这一步
            // 那就直接从已经排好序的arr中拿出
            resultArr = Arrays.copyOfRange(arr,0,k);
        }

        return resultArr;
    }

    public static void quickSort(int[] arr,int left,int right,int k){
        if(left < right){
            int pivotPos = partition(arr,left,right);
            if(pivotPos == k - 1){
                for(int i = 0;i < k;i++){
                    resultList.add(arr[i]);
                }
                return;
            }

            if(pivotPos < k){
                quickSort(arr,pivotPos + 1,right,k);
            }else{
                quickSort(arr,left,right - 1,k);
            }

        }
    }


    // 返回的是本次的arr[left] 在arr中排在第几位
    public static int partition(int[] arr,int left,int right){

        int temp = arr[left];
        while(left < right){
            while(left < right && arr[right] >= temp){
                right--;
            }
            arr[left] = arr[right];

            while(left < right && arr[left] <= temp){
                left++;
            }
            arr[right] = arr[left];
        }

        arr[left] = temp;
        return left;
    }


    // 方法3:使用大根堆,每次Poll出最大值，那最后堆中剩下的就是TopK小的
    public static int[] getLeastNumbers3(int[] arr,int k){
        int length = arr.length;

        if(length == 0){
            return new int[]{};
        }
        if(length == 1){
            return arr;
        }
        if(length < k){
            return new int[]{};
        }

        // 现在是大根堆
        Queue<Integer> stack = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int a : arr){
            if(stack.size() < k){
                stack.offer(a);
            }else if(a < stack.peek()){
                stack.poll();
                stack.offer(a);
            }
        }

        int[] arrResult = new int[stack.size()];
        int index = 0;
        while(!stack.isEmpty()){
            arrResult[index++] = stack.poll();
        }

        return arrResult;
    }

    // 方法4：使用TreeMap，原理和大根堆一样
    public static int[] getLeastNumbers4(int[] arr,int k){
        int length = arr.length;
        if(length == 0 || length < k){
            return new int[]{};
        }
        if(length == 1){
            return arr;
        }

        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        int count = 0;

        for(int a : arr){
            if(count < k){
                treeMap.put(a,treeMap.getOrDefault(a,0) + 1);
                count++;
            }else{
                Map.Entry<Integer, Integer> lastEntry = treeMap.lastEntry();
                if(lastEntry.getKey() > a){
                    treeMap.put(a,treeMap.getOrDefault(a,0) + 1);
                    if(lastEntry.getValue() == 1){
                        treeMap.pollLastEntry();
                    }else{
                        treeMap.put(lastEntry.getKey(),lastEntry.getValue() - 1);
                    }
                }
            }
        }

        int[] arrResult = new int[k];
        int index = 0;
        for(Map.Entry<Integer,Integer> entry : treeMap.entrySet()){
            int value = entry.getValue();
            while(value-- > 0){
                arrResult[index++] = entry.getKey();
            }
        }

        return arrResult;
    }

}
