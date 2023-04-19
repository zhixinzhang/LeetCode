package Company.Sofi;

import java.util.HashMap;
import java.util.Map;

/**
 * Suppose you have an array int[]. A subarray is "clean" if it has at least k distinct numbers in it.
 *  Return the size of the smallest "clean" subarray
 * */ 
public class _340_SmallestSubstringwithAtMostKDistinctCharacters_TwoPointer {
     public static void main(String[] args) {
        int[] arrs = new int[]{1, 2, 2, 3, 4, 5, 5, 6, 6, 7};   // 2,3,4 smallest longest with k (k = 3)   1 2, 2,3,4 smallest longest with k (k = 4)
        findSmallestCleanSubarray(arrs, 4);
    }

    public static void findSmallestCleanSubarray(int[] arr, int k){
        int start = 0;
        int maxLen = Integer.MAX_VALUE;
        // Key: letter; value: the number of occurrences.
        Map<Integer, Integer> map = new HashMap<>();
        int i;
        for (i = 0; i < arr.length; ++i) {
            int val = arr[i];

            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
                while (map.size() > k) {
                    int leftVal = arr[start++];
                    int count = map.get(leftVal);
                    if (count > 1) {
                        map.put(leftVal, count - 1);
                    } else {
                        map.remove(leftVal);
                    }
                }
            }

            if (map.size() == k) {
                maxLen = Math.min(maxLen, i - start + 1);
            }
        }
            
        System.out.println("smallest length is : " + maxLen);
        
    }
}
