package XianQiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: Xianqiao
 * @Date: 8/3/20 16:48
 */
public class _40_CombinationSumII_recursion {
    /**Given a collection of candidate numbers (candidates) and a target number (target),
     * find all unique combinations in candidates where the candidate numbers sums to target.
     * Each number in candidates may only be used once in the combination.
     * Input: candidates = [10,1,2,7,6,1,5], target = 8,
     * A solution set is:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ] */
    List<List<Integer>> ans = new ArrayList<>();
    HashSet<ArrayList<Integer>> set = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<>(), 0);
        return ans;
    }
    public void helper(int[] candidates, int remain, ArrayList<Integer> path, int start) {
        if (remain == 0) {
            if (!set.contains(path)) {
                ans.add(new ArrayList<>(path));
                set.add(path);
            }
        }
        for (int i = start; i < candidates[i]; i++) {
            if (remain - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            helper(candidates, remain - candidates[i], path, i+1);
            path.remove(path.size() - 1);
        }
    }
}
