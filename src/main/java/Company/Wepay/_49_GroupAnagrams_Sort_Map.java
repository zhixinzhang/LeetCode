package Company.Wepay;
import java.util.*;

public class _49_GroupAnagrams_Sort_Map {
    /**
     * Time Complexity: O(NKlog⁡K)O(NK \log K)O(NKlogK), where NNN is the length of strs, and KKK is the maximum length of a string in strs. The outer loop has complexity O(N)O(N)O(N) as we iterate through each string. Then, we sort each string in O(Klog⁡K)O(K \log K)O(KlogK) time.

Space Complexity: O(NK)O(NK)O(NK), the total information content stored in ans.
     */
    public List<List<String>> groupAnagramsSort(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // Instead of sorting, we can also build the key string in this way. Thanks @davidluoyes for pointing this out.
    // Time Complexity: O(NK)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
