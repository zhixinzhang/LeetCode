package Company.Ebay;

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

    // O(n * log k) 用minHeap
    public static int[] topKFrequent_PriorityQueue(int[] nums, int k) {
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

    // Quick Select 
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int[] unique = new int[hm.size()];
        int index = 0;
        for(int key : hm.keySet()) {
            unique[index++] = key;
        }
        
        quickselect(0, unique.length - 1, unique.length - k, unique, hm);

        return Arrays.copyOfRange(unique, unique.length - k, unique.length);
    }

    public void quickselect(int start, int end, int k, int[] unique, Map<Integer, Integer> hm) {

        int left = start;
        int right = end - 1;
        int pivot = end;

        while(left <= right) {

            if(hm.get(unique[left]) > hm.get(unique[pivot])) {
                swap(left, right, unique);
                right--;
            } else {
                left++;
            }

        }

        swap(left, pivot, unique);

        if(left == k) return;

        if (left < k) {
            quickselect(left + 1, end, k, unique, hm);
        } else {
            quickselect(start, left - 1, k, unique, hm);
        }
        
    }

    public void swap(int left, int right, int[] nums) {

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
