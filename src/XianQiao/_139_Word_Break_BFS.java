package XianQiao;

import java.util.*;

/**
 * @Author: Xianqiao
 * @Date: 6/27/20 15:39
 */
public class _139_Word_Break_BFS {
    /** Given Solution */
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordDictSet = new HashSet(wordDict);
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[s.length()]; //int [] not int
        q.add(0);
        while (!q.isEmpty()) {
            int start = q.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end < s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        q.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
            }
            visited[start] = 1;
        }
        return false;
    }
}
