package DataStructure.Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Luke Zhang
 * @Date 2021-04-29 14:21
 *
 * https://leetcode.com/problems/smallest-string-with-swaps/discuss/388055/Java-Union-find-%2B-PriorityQueue.-Easy-to-understand.
 * https://zxi.mytechroad.com/blog/graph/leetcode-1202-smallest-string-with-swaps/
 */
public class _1202_SmallestStringWithSwaps_UnionFind_DFS {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s == null || s.length() <= 1 || pairs == null || pairs.size() == 0) {
            return s;
        }
        int[] parents = new int[s.length()];
        for (List<Integer> pair : pairs){
            union(parents, pair.get(0), pair.get(1));
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            int root = find(i, parents);
            map.putIfAbsent(root, new PriorityQueue<>());
            map.get(root).add(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            int root = find(i, parents);
            sb.append(map.get(root).poll());
        }

        return sb.toString();
    }

    private void union(int[] parents, int aParent, int bParent){
        aParent = find(aParent, parents);
        bParent = find(bParent, parents);

        if (aParent < bParent) {
            parents[bParent] = aParent;
        } else {
            parents[aParent] = bParent;
        }
    }

    private int find(int index, int[] parents){
        while (parents[index] != index) {
            parents[index] = parents[parents[index]];
            index = parents[index];
        }

        return index;
    }
}
