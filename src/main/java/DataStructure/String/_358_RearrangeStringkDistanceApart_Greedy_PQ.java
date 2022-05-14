package DataStructure.String;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/6/19
 * Time: 11:44 AM
 * Description:
 */


public class _358_RearrangeStringkDistanceApart_Greedy_PQ {
    public static void main(String[] args){
        rearrangeString("aaadbbcc", 2);
    }
    public static String rearrangeString(String s, int k) {
        if(k==0) return s;
        int[] freq = new int[26];
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) freq[c - 'a']++;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i = 0; i < 26; i++) if(freq[i] > 0) pq.add(new int[]{i, freq[i]});
        Queue<int[]> q = new LinkedList<>();
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            ans.append((char)(current[0] + 'a'));
            current[1]--;
            q.add(current);
            if (q.size() >= k) {
                int[] front = q.poll();
                if (front[1] > 0) pq.add(front);
            }
        }
        return ans.length() == s.length() ? ans.toString() : "";
    }


    public String rearrangeString_Sort(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        // Use a max heap to do the greedy part
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
                (c1, c2) -> countMap.get(c2) - countMap.get(c1));
        maxHeap.addAll(countMap.keySet());

        // Use wait queue for each iteration of k elements
        Queue<Character> waitQueue = new LinkedList<>();

        StringBuilder rearranged = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Character current = maxHeap.poll();
            rearranged.append(current);
            countMap.put(current, countMap.get(current) - 1);
            waitQueue.offer(current);

            if (waitQueue.size() < k) {
                continue;
            }
            // Release from waitQueue if char is already k apart
            Character front = waitQueue.poll();
            if (countMap.get(front) > 0) {
                maxHeap.offer(front);
            }
        }

        return rearranged.length() == s.length() ? rearranged.toString() : "";
    }
}
