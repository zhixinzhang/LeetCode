package DataStructure.Array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solutions/1178332/java-deque-solution-with-explanation/
 * We use 2 of them. One maintains the numbers we have seen so far in decreasing order
 *  (so that max element in the window will be at the front of the queue, or left side of the queue), and the other deque will maintain the numbers we have seen so far in increasing order 
 * (so the min number in the queue will be at the front, aka the left side of the queue).
 * 
 * 
*/
public class _1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanEqualtoLimit_deque {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQ = new LinkedList<>();
        Deque<Integer> minQ = new LinkedList<>();
        
        int start = 0;
        int size = 0;
        
        for (int end = 0; end < nums.length; end++) {
            
            while (!maxQ.isEmpty() && maxQ.peekLast() < nums[end]) {
                maxQ.pollLast();
            } 
            
            while (!minQ.isEmpty() && minQ.peekLast() > nums[end]) {
                minQ.pollLast();
            }
            
            maxQ.addLast(nums[end]);
            minQ.addLast(nums[end]);
            
            if (maxQ.peekFirst() - minQ.peekFirst() > limit) {
                if (nums[start] == maxQ.peekFirst()) {
                    maxQ.pollFirst();
                }
                if (nums[start] == minQ.peekFirst()) {
                    minQ.pollFirst();
                }
                start++;
            }
            
            size = Math.max(size, end - start + 1);
        }
        
        return size;
    }
}
