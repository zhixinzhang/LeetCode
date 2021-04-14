package Company.PG;

import java.util.*;

/**
 * Created by zhang on 2018/1/26.
 * Given a non-empty array of integers, return the k most frequent elements.
 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].
 */

public class _347_TopKFrequentElements_PriorityQueue_TreeMap_bucket {
    //3 solution
    //1 priorityQueue  hashMap to store num(key) freq(value) O(nlogk)
    // for loop hashMap and put entry to priorityQueue according the freq
    // 1 3 5 2  ---- > 5 3 2 1  find Kth freq
    //2 TreeMap
    //buid a hashmap to store the num and freq
    // for loop the hashmap and take entry to TreeMap(sorted tree structure)
    // return the kth result.

    //3 bucket
    //build int[] bucket = [nums.length-1] and index to store List<DataStructure.Integer>
    // 2 freq have 3 num  [1,1,2,2,3,3,3,4,4,4] [0,1,2,3,4,5,6,7,8,9] --- [null,null,{1,2},{3,4}]
    // return the kth element from last index to kth
    // O (n * log n)
    public List<Integer> topKFrequent_PriorityQueue(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();			 //num freq
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap =
                new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }
        List<Integer> res = new ArrayList<>();
        while(res.size() < k){
            Map.Entry<Integer,Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }

    // O(n * log k) 用minHeap
    public static int[] topKFrequent_PriorityQueue_(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return new int[0];
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        while (k > 0){
            k--;
            res[k] = minHeap.poll().getKey();
        }

        return res;
    }

    //TreeMap
    public List<Integer> topKFrequent_TreeMap(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();			 //num freq
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        TreeMap<Integer,List<Integer>> freqMap = new TreeMap<>();
        for(int num : map.keySet()){
            int freq = map.get(num);
            if(freqMap.containsKey(freq)){
                freqMap.get(freq).add(num);
            }else{
                freqMap.put(freq, new LinkedList<>());
                freqMap.get(freq).add(num);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(res.size() < k){
            Map.Entry<Integer,List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }
    // 因为存在频率一样的数字 所以 用List<DataStructure.Integer>[] O(n)
    public List<Integer> topKFrequent_Bucket(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();			 //num freq
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for(int num : map.keySet()){
            int freq = map.get(num);
            if(bucket[freq] == null){
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(num);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = bucket.length - 1; i>= 0 ;i--){
            if(bucket[i] != null){
                res.addAll(bucket[i]);
            }
            if(res.size() == k) break;
        }
        return res;
    }

    public static void main(String[] args){
//        topKFrequent_PriorityQueue_(new int[]{1,1,1,2,2,3}, 2);
        bucket(new int[]{1,1,1,2,2,3}, 2);
    }

    private static int[] bucket (int[] nums, int k){
        if (nums == null || nums.length < 0) {
            return new int[0];
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] res = new int[k];
        int m = 0;
        a : for(int i = nums.length; i >= 0; i--){
            List<Integer> curVal = bucket[i];
            if (curVal == null) {
                continue;
            }
            for (int j = 0; j < curVal.size(); j++){
                if (m >= k)
                    break a;
                res[m] = curVal.get(j);
                m++;
            }
        }

        return res;
    }
}
