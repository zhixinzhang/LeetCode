package DataStructure.String;

import java.util.*;

/**
 * Created by zhang on 2018/9/17.
 * DataStructure.DP 是最优解 n^2
 */
public class _139_WordBreak_DP_BFS_DFS {
    public boolean wordBreak_DP(String s, List<String> wordDict) {
        // dp[i] = dp[i-j] exist(word(i,j))
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public boolean wordBreak_BFS(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }


    // 这个 recursion 可以 但是TLE 因为没有memoization
    public static boolean wordBreak(String s, List<String> wordDict) {
        return backtrack(0, s, wordDict);
    }
    public static boolean backtrack(int index, String s, List<String> wordDict){
        if(index == s.length())
            return true;
        String nextS = s.substring(index);
        for(String word : wordDict){
            if(nextS.startsWith(word)){
                if (backtrack(index + word.length(), s, wordDict))
                    return true;
            }
        }
        return false;
    }

    public boolean wordBreak_recur(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}
