package DataStructure.Array;
import java.util.*;

public class _2023_NumberPairsStringsWithConcatenationEqualTargetMap {
    public int numOfPairs(String[] nums, String target) {
        int cnt = 0, n = target.length();
        Map<Integer, Integer> prefix = new HashMap<>(), suffix = new HashMap<>();
        for (String num : nums) {
            int sz = num.length();
            if (target.startsWith(num)) {
                cnt += suffix.getOrDefault(n - sz, 0);
            }
            if (target.endsWith(num)) {
                cnt += prefix.getOrDefault(n - sz, 0);
            }
            if (target.startsWith(num)) {
                prefix.put(sz, 1 + prefix.getOrDefault(sz, 0));
            }
            if (target.endsWith(num)) {
                suffix.put(sz, 1 + suffix.getOrDefault(sz, 0));
            }
        }
        return cnt;
    }
}
