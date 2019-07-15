package company.uber;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by zhang on 2018/9/17.
 * https://leetcode.com/problems/interleaving-string/discuss/31904/Summary-of-solutions-BFS-DFS-DP
 */
public class _97_InterleavingString_DFS_BFS_DP {

    public boolean isInterleave_DFS(String s1, String s2, String s3){
        if (s1.length() + s2.length() != s3.length()) return false;
        HashSet<Integer> cache = new HashSet<Integer>();
        return dfs(s1, s2, s3, 0, 0, cache);
    }
    private boolean dfs(String s1, String s2, String s3, int p1, int p2, HashSet<Integer> cache){
        if (p1 + p2 == s3.length())         // return case
            return true;
        if (cache.contains(p1 * s3.length() + p2))
            return false;
        cache.add(p1 * s3.length() + p2);
        boolean match1 = p1 < s1.length() && s3.charAt(p1 + p2) == s1.charAt(p1);
        boolean match2 = p2 < s2.length() && s3.charAt(p1 + p2) == s2.charAt(p2);

        if (match1 && match2)
            return dfs(s1, s2, s3, p1 + 1, p2, cache) ||
                    dfs(s1, s2, s3, p1, p2 + 1, cache);
        else if (match1)
            return dfs(s1, s2, s3, p1 + 1, p2, cache);
        else if (match2)
            return dfs(s1, s2, s3, p1, p2 + 1, cache);
        else
            return false;
    }

    public boolean isInterleave_BFS(String s1, String s2, String s3) {
        int len1 = s1.length(),
                len2 = s2.length(),
                len3 = s3.length();
        if (len1 + len2 != len3) return false;
        Deque<Integer> queue = new LinkedList<>();
        int matched = 0;
        queue.offer(0);
        Set<Integer> set = new HashSet<>();
        while (queue.size() > 0 && matched < len3) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int p1 = queue.peek() / len3,
                        p2 = queue.peek() % len3;
                queue.poll();
                if (p1 < len1 && s1.charAt(p1) == s3.charAt(matched)) {
                    int key = (p1 + 1) * len3 + p2;
                    if (!set.contains(key)) {
                        set.add(key);
                        queue.offer(key);
                    }
                }
                if (p2 < len2 && s2.charAt(p2) == s3.charAt(matched)) {
                    int key = p1 * len3 + (p2 + 1);
                    if (!set.contains(key)) {
                        set.add(key);
                        queue.offer(key);
                    }
                }
            }
            matched++;
        }
        return queue.size() > 0 && matched == len3;
    }

}
