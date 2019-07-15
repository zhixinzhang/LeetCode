package DataStructure.String;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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
}
