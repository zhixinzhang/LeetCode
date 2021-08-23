package Company.LinkedIn;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 8/22/2021 1:20 PM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 *
 * https://leetcode.com/problems/all-oone-data-structure/discuss/91416/Java-AC-all-strict-O(1)-not-average-O(1)-easy-to-read
 */

public class _432_AlloneDataStructure_DoubleLinkedList_BucketSort {

    // maintain a doubly linked list of Buckets
    private Bucket head;
    private Bucket tail;
    // for accessing a specific Bucket among the Bucket list in O(1) time
    private Map<Integer, Bucket> countBucketMap;
    // keep track of count of keys
    private Map<String, Integer> keyCountMap;

    // each Bucket contains all the keys with the same count
    private class Bucket {
        int count;
        Set<String> keySet;
        Bucket next;
        Bucket pre;
        public Bucket(int cnt) {
            count = cnt;
            keySet = new HashSet<>();
        }
    }

    /** Initialize your data structure here. */
    public _432_AlloneDataStructure_DoubleLinkedList_BucketSort() {
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.pre = head;
        countBucketMap = new HashMap<>();
        keyCountMap = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (keyCountMap.containsKey(key)) {
            changeKey(key, 1);
        } else {
            keyCountMap.put(key, 1);
            if (head.next.count != 1)
                addBucketAfter(new Bucket(1), head);
            head.next.keySet.add(key);
            countBucketMap.put(1, head.next);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (keyCountMap.containsKey(key)) {
            int count = keyCountMap.get(key);
            if (count == 1) {
                keyCountMap.remove(key);
                removeKeyFromBucket(countBucketMap.get(count), key);
            } else {
                changeKey(key, -1);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.pre == head ? "" : (String) tail.pre.keySet.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : (String) head.next.keySet.iterator().next();
    }

    // helper function to make change on given key according to offset
    private void changeKey(String key, int offset) {
        int count = keyCountMap.get(key);
        keyCountMap.put(key, count + offset);
        Bucket curBucket = countBucketMap.get(count);
        Bucket newBucket;
        if (countBucketMap.containsKey(count + offset)) {
            // target Bucket already exists
            newBucket = countBucketMap.get(count + offset);
        } else {
            // add new Bucket
            newBucket = new Bucket(count + offset);
            countBucketMap.put(count + offset, newBucket);
            addBucketAfter(newBucket, offset == 1 ? curBucket : curBucket.pre);
        }
        newBucket.keySet.add(key);
        removeKeyFromBucket(curBucket, key);
    }

    private void removeKeyFromBucket(Bucket bucket, String key) {
        bucket.keySet.remove(key);
        if (bucket.keySet.size() == 0) {
            removeBucketFromList(bucket);
            countBucketMap.remove(bucket.count);
        }
    }

    private void removeBucketFromList(Bucket bucket) {
        bucket.pre.next = bucket.next;
        bucket.next.pre = bucket.pre;
        bucket.next = null;
        bucket.pre = null;
    }

    // add newBucket after preBucket
    private void addBucketAfter(Bucket newBucket, Bucket preBucket) {
        newBucket.pre = preBucket;
        newBucket.next = preBucket.next;
        preBucket.next.pre = newBucket;
        preBucket.next = newBucket;
    }
}
